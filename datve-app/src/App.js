import React, { createContext, useReducer, useState, useEffect } from 'react';
import Header from "./components/Commons/Header";
import Footer from "./components/Commons/Footer";
import Home from "./components/ChuyenXe/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Container } from "react-bootstrap";
import Cart from "./components/ChuyenXe/Cart";
import Register from "./components/NguoiDung/Register";
import Login from "./components/NguoiDung/Login";
import MyUserReducer from "./reducers/MyUserReducer";
import MyCartReducer from "./reducers/MyCartReducer";
import { Webchat, WebchatProvider, Fab, getClient } from "@botpress/webchat";
import { buildTheme } from "@botpress/webchat-generator";

// Add your Client ID here
const clientId = "ae5e3394-6fa5-4717-b36c-f774ad502b3f";

// Create contexts
export const MyUserContext = createContext();
export const MyDispatchContext = createContext();
export const MyCartContext = createContext();

// Create your chat configuration here
const { theme } = buildTheme({
  themeName: "prism",
  themeColor: "#634433",
});

// Các câu trả lời mẫu cho chatbot
const botResponses = {
  greeting: "Xin chào! Tôi là chatbot của Công ty vận tải Linh Vi. Tôi có thể giúp gì cho bạn hôm nay?",
  locationInquiry: "Công ty Linh Vi có trụ sở chính tại 123 Đường Lê Lợi, Thành phố Hồ Chí Minh.",
  companyHistory: "Công ty Vi Linh đã hoạt động trong ngành vận tải hơn 10 năm, với mục tiêu cung cấp dịch vụ chất lượng cao cho khách hàng.",
  ticketBookingMethods: "Bạn có thể đặt vé qua website của chúng tôi hoặc qua điện thoại. Các hình thức thanh toán bao gồm VNPay, thẻ tín dụng, và tiền mặt.",
  routes: "Chúng tôi cung cấp nhiều tuyến xe từ Thành phố Hồ Chí Minh đến Hà Nội, Đà Nẵng, Nha Trang và nhiều địa điểm khác.",
  scheduleInquiry: "Vui lòng cho tôi biết tuyến xe bạn muốn biết, và tôi sẽ cung cấp lịch trình cho bạn.",
  promotions: "Hiện tại, chúng tôi đang có chương trình khuyến mãi 20% cho khách hàng đặt vé trực tuyến trong tháng này.",
  ticketPolicy: "Nếu bạn cần thay đổi hoặc hủy vé, xin vui lòng liên hệ với bộ phận chăm sóc khách hàng của chúng tôi.",
  shuttleService: "Có, chúng tôi cung cấp dịch vụ đưa đón tận nơi cho khách hàng trong khu vực nội thành.",
  specialPolicies: "Chúng tôi có chính sách ưu đãi cho trẻ em và người cao tuổi khi đặt vé. Vui lòng tham khảo thêm trên website của chúng tôi.",
};

// Sử dụng trong chatbot
function getResponse(userMessage) {
  if (userMessage.includes("trụ sở")) {
    return botResponses.locationInquiry;
  } else if (userMessage.includes("bao nhiêu năm")) {
    return botResponses.companyHistory;
  } else if (userMessage.includes("hình thức thanh toán")) {
    return botResponses.ticketBookingMethods;
  } else if (userMessage.includes("tuyến xe")) {
    return botResponses.routes;
  } else if (userMessage.includes("thời gian")) {
    return botResponses.scheduleInquiry;
  } else if (userMessage.includes("khuyến mãi")) {
    return botResponses.promotions;
  } else if (userMessage.includes("thay đổi hoặc hủy")) {
    return botResponses.ticketPolicy;
  } else if (userMessage.includes("đưa đón tận nơi")) {
    return botResponses.shuttleService;
  } else if (userMessage.includes("chính sách trẻ em")) {
    return botResponses.specialPolicies;
  } else {
    return botResponses.greeting; // Trả lời mặc định
  }
}

const App = () => {
  // User and cart state
  const initialUserState = { name: "", email: "", isNew: false }; // Thêm thuộc tính isNew
  const [user, dispatch] = useReducer(MyUserReducer, initialUserState);

  const initialCartState = JSON.parse(localStorage.getItem('cartCounter')) || 0;
  const [cartCounter, cartDispatch] = useReducer(MyCartReducer, initialCartState);

  // Webchat state
  const [isWebchatOpen, setIsWebchatOpen] = useState(false);
  const [isExpanded, setIsExpanded] = useState(false); // State để theo dõi trạng thái phóng to
  const [chatConfig, setChatConfig] = useState({
    composerPlaceholder: "Bạn muốn hỏi gì?",
    botName: "Dịch vụ khách hàng",
    botAvatar: "https://picsum.photos/200/300",
    botDescription: "Xin chào! 👋 Chào mừng bạn đến với dịch vụ chat trực tuyến. Hãy cho chúng tôi biết bạn cần hỗ trợ gì.",
  }); // Trạng thái cấu hình chat

  const client = getClient({ clientId });

  const toggleWebchat = () => {
    setIsWebchatOpen((prevState) => !prevState);
  };

  const toggleExpand = () => {
    setIsExpanded((prevState) => !prevState);
  };

  // Cập nhật cấu hình chatbot khi người dùng mới đăng nhập
  useEffect(() => {
    // Kiểm tra nếu user không phải là null và có thuộc tính isNew
    if (user && user.isNew) {
      setChatConfig((prevConfig) => ({
        ...prevConfig,
        botName: `Chatbot Mới của ${user.name}`, // Tùy chỉnh tên bot cho người dùng mới
        botDescription: "Chào mừng bạn đến với dịch vụ chat trực tuyến mới!",
      }));
    } else {
      // Đặt lại cấu hình về mặc định nếu người dùng không phải là mới
      setChatConfig({
        composerPlaceholder: "Bạn muốn hỏi gì?",
        botName: "Dịch vụ khách hàng",
        botAvatar: "https://picsum.photos/200/300",
        botDescription: "Xin chào! 👋 Chào mừng bạn đến với dịch vụ chat trực tuyến. Hãy cho chúng tôi biết bạn cần hỗ trợ gì.",
      });
    }
  }, [user]); // Chạy effect này khi user thay đổi

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
        <MyCartContext.Provider value={[cartCounter, cartDispatch]}>
          <BrowserRouter>
            <Header />
            <WebchatProvider client={client} theme={theme} config={chatConfig}>
              <Container>
                <Routes>
                  <Route path='/' element={<Home />} />
                  <Route path='/login' element={<Login />} />
                  <Route path='/register' element={<Register />} />
                  <Route path='/cart' element={<Cart />} />
                </Routes>
              </Container>

              <Fab onClick={toggleWebchat} aria-label="Open web chat" />
              <div className={`${isWebchatOpen ? "webchat-visible" : "webchat-hidden"} ${isExpanded ? "webchat-expanded" : ""}`}>
                <Webchat
                  config={{
                    ...chatConfig,
                    onMessage: (message) => {
                      // Lấy câu trả lời từ botResponses
                      const botReply = getResponse(message.text);
                      // Gửi câu trả lời về cho chatbot
                      return { text: botReply };
                    }
                  }}
                />
                <button onClick={toggleExpand} style={{ position: 'absolute', top: '5px', right: '5px' }}>
                  {isExpanded ? "Thu Nhỏ" : "Phóng To"}
                </button>
              </div>
            </WebchatProvider>
            <Footer />
          </BrowserRouter>
        </MyCartContext.Provider>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
  );
};

export default App;
