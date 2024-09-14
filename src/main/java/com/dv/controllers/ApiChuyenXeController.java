/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.controllers;

import com.dv.pojo.ChuyenXe;
import com.dv.services.ChuyenXeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiChuyenXeController {
    @Autowired
    private ChuyenXeService chuyenXeService;
    
    @DeleteMapping("/chuyenxes/{chuyenXeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "chuyenXeId") int id) {
        this.chuyenXeService.deleteChuyenXe(id);
    }
    
    @GetMapping("/chuyenxes")
    public ResponseEntity<List<ChuyenXe>> list(@RequestParam Map<String, String> params) {
        List<ChuyenXe> chuyenxes = this.chuyenXeService.getChuyenXes(params);
        
        return new ResponseEntity<>(chuyenxes, HttpStatus.OK);
    }
}
