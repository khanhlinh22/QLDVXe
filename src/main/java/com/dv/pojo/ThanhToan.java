/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "thanh_toan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThanhToan.findAll", query = "SELECT t FROM ThanhToan t"),
    @NamedQuery(name = "ThanhToan.findById", query = "SELECT t FROM ThanhToan t WHERE t.id = :id"),
    @NamedQuery(name = "ThanhToan.findBySoTien", query = "SELECT t FROM ThanhToan t WHERE t.soTien = :soTien"),
    @NamedQuery(name = "ThanhToan.findByNgayThanhToan", query = "SELECT t FROM ThanhToan t WHERE t.ngayThanhToan = :ngayThanhToan"),
    @NamedQuery(name = "ThanhToan.findByHinhThucThanhToan", query = "SELECT t FROM ThanhToan t WHERE t.hinhThucThanhToan = :hinhThucThanhToan")})
public class ThanhToan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_tien")
    private BigDecimal soTien;
    @Column(name = "ngay_thanh_toan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayThanhToan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "hinh_thuc_thanh_toan")
    private String hinhThucThanhToan;
    @JoinColumn(name = "dat_ve_id", referencedColumnName = "id")
    @ManyToOne
    private DatVe datVeId;

    public ThanhToan() {
    }

    public ThanhToan(Integer id) {
        this.id = id;
    }

    public ThanhToan(Integer id, BigDecimal soTien, String hinhThucThanhToan) {
        this.id = id;
        this.soTien = soTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public DatVe getDatVeId() {
        return datVeId;
    }

    public void setDatVeId(DatVe datVeId) {
        this.datVeId = datVeId;
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
        if (!(object instanceof ThanhToan)) {
            return false;
        }
        ThanhToan other = (ThanhToan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.ThanhToan[ id=" + id + " ]";
    }
    
}
