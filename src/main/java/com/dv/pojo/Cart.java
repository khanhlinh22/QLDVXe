/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.math.BigDecimal;


/**
 *
 * @author ADMIN
 */
public class Cart{

    private int id;
    private String name;
    private int soChoDat;
    private String trangThai;
    private BigDecimal giaVe;
    private String hinhThucThanhToan;
    private int tuyenXeId;
    private int chuyenXeId;
    
     public Cart() {
    }


    public Cart(int id, String name, String trangThai, int soChoDat, BigDecimal giaVe, String hinhThucThanhToan, int tuyenXeId, int chuyenXeId) {
        this.id = id;
        this.name =  name;
        this.trangThai=trangThai;
        this.soChoDat=soChoDat;
        this.giaVe=giaVe;
        this.hinhThucThanhToan=hinhThucThanhToan;
        this.tuyenXeId=tuyenXeId;
        this.chuyenXeId=chuyenXeId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     * @return the soChoDat
     */
    public int getSoChoDat() {
        return soChoDat;
    }

    /**
     * @param soChoDat the soChoDat to set
     */
    public void setSoChoDat(int soChoDat) {
        this.soChoDat = soChoDat;
    }

    /**
     * @return the trangThai
     */
    public String getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the soTien
     */
    public BigDecimal getGiaVe() {
        return giaVe;
    }

    /**
     * @param giaVe the soTien to set
     */
    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    /**
     * @return the hinhThucThanhToan
     */
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    /**
     * @param hinhThucThanhToan the hinhThucThanhToan to set
     */
    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    /**
     * @return the tuyenXeId
     */
    public int getTuyenXeId() {
        return tuyenXeId;
    }

    /**
     * @param tuyenXeId the tuyenXeId to set
     */
    public void setTuyenXeId(int tuyenXeId) {
        this.tuyenXeId = tuyenXeId;
    }

    /**
     * @return the chuyenXeId
     */
    public int getChuyenXeId() {
        return chuyenXeId;
    }

    /**
     * @param chuyenXeId the chuyenXeId to set
     */
    public void setChuyenXeId(int chuyenXeId) {
        this.chuyenXeId = chuyenXeId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    


}
