/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.ThanhToan;
import com.dv.repositoties.ThanhToanRepository;
import com.dv.services.ThanhToanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ThanhToanServiceImpl implements ThanhToanService{
     @Autowired
    private ThanhToanRepository thanhToanRepo;

    @Override
    public List<ThanhToan> getThanhToans() {
        return this.thanhToanRepo.getThanhToans();
    }
     
  
    
}
