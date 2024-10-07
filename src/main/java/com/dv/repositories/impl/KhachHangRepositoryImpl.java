/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.KhachHang;
import com.dv.pojo.NguoiDung;
import com.dv.repositoties.KhachHangRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class KhachHangRepositoryImpl implements KhachHangRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public KhachHang getKhachHangById(int id) {
        Session session = this.factory.getObject().getCurrentSession();

        // Truy vấn người dùng theo ID
        NguoiDung nguoiDung = session.get(NguoiDung.class, id);
        if (nguoiDung == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại");
        }

        // Kiểm tra vai trò của người dùng
        if (!NguoiDung.KHACHHANG.equals(nguoiDung.getRoleName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Người dùng không phải là khách hàng");
        }

        // Truy vấn khách hàng dựa trên nguoi_dung_kh_id
        KhachHang khachHang = session.createQuery("FROM KhachHang kh WHERE kh.nguoiDungKhId = :nguoiDungKhId", KhachHang.class)
                .setParameter("nguoiDungKhId", nguoiDung)
                .uniqueResult();

        if (khachHang == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Khách hàng không tồn tại");
        }

        return khachHang;
    }
}
