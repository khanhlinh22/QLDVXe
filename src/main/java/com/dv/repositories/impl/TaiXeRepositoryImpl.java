/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.TaiXe;
import com.dv.repositoties.TaiXeRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class TaiXeRepositoryImpl implements TaiXeRepository{
      @Autowired
    private Environment env;

      @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<TaiXe> getTaiXes() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("TaiXe.findAll");
        return q.getResultList();
    }
    
     
 
}
