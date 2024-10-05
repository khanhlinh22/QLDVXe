/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.pojo.KhachHang;
import com.dv.repositoties.KhachHangRepository;
import com.dv.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepo;

    @Override
    public KhachHang getKhachHangById(int id) {
        return this.khachHangRepo.getKhachHangById(id);
    }

}
