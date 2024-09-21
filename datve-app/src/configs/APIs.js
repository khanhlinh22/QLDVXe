import axios from "axios";

const BASE_URL ="http://localhost:8080/QLDatVe/";

export const endpoints ={
    'tuyenxes': '/api/tuyenxes/',
    'chuyenxes': '/api/chuyenxes/'

};
export default axios.create({
    baseURL: BASE_URL
});