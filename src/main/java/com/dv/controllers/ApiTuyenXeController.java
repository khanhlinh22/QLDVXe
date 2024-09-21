/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.pojo.TuyenXe;
import com.dv.services.TuyenXeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") 
public class ApiTuyenXeController {
     @Autowired
    private TuyenXeService tuyenXeService;
    
    @GetMapping("/tuyenxes")
    public ResponseEntity<List<TuyenXe>> list() {
        return new ResponseEntity<>(this.tuyenXeService.getTuyenXes(), HttpStatus.OK);
    }
}
