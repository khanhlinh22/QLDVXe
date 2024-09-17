/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.TuyenXe;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dv.repositoties.ChuyenXeRepository;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")

public class ChuyenXeRepositoryImpl implements ChuyenXeRepository {

    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ChuyenXe> getChuyenXes(Map<String, String> params) {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ChuyenXe> q = b.createQuery(ChuyenXe.class);
        Root root = q.from(ChuyenXe.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p2 = b.greaterThanOrEqualTo(root.get("giaVe"), Double.parseDouble(fromPrice));
                predicates.add(p2);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p3 = b.lessThanOrEqualTo(root.get("giaVe"), Double.parseDouble(toPrice));
                predicates.add(p3);
            }

            String txId = params.get("txId");
            if (txId != null && !txId.isEmpty()) {
                Predicate p4 = b.equal(root.get("tuyenXeId"), Integer.parseInt(txId));
                predicates.add(p4);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();

    }

    @Override
    public void addOrUpdate(ChuyenXe cx) {
        Session s = this.factory.getObject().getCurrentSession();
        if (cx.getId() != null) {
            s.update(cx);
        } else {
            s.save(cx);
        }
    }

    @Override
    public ChuyenXe getChuyenXeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ChuyenXe.class, id);
    }

    @Override
    public void deleteChuyenXe(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ChuyenXe cx = this.getChuyenXeById(id);
        s.delete(cx);
    }
}


