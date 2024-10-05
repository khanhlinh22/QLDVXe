import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = "http://localhost:8080/QLDatVe/";

export const endpoints = {
    'tuyenxes': '/api/tuyenxes/',
    'chuyenxes': '/api/chuyenxes/',
    'details': (chuyenXeId) => `/api/chuyenxes/${chuyenXeId}`,
    'register': '/api/nguoidungs/',
    'login': '/api/login/',
    'current-user': '/api/current-user/',
    'pay': '/api/pay/'


}

// console.info(cookie.load('token'))

export const authAPI = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization':  cookie.load('access-token'),
            'Content-Type': 'application/json' 
        }
    })
}
export default axios.create({
    baseURL: BASE_URL
});