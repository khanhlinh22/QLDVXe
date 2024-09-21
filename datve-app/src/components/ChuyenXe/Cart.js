import { useState } from "react";
import { Button, Form, Table } from "react-bootstrap";
import cookie from "react-cookies";

const Cart = () => {
    const [cart, setCart] = useState(cookie.load('cart') || {});
    return (
        <>
            <h1 className="text-center text-info mt-3">Giỏ Hàng</h1>
            {cart === null ? <p>Không có sản phẩm trong giỏ</p> : <>
                <Table striped bordered hover size="sm">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Hình Ảnh</th>
                            <th>Tên Tuyến</th>
                            <th>Giá</th>
                            <th>Giờ Khởi Hành</th>
                            <th>Số Chỗ</th>
                            <th>Trạng Thái</th>
                            <th></th>
                        </tr>
                    </thead>
                   
                    <tbody>
                    {Object.values(cart).map(c => <tr key={c.id}>
                            <td>{c.id}</td>
                            <td> <img src={c.image} alt="Chuyến xe" style={{ width: '50px' }} /></td>
                            <td>{c.tuyenXeId?.tenTuyen || 'Unknown'}</td>
                            <td>{c.giaVe}</td>                           
                            <td>{c.ngayGioKhoiHanh ? new Date(c.ngayGioKhoiHanh).toLocaleString() : 'N/A'}</td>
                            <td>{c.soCho}</td>
                            <td>{c.trangThai}</td>
                            <td>
                                <Form.Control value={c.quantity}/>
                            </td>
                            <td>
                                <Button variant="danger">&times</Button>
                            </td>
                        </tr>)}

                    </tbody>
                </Table>

                <Button variant="success" className="mt-1">Thanh Toán</Button>
            </>}

        </>
    );
}

export default Cart;