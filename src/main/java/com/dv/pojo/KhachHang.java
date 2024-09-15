/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "khach_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findById", query = "SELECT k FROM KhachHang k WHERE k.id = :id"),
    @NamedQuery(name = "KhachHang.findByThongTinThanhToan", query = "SELECT k FROM KhachHang k WHERE k.thongTinThanhToan = :thongTinThanhToan")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "thong_tin_thanh_toan")
    private String thongTinThanhToan;
    @JoinColumn(name = "nguoi_dung_kh_id", referencedColumnName = "id")
    @ManyToOne
    private NguoiDung nguoiDungKhId;
    @OneToMany(mappedBy = "khachHangId")
    private Set<DatVe> datVeSet;

    public KhachHang() {
    }

    public KhachHang(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThongTinThanhToan() {
        return thongTinThanhToan;
    }

    public void setThongTinThanhToan(String thongTinThanhToan) {
        this.thongTinThanhToan = thongTinThanhToan;
    }

    public NguoiDung getNguoiDungKhId() {
        return nguoiDungKhId;
    }

    public void setNguoiDungKhId(NguoiDung nguoiDungKhId) {
        this.nguoiDungKhId = nguoiDungKhId;
    }

    @XmlTransient
    public Set<DatVe> getDatVeSet() {
        return datVeSet;
    }

    public void setDatVeSet(Set<DatVe> datVeSet) {
        this.datVeSet = datVeSet;
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
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.KhachHang[ id=" + id + " ]";
    }
    
}
