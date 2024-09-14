/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;


import com.dv.pojo.Xe;
import com.dv.repositoties.XeRepository;
import com.dv.services.XeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class XeServiceImpl implements XeService{
     @Autowired
    private XeRepository xeRepo;
    @Override
    public List<Xe> getXes() {
        return this.xeRepo.getXes();
    }
}
