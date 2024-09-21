/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.components.JwtService;
import com.dv.pojo.NguoiDung;
import com.dv.services.NguoiDungService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiNguoiDungController {

//    @Autowired
//    private BCryptPasswordEncoder passswordEncoder;
//    @Autowired
//    private NguoiDungService nguoiDungService;
//    @Autowired
//    private JwtService jwtService;
//
//    @PostMapping(path = "/users/", consumes = {
//        MediaType.APPLICATION_JSON_VALUE,
//        MediaType.MULTIPART_FORM_DATA_VALUE
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    @CrossOrigin
//    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
//        NguoiDung nd = new NguoiDung();
//        nd.setTen(params.get("ten"));
//        nd.setHo(params.get("ho"));
//        nd.setUsername(params.get("username"));
//        nd.setEmail(params.get("email"));
//        nd.setSdt(params.get("sdt"));
//        nd.setCccd(params.get("cccd"));
//        String password = params.get("password");
//        nd.setPassword(this.passswordEncoder.encode(password));
//        nd.setRoleName("KHACHHANG");
//
//        
//        if (file.length > 0) {
//            nd.setFile(file[0]);
//        }
//
//        this.nguoiDungService.addUser(nd);
//    }
//
//    @PostMapping("/login/")
//    @CrossOrigin
//    public ResponseEntity<String> login(@RequestBody NguoiDung nd) {
//        if (this.nguoiDungService.authUser(nd.getUsername(), nd.getPassword()) == true) {
//            String token = this.jwtService.generateTokenLogin(nd.getUsername());
//
//            return new ResponseEntity<>(token, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
//    }
//
//    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    public ResponseEntity<NguoiDung> getCurrentUser(Principal p) {
//        NguoiDung nd = this.nguoiDungService.getNguoiDungByUsername(p.getName());
//        return new ResponseEntity<>(nd, HttpStatus.OK);
//    }
}
