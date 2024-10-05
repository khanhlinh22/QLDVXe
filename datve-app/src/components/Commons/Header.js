import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Badge, Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row, Spinner } from "react-bootstrap";
import MySpinner from "./MySpinner";
import { Link, useNavigate } from "react-router-dom";
import { MyCartContext, MyDispatchContext, MyUserContext } from "../../App";

const Header = () => {
    const [tuyenxes, setTuyenXes] = useState(null);
    const [kw, setKw] = useState("");
    const nav = useNavigate();
    const [cartCounter, ] = useContext(MyCartContext);
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);

    //load tuyen xe
    const loadTX = async () => {
        try {
            let res = await APIs.get(endpoints['tuyenxes']);
            setTuyenXes(res.data);

        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadTX();
    }, [])


    const submit = (event) => {
        event.preventDefault();
        nav(`/?kw=${kw}`);
    }


    return (
        // Tai sao truyen dung du lieu
        <Navbar expand="lg" className="bg-body-tertiary" style={{ color: '#fff' }}>
            <Container>
                <Navbar.Brand href="#home" >Đặt Vé Xe</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">

                        <Link to="/" className="nav-link" >Trang Chủ</Link>

                        <NavDropdown title="Danh mục" id="basic-nav-dropdown"  >

                            {tuyenxes === null ?
                                <MySpinner /> :
                                <>
                                    {tuyenxes.map(c => {
                                        let url = `/?tuyenXeId=${c.id}`;
                                        return <Link to={url} className="nav-link " key={c.id}>{c.tenTuyen}</Link>
                                    })}
                                </>
                            }
                        </NavDropdown>
                        {user === null ? <>
                            <Link className='nav-link text-success' to="/login">&#129489; Đăng nhập</Link>
                            <Link className='nav-link text-success' to="/register">&#129489; Đăng ký</Link>


                        </> : <>
                            <Link className='nav-link text-success' to="/login">
                                <Image src={user.avatar} width="25" roundedCircle />
                                Chào {user.username}!</Link>
                            <Button variant='danger' onClick={() => dispatch({ "type": "logout" })}>Đăng xuất</Button>
                        </>}
                        <Link className='nav-link text-danger' to="/cart">&#128722; <Badge bg='danger'>{cartCounter}</Badge></Link>
                    </Nav>
                </Navbar.Collapse>

                <Form inline onSubmit={submit}>
                    <Row>
                        <Col xs="auto">
                            <Form.Control value={kw} onChange={e => setKw(e.target.value)}
                                type="text"
                                placeholder="Nhập từ khóa"
                                className=" mr-sm-2"
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Tìm</Button>
                        </Col>
                    </Row>
                </Form>
            </Container>
        </Navbar>
    );

}

export default Header;