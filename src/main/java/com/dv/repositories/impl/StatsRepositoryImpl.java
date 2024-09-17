/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.DatVe;
import com.dv.pojo.TuyenXe;
import com.dv.repositoties.StatsRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

   @Override
public List<Object[]> statsRevenueByChuyenXe() {
    Session session = this.factory.getObject().getCurrentSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

    // Define the root entities
    Root<ChuyenXe> rootChuyenXe = query.from(ChuyenXe.class);
    Join<ChuyenXe, DatVe> joinDatVe = rootChuyenXe.join("datVeSet"); // Assuming a OneToMany relationship
    Join<ChuyenXe, TuyenXe> joinTuyenXe = rootChuyenXe.join("tuyenXeId"); // Join with TuyenXe

    // Perform the sum of the product of soChoDat and giaVe
    query.multiselect(
            rootChuyenXe.get("id"), // ChuyenXe ID
            joinTuyenXe.get("tenTuyen"), // Name of the route
            builder.sum(
                    builder.prod(joinDatVe.get("soChoDat"), rootChuyenXe.get("giaVe")) // Revenue calculation
            )
    );

    // Group by ChuyenXe ID and other selected fields
    query.groupBy(
            rootChuyenXe.get("id"),
            joinTuyenXe.get("tenTuyen")
    );

    // Execute the query
    Query<Object[]> hibernateQuery = session.createQuery(query);
    return hibernateQuery.getResultList();
}
    @Override
    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

// Root for ChuyenXe (the bus trip entity)
        Root<ChuyenXe> rCX = q.from(ChuyenXe.class);

// Create the query where we extract the year from the `ngayGioKhoiHanh` field
        q.where(
                b.equal(b.function("YEAR", Integer.class, rCX.get("ngayGioKhoiHanh")), year)
        );

// Select the year and count the number of trips (ChuyenXe) that occurred
        q.multiselect(
                b.function("YEAR", Integer.class, rCX.get("ngayGioKhoiHanh")), // The year of the trip
                b.count(rCX.get("id")) // Count the number of trips in that year
        );

// Group by the year
        q.groupBy(b.function("YEAR", Integer.class, rCX.get("ngayGioKhoiHanh")));

// Create the query and execute it
        Query query = s.createQuery(q);

        return query.getResultList();
    }
}
