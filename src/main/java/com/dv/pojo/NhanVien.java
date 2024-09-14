/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "nhan_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findById", query = "SELECT n FROM NhanVien n WHERE n.id = :id"),
    @NamedQuery(name = "NhanVien.findByChucVu", query = "SELECT n FROM NhanVien n WHERE n.chucVu = :chucVu"),
    @NamedQuery(name = "NhanVien.findByChiNhanh", query = "SELECT n FROM NhanVien n WHERE n.chiNhanh = :chiNhanh")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "chuc_vu")
    private String chucVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "chi_nhanh")
    private String chiNhanh;
    @JoinColumn(name = "nguoi_dung_nv_id", referencedColumnName = "id")
    @ManyToOne
    private NguoiDung nguoiDungNvId;

    public NhanVien() {
    }

    public NhanVien(Integer id) {
        this.id = id;
    }

    public NhanVien(Integer id, String chucVu, String chiNhanh) {
        this.id = id;
        this.chucVu = chucVu;
        this.chiNhanh = chiNhanh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }

    public NguoiDung getNguoiDungNvId() {
        return nguoiDungNvId;
    }

    public void setNguoiDungNvId(NguoiDung nguoiDungNvId) {
        this.nguoiDungNvId = nguoiDungNvId;
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
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.NhanVien[ id=" + id + " ]";
    }
    
}
