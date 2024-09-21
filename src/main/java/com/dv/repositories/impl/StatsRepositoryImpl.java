/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.DatVe;
import com.dv.pojo.ThanhToan;
import com.dv.pojo.TuyenXe;
import com.dv.repositoties.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
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
    public List<Object[]> statsRevenueByPeroid(int year, String period) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        // Join tables: Root for 'dat_ve' (booking) and 'thanh_toan' (payment)
        Root<DatVe> rDV = q.from(DatVe.class);
        Root<ThanhToan> rTT = q.from(ThanhToan.class);

        // Select the period (e.g., month, quarter) from 'ngay_thanh_toan' and sum of 'so_tien' from 'thanh_toan'
        q.multiselect(
                b.function(period, Integer.class, rTT.get("ngayThanhToan")), // The period (e.g., month, quarter)
                b.sum(rTT.get("soTien")) // Sum of ticket payment amount
        );

        // Add predicates (conditions) to filter the year and join dat_ve with thanh_toan
        List<Predicate> predicates = new ArrayList<>();
        // Ensure that the 'dat_ve' id matches the 'dat_ve_id' in the 'thanh_toan' table
        predicates.add(b.equal(rTT.get("datVeId"), rDV.get("id")));
        // Filter the year based on 'ngay_thanh_toan' in the 'thanh_toan' table
        predicates.add(b.equal(b.function("YEAR", Integer.class, rTT.get("ngayThanhToan")), year));
        // Optionally, add a condition to filter by only successful/paid bookings
        predicates.add(b.equal(rDV.get("trangThai"), "Paid"));

        // Apply the conditions to the query
        q.where(predicates.toArray(Predicate[]::new));

        // Group by the period (e.g., month or quarter)
        q.groupBy(b.function(period, Integer.class, rTT.get("ngayThanhToan")));

        // Execute the query and return the result list
        Query query = s.createQuery(q);
        return query.getResultList();
    }
}
