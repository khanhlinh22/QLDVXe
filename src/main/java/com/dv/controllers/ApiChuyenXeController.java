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
import org.springframework.http.MediaType;
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
@CrossOrigin(origins = "http://localhost:3000")
public class ApiChuyenXeController {

    @Autowired
    private ChuyenXeService chuyenXeService;

    @GetMapping("/chuyenxes")
    public ResponseEntity<List<ChuyenXe>> list(@RequestParam Map<String, String> params) {
        //return new ResponseEntity<>(this.chuyenXeService.getChuyenXes(params), HttpStatus.OK);
        List<ChuyenXe> chuyenXes = this.chuyenXeService.getChuyenXes(params);
    // Populate TuyenXe details for each ChuyenXe
    for (ChuyenXe cx : chuyenXes) {
        cx.getTuyenXeId();  // Ensure this retrieves TuyenXe data
    }
    return new ResponseEntity<>(chuyenXes, HttpStatus.OK);
    }

    @GetMapping(path = "/chuyenxes/{chuyenXeId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChuyenXe> retrieve(@PathVariable(value = "chuyenXeId") int id) {
        return new ResponseEntity<>(this.chuyenXeService.getChuyenXeById(id), HttpStatus.OK);
    }

   
    @DeleteMapping("/chuyenxes/{chuyenXeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "chuyenXeId") int id) {
        this.chuyenXeService.deleteChuyenXe(id);
    }

}
