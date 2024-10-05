/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.TuyenXe;
import com.dv.repositoties.TuyenXeRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class TuyenXeRepositoryImpl implements TuyenXeRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;
     @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TuyenXe> getTuyenXes() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From TuyenXe");
        return q.getResultList();
    }

    @Override
    public TuyenXe getTuyenXeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(TuyenXe.class, id);
    }

   

}
