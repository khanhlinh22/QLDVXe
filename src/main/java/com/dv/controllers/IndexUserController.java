/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.services.ChuyenXeService;
import com.dv.services.NguoiDungService;
import com.dv.services.TaiXeService;
import com.dv.services.TuyenXeService;
import com.dv.services.XeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class IndexUserController {
       @Autowired
    private TuyenXeService tuyenXeService;
    @Autowired
    private ChuyenXeService chuyenXeService;  
    @Autowired
    private XeService xeService;
    @Autowired
    private NguoiDungService ndService;
    @ModelAttribute
//    public void commAttrs(Model model) {
//        model.addAttribute("tuyenXes", this.tuyenXeService.getTuyenXes());
//        //model.addAttribute("xes", this.xeService.getXes());
//        //model.addAttribute("taiXes", this.taiXeService.getTaiXes());
//
//    }
    
    @RequestMapping("indexuser")
    public String index(Model model, @RequestParam Map<String, String> params) {      
        model.addAttribute("nguoiDungs", this.ndService.getNguoiDungs(params));
        
        return "indexuser";
    }
}
