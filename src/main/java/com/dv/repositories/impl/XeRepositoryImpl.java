/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.Xe;
import com.dv.repositoties.XeRepository;
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
public class XeRepositoryImpl implements XeRepository{
      @Autowired
    private Environment env;
      @Autowired
    private LocalSessionFactoryBean factory;
      
    @Override
    public List<Xe> getXes() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Xe");
        return q.getResultList();
    }
}
