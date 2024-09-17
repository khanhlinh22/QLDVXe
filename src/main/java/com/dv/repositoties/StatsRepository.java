/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositoties;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface StatsRepository {
    List<Object[]> statsRevenueByChuyenXe();
    List<Object[]> statsRevenueByPeroid(int year, String peroid);
}
