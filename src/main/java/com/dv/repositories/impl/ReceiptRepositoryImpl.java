/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.Cart;
import com.dv.pojo.ChuyenXe;
import com.dv.pojo.DatVe;
import com.dv.pojo.KhachHang;
import com.dv.pojo.NguoiDung;
import com.dv.pojo.ThanhToan;
import com.dv.pojo.TuyenXe;
import com.dv.repositoties.ChuyenXeRepository;
import com.dv.repositoties.DatVeRepository;
import com.dv.repositoties.KhachHangRepository;
import com.dv.repositoties.NguoiDungRepository;
import com.dv.repositoties.ReceiptRepository;
import com.dv.repositoties.TuyenXeRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private NguoiDungRepository nguoiDungRepo;

    @Autowired
    private DatVeRepository datVeRepo; // Thêm repository cho DatVe

    @Autowired
    private ChuyenXeRepository chuyenXeRepo;
    @Autowired
    private TuyenXeRepository tuyenXeRepo;
    @Autowired
    private KhachHangRepository khachHangRepo;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
  
    public void addReceipt(List<Cart> carts) {
     System.out.println("Received carts: " + carts);
        if (carts == null || carts.isEmpty()) {
            System.out.println("Không có giỏ hàng nào để xử lý.");
            return; // Không có giỏ hàng nào để xử lý
        }

        Session session = this.factory.getObject().getCurrentSession();

        // Retrieve the current user
        NguoiDung currentUser = nguoiDungRepo.getNguoiDungByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (currentUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Người dùng không tồn tại");
        }

        // Retrieve the customer
        KhachHang khachHang = khachHangRepo.getKhachHangById(currentUser.getId());
        if (khachHang == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Khách hàng không tồn tại");
        }

        // Process each Cart item
        for (Cart cart : carts) {
            TuyenXe tuyenXe = tuyenXeRepo.getTuyenXeById(cart.getTuyenXeId());
            if (tuyenXe == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tuyến xe không hợp lệ");
            }

            ChuyenXe chuyenXe = chuyenXeRepo.getChuyenXeById(cart.getChuyenXeId());
            if (chuyenXe == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Chuyến xe không hợp lệ");
            }

            // Create a new booking record
            DatVe datVe = new DatVe();
            datVe.setSoChoDat(cart.getSoChoDat());
            datVe.setTrangThai("Pending");
            datVe.setNgayDat(new Date());
            datVe.setChuyenXeDvId(chuyenXe);
            datVe.setKhachHangId(khachHang);
            datVe.setTuyenXeDvId(tuyenXe);

            // Save the booking
            session.save(datVe);

            // Create payment record if necessary
            if (cart.getGiaVe() != null && cart.getSoChoDat() > 0) {
                ThanhToan thanhToan = new ThanhToan();
                thanhToan.setSoTien(cart.getGiaVe());
                thanhToan.setHinhThucThanhToan(cart.getHinhThucThanhToan());
                thanhToan.setNgayThanhToan(new Date());
                thanhToan.setDatVeId(datVe); // Sửa lại để tham chiếu đúng đến datVe

                // Save the payment record
                session.save(thanhToan);

                // Update booking status to Paid
                datVe.setTrangThai("Paid");
            }

            // No need to save datVe again, it's already saved when the ThanhToan is created
        }

        session.flush(); // Ensure everything is saved
    }}


