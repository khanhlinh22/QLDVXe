import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Button, Card, Col, Row } from "react-bootstrap";
import MySpinner from "../Commons/MySpinner";
import { useSearchParams } from "react-router-dom";
import cookie from "react-cookies";
import { format } from 'date-fns';
import { MyCartContext } from "../../App";


const Home = () => {
    const [chuyenxes, setChuyenXes] = useState([]);
    const [loading, setLoading] = useState(false);
    const [q,] = useSearchParams();
    const [page, setPage] = useState(1);
    const [ ,dispatch ] = useContext(MyCartContext);  // sử dụng MyCartContext để dispatch hành động


    const loadCX = async () => {
        setLoading(true);
        try {
            let url = `${endpoints['chuyenxes']}?page=${page}`;
            let tuyenXeId = q.get('tuyenXeId');
            if (tuyenXeId) {
                url = `${url}&tuyenXeId= ${tuyenXeId}`;
                setPage(1);
            }
            else {
                let kw = q.get('kw');
                if (kw) {
                    url = `${url}&kw=${kw}`;
                    setPage(1);
                }
            }
            let res = await APIs.get(url);
            console.log("API Response:", res.data);  // Check API response
            console.log("API Status Code:", res.status);  // Check status code
            const data = Array.isArray(res.data) ? res.data : [];
            if (page === 1) {

                setChuyenXes(data);
            }
            else if (page > 1)
                setChuyenXes(current => {
                    return [...current, ...data];
                })


        } catch (ex) {
            console.error("Error fetching data:", ex);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        loadCX();
    }, [q, page]);

    const loadMore = () => {
        if (!loading)
            setPage(page + 1);
    }

    const addCart = (cx) => {
        let cart = cookie.load("cart") || null;
        const formattedDate = format(new Date(cx.ngayGioKhoiHanh), 'dd/MM/yyyy HH:mm');
        const ngayGioKhoiHanh = cx.ngayGioKhoiHanh; // lấy giá trị ngày giờ
        const size = new Blob([ngayGioKhoiHanh]).size; // tính kích thước
        console.log("Kích thước ngayGioKhoiHanh:", size);
    
        console.log("Before saving to cart:", formattedDate);
        if (cart === null)
            cart = {};
        if (cx.id in cart) {
            cart[cx.id]["soChoDat"]++;
        }
        else {
            cart[cx.id] = {
                "id": cx.id,
                "image": cx.image,
                "tuyenXeId": cx.tuyenXeId,
                "giaVe": cx.giaVe,
                "ngayGioKhoiHanh": cx.ngayGioKhoiHanh, 
                "soCho": cx.soCho,
                "trangThai": cx.trangThai,
                "soChoDat": 1
            }
        }
        // cookie.save("cart", cart);
        cookie.save("cart", cart, { path: '/' });
        console.log("update", cart);
        dispatch({
            type: 'update-cart',
            payload: countCart()
        });
    }

    // useEffect(() => {
    //     console.log("Chuyenxes state:", chuyenxes);  // Check state
    // }, [chuyenxes]);

    const countCart = () =>{
        let count = 0;
        let cart = cookie.load("cart") || null;
        if(cart !== null)
        {
            for(let c of Object.values(cart))
                count += c.soChoDat;
        }
        else
        {
            count = 0;
        }
        return count;
    }
    return (
        <>
            {loading && <MySpinner />}
            <Row>
                {Array.isArray(chuyenxes) && chuyenxes.length > 0 ? (
                    chuyenxes.map(cx => {
                        const formattedDate = format(new Date(cx.ngayGioKhoiHanh), 'dd/MM/yyyy HH:mm');  // Format ngày giờ
                        return (
                            <Col key={cx.id} md={3} xs={12} className="p-2">
                                <Card>
                                    <Card.Img
                                        variant="top"
                                        src={cx.image || 'default_image.jpg'}
                                        alt="Chuyến xe"
                                        onError={(e) => e.target.src = 'default_image.jpg'}
                                    />
                                    <Card.Body>
                                        <Card.Title>{cx.tuyenXeId?.tenTuyen || 'Unknown Route'}</Card.Title>
                                        <Card.Text>
                                            {cx.giaVe || 'Giá'} -{formattedDate || 'Date'} - {cx.soCho || 'Seats'}  - {cx.trangThai || 'Action'}
                                        </Card.Text>
                                        <Button variant="primary" className="m-1">Xem chi tiết</Button>
                                        <Button variant="danger" className="m-1" onClick={() => addCart(cx)}> Đặt vé</Button>
                                    </Card.Body>
                                </Card>
                            </Col>
                           
                        );
                    })
                ) : (
                    <p>No data available</p>
                )}
            </Row>
            {loading && page > 1 && <MySpinner />}
            <div className="text-center mt-2">
                <Button variant="success" onClick={loadMore}>Xem Thêm</Button>
            </div>
        </>
    );
};

export default Home;