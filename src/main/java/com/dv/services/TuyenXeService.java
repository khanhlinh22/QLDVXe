/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services;

import com.dv.pojo.TuyenXe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface TuyenXeService {

    List<TuyenXe> getTuyenXes();

    public TuyenXe getTuyenXeById(int id);

}
