/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services;

import com.dv.pojo.NguoiDung;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungService extends UserDetailsService {

    boolean addUser(NguoiDung nguoiDung);

    List<NguoiDung> getUsers(String username);

    NguoiDung getNguoiDungByUsername(String username);

    NguoiDung addNguoiDung(Map<String, String> params, MultipartFile avatar);

    boolean authUser(String username, String password);

    List<NguoiDung> getNguoiDungs(Map<String, String> params);

    void addOrUpdate(NguoiDung nd);

    public NguoiDung getNguoiDungById(int id);

    void deleteNguoiDung(int id);
}
