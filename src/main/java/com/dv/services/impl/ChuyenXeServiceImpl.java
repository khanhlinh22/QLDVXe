/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dv.pojo.ChuyenXe;
import com.dv.repositoties.ChuyenXeRepository;
import com.dv.services.ChuyenXeService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service

public class ChuyenXeServiceImpl implements ChuyenXeService{
    
    @Autowired
    private ChuyenXeRepository chuyenXeRepo;
    @Autowired
    private Cloudinary cloudinary;


    @Override
    public List<ChuyenXe> getChuyenXes(Map<String, String> params) {
         return this.chuyenXeRepo.getChuyenXes(params);
    }

    @Override
    public void addOrUpdate(ChuyenXe cx) {
        if (!cx.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(cx.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                
                cx.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ChuyenXeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.chuyenXeRepo.addOrUpdate(cx);
    }

    @Override
    public ChuyenXe getChuyenXeById(int id) {
          return this.chuyenXeRepo.getChuyenXeById(id);

    }

    @Override
    public void deleteChuyenXe(int id) {
              this.chuyenXeRepo.deleteChuyenXe(id);
    }
    
    

}
