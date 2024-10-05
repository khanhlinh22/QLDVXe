/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.components.JwtService;
import com.dv.pojo.NguoiDung;
import com.dv.services.ChuyenXeService;
import com.dv.services.NguoiDungService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost:3000")

public class ApiNguoiDungController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private NguoiDungService nguoiDungService;
    

    @DeleteMapping("/qlnvs/{nguoiDungs}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "nguoiDungId") int id) {
        this.nguoiDungService.deleteNguoiDung(id);
    }


    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody NguoiDung nd) {
        if (this.nguoiDungService.authUser(nd.getUsername(), nd.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(nd.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/nguoidungs/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<NguoiDung> addNguoiDung(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        NguoiDung nd = this.nguoiDungService.addNguoiDung(params, avatar);
        return new ResponseEntity<>(nd, HttpStatus.CREATED);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<NguoiDung> details(Principal nd) {
        NguoiDung nguoiDung = this.nguoiDungService.getNguoiDungByUsername(nd.getName());
        return new ResponseEntity<>(nguoiDung, HttpStatus.OK);
    }

    
}
