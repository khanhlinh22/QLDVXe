import Header from "./components/Commons/Header";
import Footer from "./components/Commons/Footer";
import Home from "./components/ChuyenXe/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Container } from "react-bootstrap";
import Cart from "./components/ChuyenXe/Cart";
import { CartContext } from "./configs/Context";
import { useReducer } from "react";
import { CartReducer } from "./configs/Reducers";

const App = () => {
  const [value,dispatch] =useReducer(CartReducer,0);
  return (
    
    <BrowserRouter>
      <CartContext.Provider value={[value, dispatch]}>
        <Header />
        <Container>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/cart" element={<Cart />} />
          </Routes>
        </Container>
        <Footer />
      </CartContext.Provider>

    </BrowserRouter>
  );
}

export default App;