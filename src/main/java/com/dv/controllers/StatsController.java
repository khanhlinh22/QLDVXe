/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.services.StatsService;
import com.dv.services.TuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ADMIN
 */
@Controller
public class StatsController {
      @Autowired
    private StatsService statsService;
     @Autowired
    private TuyenXeService tuyenXeService;
    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("revenues", this.statsService.statsRevenueByChuyenXe());
        
        return "stats";
    }
    
     @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("tuyenXes", this.tuyenXeService.getTuyenXes());
        //model.addAttribute("xes", this.xeService.getXes());
        //model.addAttribute("taiXes", this.taiXeService.getTaiXes());
    }
}
