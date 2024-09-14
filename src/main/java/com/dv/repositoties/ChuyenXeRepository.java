/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositoties;

import com.dv.pojo.ChuyenXe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ChuyenXeRepository {

    List<ChuyenXe> getChuyenXes(Map<String, String> params);
    void addOrUpdate(ChuyenXe cx);
    ChuyenXe getChuyenXeById(int id);
    void deleteChuyenXe(int id);
}
