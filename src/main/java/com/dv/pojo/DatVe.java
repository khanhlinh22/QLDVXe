/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "dat_ve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatVe.findAll", query = "SELECT d FROM DatVe d"),
    @NamedQuery(name = "DatVe.findById", query = "SELECT d FROM DatVe d WHERE d.id = :id"),
    @NamedQuery(name = "DatVe.findByNgayDat", query = "SELECT d FROM DatVe d WHERE d.ngayDat = :ngayDat"),
    @NamedQuery(name = "DatVe.findBySoChoDat", query = "SELECT d FROM DatVe d WHERE d.soChoDat = :soChoDat"),
    @NamedQuery(name = "DatVe.findByTrangThai", query = "SELECT d FROM DatVe d WHERE d.trangThai = :trangThai")})
public class DatVe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ngay_dat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_cho_dat")
    private int soChoDat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "trang_thai")
    private String trangThai;
    @JoinColumn(name = "chuyen_xe_dv_id", referencedColumnName = "id")
    @ManyToOne
    private ChuyenXe chuyenXeDvId;
    @JoinColumn(name = "khach_hang_id", referencedColumnName = "id")
    @ManyToOne
    private KhachHang khachHangId;
    @JoinColumn(name = "tuyen_xe_dv_id", referencedColumnName = "id")
    @ManyToOne
    private TuyenXe tuyenXeDvId;
    @OneToMany(mappedBy = "datVeId", cascade = CascadeType.REMOVE)
    private Collection<ThanhToan> thanhToanCollection;

    public DatVe() {
    }

    public DatVe(Integer id) {
        this.id = id;
    }

    public DatVe(Integer id, int soChoDat, String trangThai) {
        this.id = id;
        this.soChoDat = soChoDat;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getSoChoDat() {
        return soChoDat;
    }

    public void setSoChoDat(int soChoDat) {
        this.soChoDat = soChoDat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ChuyenXe getChuyenXeDvId() {
        return chuyenXeDvId;
    }

    public void setChuyenXeDvId(ChuyenXe chuyenXeDvId) {
        this.chuyenXeDvId = chuyenXeDvId;
    }

    public KhachHang getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(KhachHang khachHangId) {
        this.khachHangId = khachHangId;
    }

    public TuyenXe getTuyenXeDvId() {
        return tuyenXeDvId;
    }

    public void setTuyenXeDvId(TuyenXe tuyenXeDvId) {
        this.tuyenXeDvId = tuyenXeDvId;
    }

    @XmlTransient
    public Collection<ThanhToan> getThanhToanCollection() {
        return thanhToanCollection;
    }

    public void setThanhToanCollection(Collection<ThanhToan> thanhToanCollection) {
        this.thanhToanCollection = thanhToanCollection;
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
        if (!(object instanceof DatVe)) {
            return false;
        }
        DatVe other = (DatVe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.DatVe[ id=" + id + " ]";
    }
    
}
