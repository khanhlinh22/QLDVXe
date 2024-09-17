/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.DatVe;
import com.dv.pojo.TuyenXe;
import com.dv.repositoties.DatVeRepository;
import com.dv.repositoties.TuyenXeRepository;
import com.dv.services.DatVeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class DatVeServiceImpl implements DatVeService{
     @Autowired
    private DatVeRepository  datVeRepo ;
    @Override
    public List<DatVe> getDatVes() {
        return this.datVeRepo.getDatVes();
    }
}
