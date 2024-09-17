/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.services.impl;

import com.dv.repositoties.StatsRepository;
import com.dv.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

     @Override
    public List<Object[]> statsRevenueByChuyenXe() {
        return this.statsRepository.statsRevenueByChuyenXe();
    }

    @Override
    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
        return this.statsRepository.statsRevenueByPeroid(year, peroid);
    }

   

}
