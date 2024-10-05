/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.pojo.NguoiDung;
import com.dv.services.NguoiDungService;
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
public class NguoiDungController {

    @Autowired
    private NguoiDungService userDetailsService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    //Vo de xem

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("NguoiDung", new NguoiDung());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "NguoiDung") NguoiDung nd) {
        String errMsg = "";
        // Log the incoming data for debugging
        System.out.println("Registering user: " + nd);
        if (nd.getPassword().equals(nd.getConfirmPassword())) {
            if (this.userDetailsService.addUser(nd) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Đã có lỗi xảy ra";
            }
        } else {
            errMsg = "Mật khẩu không khớp";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }

    @GetMapping("/admin/qlnvs")
    public String createView(Model model) {
        model.addAttribute("NguoiDung", new NguoiDung());

        return "qlnvs";
    }

    @PostMapping("/admin/qlnvs")
    public String createView(Model model,
            @ModelAttribute(value = "NguoiDung") @Valid NguoiDung nd,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "qlnvs"; // Trang 'qlnds' cần hiển thị được các lỗi xác thực
        }

        try {
            this.nguoiDungService.addOrUpdate(nd);

            return "redirect:/indexuser"; // Điều hướng về danh sách người dùng sau khi thành công
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage()); // Hiển thị thông báo lỗi nếu có ngoại lệ
        }

        return "qlnvs"; // Trả về lại trang 'qlnds' nếu có lỗi
    }

    @GetMapping("/admin/qlnvs/{nguoiDungId}")
    public String detailsView(Model model, @PathVariable(value = "nguoiDungId") int id) {
        model.addAttribute("NguoiDung", this.nguoiDungService.getNguoiDungById(id));

        return "qlnvs";
    }
}
