/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.KhachHang;
import com.dv.repositoties.KhachHangRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class KhachHangRepositoryImpl implements KhachHangRepository{

      @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public KhachHang getKhachHangById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(KhachHang.class, id);
    }
    
}
