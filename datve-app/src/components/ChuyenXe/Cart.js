import { useContext, useEffect, useReducer, useState } from "react";
import { Button, Form, Table } from "react-bootstrap";
import cookie from "react-cookies";
import { MyCartContext, MyUserContext } from "../../App";
import { authAPI, endpoints } from "../../configs/APIs";
import MyCartReducer from "../../reducers/MyCartReducer";

const Cart = () => {
    const user = useContext(MyUserContext);
    const [, dispatch] = useContext(MyCartContext);

    const initialCart = cookie.load('cart') || {}; // Tải dữ liệu từ cookie
    const [cart, dispatchCart] = useReducer(MyCartReducer, initialCart);

    const [message, setMessage] = useState('');
    const [paymentMethod, setPaymentMethod] = useState("CASH"); // Default payment method

    useEffect(() => {
        const storedCart = cookie.load('cart');
        if (storedCart) {
            dispatchCart({ type: 'initialize-cart', payload: storedCart });
        }
    }, []);

    const handleQuantityChange = (id, event) => {
        const newCart = { ...cart };
        newCart[id].soChoDat = event.target.value;
        cookie.save('cart', newCart, { path: '/' });
        dispatchCart({ type: 'update-cart', payload: newCart });
    };

    const handlePaymentMethodChange = (event) => {
        setPaymentMethod(event.target.value);
    };

    const pay = async () => {
        try {
            const cartsWithPaymentMethod = Object.values(cart).map(cartItem => ({
                ...cartItem,
                hinhThucThanhToan: paymentMethod
            }));
            const response = await authAPI().post(endpoints.pay, cartsWithPaymentMethod);
            setMessage("Thanh toán thành công");

            dispatchCart({ type: 'Paid' });
            cookie.remove('cart', { path: '/' });
        } catch (error) {
            console.error('Error during payment', error.response.data);
            if (error.response && error.response.data && error.response.data.message) {
                setMessage("Thanh toán thất bại: " + error.response.data.message);
            } else {
                setMessage("Thanh toán thất bại");
            }
        }
    };
 

    const handleDelete = (id) => {
        const newCart = { ...cart };
        delete newCart[id]; // Xóa chuyến xe với id tương ứng
        cookie.save('cart', newCart, { path: '/' }); // Cập nhật lại cookie
        dispatchCart({ type: 'update-cart', payload: newCart }); // Cập nhật giỏ hàng
    };

    const totalAmount = Object.values(cart).reduce((total, cartItem) => {
        return total + (cartItem.soChoDat * cartItem.soTien);
    }, 0);

    return (
        <>
            <h1 className="text-center text-info mt-3">Giỏ Hàng</h1>
            {Object.keys(cart).length === 0 ? <p>Không có sản phẩm trong giỏ</p> : <>
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
                            <td><img src={c.image} alt="Chuyến xe" style={{ width: '50px' }} /></td>
                            <td>{c.tuyenXeId?.tenTuyen || 'Unknown'}</td>
                            <td>{c.giaVe}</td>
                            <td>{c.ngayGioKhoiHanh ? new Date(c.ngayGioKhoiHanh).toLocaleString() : 'N/A'}</td>
                            <td>
                                <Form.Control
                                    type="number"
                                    value={c.soChoDat || 0}
                                    onChange={event => handleQuantityChange(c.id, event)}
                                />
                            </td>
                            <td>{c.trangThai}</td>
                            <td>
                                <Button variant="danger" onClick={() => handleDelete(c.id)}>&times;</Button>
                            </td>
                        </tr>)}
                    </tbody>
                </Table>

                <Form.Group controlId="paymentMethod">
                    <Form.Label>Phương thức thanh toán</Form.Label>
                    <Form.Control
                        as="select"
                        value={paymentMethod}
                        onChange={handlePaymentMethodChange}
                    >
                        <option value="CASH">Tiền mặt</option>
                        <option value="VNPAY">VNPay</option>
                        <option value="DEBIT">Debit</option>
                    </Form.Control>
                </Form.Group>

                <h4>Tổng số tiền: {totalAmount} VND</h4>
                {user !== null && <Button onClick={pay} className="btn btn-info mb-1">Thanh toán</Button>}
                {message && <p>{message}</p>}
            </>}
        </>
    );
};

export default Cart;