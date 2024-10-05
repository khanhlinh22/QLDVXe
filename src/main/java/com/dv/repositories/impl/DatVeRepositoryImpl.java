/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.DatVe;
import com.dv.repositoties.DatVeRepository;
import java.util.List;
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
public class DatVeRepositoryImpl implements DatVeRepository {

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<DatVe> getDatVes() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("DatVe.findAll");
        return q.getResultList();
    }

    @Override
    public DatVe getDatVeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(DatVe.class, id);
    }
}
