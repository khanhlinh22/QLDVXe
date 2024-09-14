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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lich_trinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LichTrinh.findAll", query = "SELECT l FROM LichTrinh l"),
    @NamedQuery(name = "LichTrinh.findById", query = "SELECT l FROM LichTrinh l WHERE l.id = :id"),
    @NamedQuery(name = "LichTrinh.findByNgay", query = "SELECT l FROM LichTrinh l WHERE l.ngay = :ngay"),
    @NamedQuery(name = "LichTrinh.findByGioKhoiHanh", query = "SELECT l FROM LichTrinh l WHERE l.gioKhoiHanh = :gioKhoiHanh"),
    @NamedQuery(name = "LichTrinh.findByGioDen", query = "SELECT l FROM LichTrinh l WHERE l.gioDen = :gioDen")})
public class LichTrinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay")
    @Temporal(TemporalType.DATE)
    private Date ngay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gio_khoi_hanh")
    @Temporal(TemporalType.TIME)
    private Date gioKhoiHanh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gio_den")
    @Temporal(TemporalType.TIME)
    private Date gioDen;
    @JoinColumn(name = "chuyen_xe_id", referencedColumnName = "id")
    @ManyToOne
    private ChuyenXe chuyenXeId;

    public LichTrinh() {
    }

    public LichTrinh(Integer id) {
        this.id = id;
    }

    public LichTrinh(Integer id, Date ngay, Date gioKhoiHanh, Date gioDen) {
        this.id = id;
        this.ngay = ngay;
        this.gioKhoiHanh = gioKhoiHanh;
        this.gioDen = gioDen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Date getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(Date gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public Date getGioDen() {
        return gioDen;
    }

    public void setGioDen(Date gioDen) {
        this.gioDen = gioDen;
    }

    public ChuyenXe getChuyenXeId() {
        return chuyenXeId;
    }

    public void setChuyenXeId(ChuyenXe chuyenXeId) {
        this.chuyenXeId = chuyenXeId;
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
        if (!(object instanceof LichTrinh)) {
            return false;
        }
        LichTrinh other = (LichTrinh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.LichTrinh[ id=" + id + " ]";
    }
    
}
