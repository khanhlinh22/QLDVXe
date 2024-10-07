import cookie from "react-cookies";

const MyCartReducer = (currentState, action) => {
    if (action.type === 'update-cart') {
        let cart = cookie.load("cart") || null;
        if (cart !== null) {
            let totalQuantity = 0;
            for (let c of Object.values(cart))
                totalQuantity += c.soChoDat;

            return totalQuantity;
        }
    }
    
    return currentState;
}
export default MyCartReducer;