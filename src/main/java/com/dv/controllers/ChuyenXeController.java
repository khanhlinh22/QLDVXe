/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.enums.TrangThai;
import com.dv.pojo.ChuyenXe;
import com.dv.services.ChuyenXeService;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ChuyenXeController {

    @Autowired
    private ChuyenXeService chuyenXeService;

    @GetMapping("/admin/chuyenxes")
    public String createView(Model model) {
        model.addAttribute("chuyenXe", new ChuyenXe());
        model.addAttribute("trangThaiList", TrangThai.values()); // Pass enum values to the JSP

        return "chuyenxes";
    }

    @PostMapping("/admin/chuyenxes")
    public String createView(Model model,
            @ModelAttribute(value = "chuyenXe") @Valid ChuyenXe cx,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "chuyenxes";
        }

        try {
            this.chuyenXeService.addOrUpdate(cx);

            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "chuyenxes";
    }

    @GetMapping("/admin/chuyenxes/{chuyenXeId}")
    public String detailsView(Model model, @PathVariable(value = "chuyenXeId") int id) {
        model.addAttribute("chuyenXe", this.chuyenXeService.getChuyenXeById(id));
        List<TrangThai> trangThaiList = Arrays.asList(TrangThai.values());
        model.addAttribute("trangThaiList", trangThaiList);
        return "chuyenxes";
    }
}
