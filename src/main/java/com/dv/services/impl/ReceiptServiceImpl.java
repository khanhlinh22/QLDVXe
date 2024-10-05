/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.Cart;
import com.dv.repositoties.ReceiptRepository;
import com.dv.services.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
     @Autowired
    private  ReceiptRepository receiptRepo;

    @Override
    public void addReceipt(List<Cart> carts) {
       this.receiptRepo.addReceipt(carts);
    }
}
