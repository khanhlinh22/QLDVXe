import { useContext, useEffect, useReducer, useState } from "react";
import { Button, Form, Table } from "react-bootstrap";
import cookie from "react-cookies";
import { MyCartContext, MyUserContext } from "../../App";
import { authAPI, endpoints } from "../../configs/APIs";
import MyCartReducer from "../../reducers/MyCartReducer";

const Cart = () => {
    const user = useContext(MyUserContext);
    // console.log("Current user state:", user); // In giá trị của user để kiểm tra

    const [, dispatch] = useContext(MyCartContext);

    const initialCart = cookie.load('cart') || {}; // Load cart data from cookie
    const [cart, dispatchCart] = useReducer(MyCartReducer, initialCart);

    const [message, setMessage] = useState('');
    const [paymentMethod, setPaymentMethod] = useState("CASH"); // Default payment method
    const [storedCart, setStoredCart] = useState(cookie.load("cart") || null); // Renamed cartTT to storedCart

    useEffect(() => {
        const storedCartData = cookie.load('cart');
        console.log("Stored cart data:", storedCartData); // Log the stored cart data

        if (storedCartData) {
            dispatchCart({ type: 'initialize-cart', payload: storedCartData });
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
            // Prepare the cart data to be sent to the backend
            const cartsWithPaymentMethod = Object.values(cart).map(cartItem => ({
                chuyenXeId: cartItem.id,  // Bus trip ID
                tuyenXeId: cartItem.tuyenXeId,    // Route ID
                soChoDat: cartItem.soChoDat,      // Number of seats booked
                hinhThucThanhToan: paymentMethod  // Payment method (e.g., CASH, VNPAY, DEBIT)
            }));
    
            console.log("Cart data being sent to backend:", cartsWithPaymentMethod);
            console.log("Calling endpoint:", endpoints['pay']);

            // Send the payment request to the backend
            let res = await authAPI().post(endpoints['pay'], cartsWithPaymentMethod);
    
            console.log("Payment response:", res.data); // In ra phản hồi từ server
    
            // On success, show success message and clear cart
            setMessage("Thanh toán thành công");
            dispatchCart({ type: 'Paid' });
            cookie.remove('cart', { path: '/' });
        } catch (error) {
            console.error('Error during payment', error);
        
            if (error.response && error.response.data && error.response.data.message) {
                setMessage("Thanh toán thất bại: " + error.response.data.message);
            } else if (error.response && error.response.status) {
                setMessage("Thanh toán thất bại với mã lỗi: " + error.response.status);
            } else {
                setMessage("Thanh toán thất bại do một lỗi không xác định");
            }
        }
            };
    

    const handleDelete = (id) => {
        const newCart = { ...cart };
        delete newCart[id]; // Remove bus trip with the corresponding id
        cookie.save('cart', newCart, { path: '/' });
        dispatchCart({ type: 'update-cart', payload: newCart });
    };

    return (
        <>
            <h1 className="text-center text-info mt-3">Giỏ Hàng</h1>
            {Object.keys(cart).length === 0 ? <p>Không có sản phẩm trong giỏ</p> : <>
                <Table striped bordered hover size="sm">
                    <thead>
                        <tr>
                            <th>ID</th>
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
                        {Object.values(cart).map(c => (
                            <tr key={c.id}>
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
                            </tr>
                        ))}
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

                {user !== null && (

                    <Button onClick={pay} className="btn btn-info mb-1">
                        Thanh toán
                    </Button>
                )}
                {message && <p>{message}</p>}
            </>}
        </>
    );
};

export default Cart;
