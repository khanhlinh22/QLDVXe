/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dv.pojo.NguoiDung;
import com.dv.repositoties.NguoiDungRepository;
import com.dv.services.NguoiDungService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service("userDetailsService")
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository nguoiDungRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
 @Autowired
    private Cloudinary cloudinary;
    @Override
    public boolean addUser(NguoiDung nguoiDung) {
        String pass = nguoiDung.getPassword();
        nguoiDung.setPassword(this.passwordEncoder.encode(pass));
        nguoiDung.setRoleName(NguoiDung.KHACHHANG);
        if (!nguoiDung.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(nguoiDung.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));

                nguoiDung.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        nguoiDung.setPassword(NguoiDung.USER);
        return this.nguoiDungRepo.addUser(nguoiDung);

    }

    @Override
    public List<NguoiDung> getUsers(String username) {
        return this.nguoiDungRepo.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<NguoiDung> nguoiDungs = this.getUsers(username);
        if (nguoiDungs.isEmpty()) {
            throw new UsernameNotFoundException("User khong ton tai");
        }
        NguoiDung nguoiDung = nguoiDungs.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(nguoiDung.getRoleName()));
        return new org.springframework.security.core.userdetails.User(nguoiDung.getUsername(), nguoiDung.getPassword(), auth);
    }

    @Override
    public NguoiDung getNguoiDungByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTroLy(NguoiDung nd, int khoaId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addNguoiDung(NguoiDung nd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
