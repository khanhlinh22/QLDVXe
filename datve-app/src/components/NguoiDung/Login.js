import { useContext, useState, useEffect } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import cookie from "react-cookies";
import { MyDispatchContext, MyUserContext } from "../../App";
import APIs, { authAPI, endpoints } from "../../configs/APIs";
import { Navigate } from "react-router-dom";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState(""); // Trạng thái thông báo lỗi
    const [loading, setLoading] = useState(false); // Trạng thái loading
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);

    const login = async (e) => {
        e.preventDefault();
        setLoading(true); // Bắt đầu loading

        try {
            let res = await APIs.post(endpoints['login'], {
                "username": username, 
                "password": password
            });

            cookie.save("access-token", res.data);

            let user = await authAPI().get(endpoints['current-user']);
            cookie.save("user", user.data);
            // localStorage.setItem("user", JSON.stringify(user.data)); // Lưu vào localStorage

            dispatch({
                "type": "login",
                "payload": user.data
            });

            // Reset input sau khi đăng nhập thành công
            setUsername("");
            setPassword("");
            setErrorMessage(""); // Đặt lại thông báo lỗi

        } catch(ex) {
            console.error(ex);
            setErrorMessage("Đăng nhập thất bại. Vui lòng kiểm tra tên đăng nhập và mật khẩu."); // Cập nhật thông báo lỗi
        } finally {
            setLoading(false); // Kết thúc loading
        }
    }

    // Khôi phục người dùng từ localStorage khi component được mount
    // useEffect(() => {
    //     const savedUser = localStorage.getItem("user");
    //     if (savedUser) {
    //         dispatch({
    //             "type": "login",
    //             "payload": JSON.parse(savedUser) // Chuyển đổi chuỗi JSON thành đối tượng
    //         });
    //     }
    // }, [dispatch]);

    if (user !== null) {
        return <Navigate to="/" />;
    }

    return (
        <>
            <h1 className="text-center text-info mt-1">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

            {errorMessage && <Alert variant="danger">{errorMessage}</Alert>} {/* Hiển thị thông báo lỗi */}

            <Form method="post" onSubmit={login}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Tên đăng nhập</Form.Label>
                    <Form.Control 
                        type="text" 
                        placeholder="Tên đăng nhập..." 
                        value={username} 
                        onChange={e => setUsername(e.target.value)} 
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control 
                        type="password" 
                        placeholder="Mật khẩu..." 
                        value={password} 
                        onChange={e => setPassword(e.target.value)}  
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Button type="submit" variant="success" disabled={loading}>
                        {loading ? "Đang đăng nhập..." : "Đăng nhập"} {/* Thay đổi văn bản nút khi đang tải */}
                    </Button>
                </Form.Group>
            </Form>
        </>
    );
}

export default Login;
