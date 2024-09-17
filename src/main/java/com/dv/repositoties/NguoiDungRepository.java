/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositoties;

import com.dv.pojo.NguoiDung;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungRepository extends UserDetailsService{
    NguoiDung getNguoiDungByUsername(String username);
    boolean addUser(NguoiDung nguoiDung);
    List<NguoiDung> getUsers(String username);
    void addNguoiDung(NguoiDung nd);
}
