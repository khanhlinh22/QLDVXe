/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "thong_ke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongKe.findAll", query = "SELECT t FROM ThongKe t"),
    @NamedQuery(name = "ThongKe.findById", query = "SELECT t FROM ThongKe t WHERE t.id = :id"),
    @NamedQuery(name = "ThongKe.findByNgayThongKe", query = "SELECT t FROM ThongKe t WHERE t.ngayThongKe = :ngayThongKe"),
    @NamedQuery(name = "ThongKe.findByTongSoVeDaBan", query = "SELECT t FROM ThongKe t WHERE t.tongSoVeDaBan = :tongSoVeDaBan"),
    @NamedQuery(name = "ThongKe.findByDoanhThuNgay", query = "SELECT t FROM ThongKe t WHERE t.doanhThuNgay = :doanhThuNgay"),
    @NamedQuery(name = "ThongKe.findByTongSoChuyenXe", query = "SELECT t FROM ThongKe t WHERE t.tongSoChuyenXe = :tongSoChuyenXe"),
    @NamedQuery(name = "ThongKe.findByTongXeSuDungNgay", query = "SELECT t FROM ThongKe t WHERE t.tongXeSuDungNgay = :tongXeSuDungNgay")})
public class ThongKe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_thong_ke")
    @Temporal(TemporalType.DATE)
    private Date ngayThongKe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tong_so_ve_da_ban")
    private int tongSoVeDaBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doanh_thu_ngay")
    private float doanhThuNgay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tong_so_chuyen_xe")
    private int tongSoChuyenXe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tong_xe_su_dung_ngay")
    private float tongXeSuDungNgay;

    public ThongKe() {
    }

    public ThongKe(Integer id) {
        this.id = id;
    }

    public ThongKe(Integer id, Date ngayThongKe, int tongSoVeDaBan, float doanhThuNgay, int tongSoChuyenXe, float tongXeSuDungNgay) {
        this.id = id;
        this.ngayThongKe = ngayThongKe;
        this.tongSoVeDaBan = tongSoVeDaBan;
        this.doanhThuNgay = doanhThuNgay;
        this.tongSoChuyenXe = tongSoChuyenXe;
        this.tongXeSuDungNgay = tongXeSuDungNgay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayThongKe() {
        return ngayThongKe;
    }

    public void setNgayThongKe(Date ngayThongKe) {
        this.ngayThongKe = ngayThongKe;
    }

    public int getTongSoVeDaBan() {
        return tongSoVeDaBan;
    }

    public void setTongSoVeDaBan(int tongSoVeDaBan) {
        this.tongSoVeDaBan = tongSoVeDaBan;
    }

    public float getDoanhThuNgay() {
        return doanhThuNgay;
    }

    public void setDoanhThuNgay(float doanhThuNgay) {
        this.doanhThuNgay = doanhThuNgay;
    }

    public int getTongSoChuyenXe() {
        return tongSoChuyenXe;
    }

    public void setTongSoChuyenXe(int tongSoChuyenXe) {
        this.tongSoChuyenXe = tongSoChuyenXe;
    }

    public float getTongXeSuDungNgay() {
        return tongXeSuDungNgay;
    }

    public void setTongXeSuDungNgay(float tongXeSuDungNgay) {
        this.tongXeSuDungNgay = tongXeSuDungNgay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThongKe)) {
            return false;
        }
        ThongKe other = (ThongKe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.ThongKe[ id=" + id + " ]";
    }
    
}
