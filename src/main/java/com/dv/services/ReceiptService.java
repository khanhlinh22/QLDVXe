/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services;

import com.dv.pojo.Cart;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ReceiptService {
     void addReceipt(List<Cart> carts);
}
