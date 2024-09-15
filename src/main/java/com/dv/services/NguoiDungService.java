/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services;

import com.dv.pojo.NguoiDung;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface NguoiDungService extends UserDetailsService{
     boolean addUser(NguoiDung nguoiDung);
     //List la cua minh
    List<NguoiDung>getUsers(String username);
    NguoiDung getNguoiDungByUsername(String username);
    void addTroLy(NguoiDung nd, int khoaId);
    void addNguoiDung(NguoiDung nd);
}
