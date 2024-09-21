/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.services.DatVeService;
import com.dv.services.StatsService;
import com.dv.services.ThanhToanService;
import com.dv.services.TuyenXeService;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Autowired
    private DatVeService datVeService;
    @Autowired
    private ThanhToanService thanhToanService;

    @GetMapping("/stats")
    public String stats(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("revenues", this.statsService.statsRevenueByChuyenXe());
        String year = params.getOrDefault("year", String.valueOf(LocalDate.now().getYear()));
        String period = params.getOrDefault("period", "MONTH");
        model.addAttribute("revenueByPeriod", this.statsService.statsRevenueByPeroid(Integer.parseInt(year), period));
        return "stats";
    }

    @ModelAttribute
    public void commAttrs(Model model) {
        model.addAttribute("tuyenXes", this.tuyenXeService.getTuyenXes());
        model.addAttribute("datVes", this.datVeService.getDatVes());
        model.addAttribute("thanhToans", this.thanhToanService.getThanhToans());

        //model.addAttribute("xes", this.xeService.getXes());
        //model.addAttribute("taiXes", this.taiXeService.getTaiXes());
    }
}
