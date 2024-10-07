/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositoties;

import com.dv.pojo.NguoiDung;
import com.google.common.base.Optional;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungRepository extends UserDetailsService {

    NguoiDung getNguoiDungByUsername(String username);

    boolean addUser(NguoiDung nguoiDung);

    List<NguoiDung> getUsers(String username);

    NguoiDung addNguoiDung(NguoiDung nguoiDung);

    boolean authUser(String username, String password);

    List<NguoiDung> getNguoiDungs(Map<String, String> params);

    void addOrUpdate(NguoiDung nd);

    NguoiDung getNguoiDungById(int id);

    void deleteNguoiDung(int id);

    public NguoiDung getUserByUsername(String username);

}
