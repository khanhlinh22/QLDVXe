/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.TaiXe;
import com.dv.repositoties.TaiXeRepository;
import com.dv.services.TaiXeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class TaiXeServiceImpl implements TaiXeService{
     @Autowired
    private TaiXeRepository taiXeRepo;
    @Override
    public List<TaiXe> getTaiXes() {
        return this.taiXeRepo.getTaiXes();
    }
    
}
