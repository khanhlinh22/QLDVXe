import React from 'react';
import styled from 'styled-components';

const FooterContainer = styled.footer`
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
    font-weight: bold;
`;

const SocialMedia = styled.div`
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
    
    a {
        margin: 0 4px;
        text-decoration: none; /* Xóa gạch chân khỏi liên kết */
    }
`;

const InfoContainer = styled.div`
    display: flex;
    justify-content: space-between; /* Căn giữa các phần thông tin */
    width: 100%; /* Đảm bảo chiếm toàn bộ chiều rộng */
    max-width: 800px; /* Giới hạn chiều rộng tối đa */
`;

const InfoColumn = styled.div`
    font-size: x-small;
    display: flex;
    flex-direction: column;
    margin-bottom: 10px;
    width: 30%; /* Đảm bảo mỗi phần thông tin chiếm 30% chiều rộng */
`;

const Separator = styled.hr`
    border: none;
    height: 1px;
    background-color: black;
    width: 100%;
    margin: 10px 0; /* Thêm khoảng cách giữa các phần */
`;

const Footer = () => {
    return (
        <FooterContainer>
            <h1>CÔNG TY XE LINH VI</h1>
            <Separator />
            <SocialMedia>
                <a href="/" target="_blank" rel="noopener noreferrer">LinkedIn</a>
            </SocialMedia>
            <InfoContainer>
                <InfoColumn>
                    <div>Software Engineer LV</div>
                    <div>
                        Returns Policy
                        <br />
                        Delivery
                    </div>        
                </InfoColumn>
                <InfoColumn>
                    <div>lvticket.info@gmail.com</div>
                    <div>
                        Terms and Conditions
                        <br />
                        Copyright@2024
                    </div>
                </InfoColumn>
                <InfoColumn>
                    <div>0968063333</div>
                    <div>
                        My Story
                        <br />
                        Contact Us
                    </div>
                </InfoColumn>
            </InfoContainer>
            <Separator />
        </FooterContainer>
    );
};

export default Footer;
