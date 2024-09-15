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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tuyen_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TuyenXe.findAll", query = "SELECT t FROM TuyenXe t"),
    @NamedQuery(name = "TuyenXe.findById", query = "SELECT t FROM TuyenXe t WHERE t.id = :id"),
    @NamedQuery(name = "TuyenXe.findByTenTuyen", query = "SELECT t FROM TuyenXe t WHERE t.tenTuyen = :tenTuyen"),
    @NamedQuery(name = "TuyenXe.findByDiemDi", query = "SELECT t FROM TuyenXe t WHERE t.diemDi = :diemDi"),
    @NamedQuery(name = "TuyenXe.findByDiemDen", query = "SELECT t FROM TuyenXe t WHERE t.diemDen = :diemDen"),
    @NamedQuery(name = "TuyenXe.findByTanSuat", query = "SELECT t FROM TuyenXe t WHERE t.tanSuat = :tanSuat"),
    @NamedQuery(name = "TuyenXe.findByKhoangCach", query = "SELECT t FROM TuyenXe t WHERE t.khoangCach = :khoangCach")})
public class TuyenXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ten_tuyen")
    private String tenTuyen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diem_di")
    private String diemDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "diem_den")
    private String diemDen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tan_suat")
    private String tanSuat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "khoang_cach")
    private String khoangCach;
    @OneToMany(mappedBy = "tuyenXeDvId")
    private Set<DatVe> datVeSet;
    @OneToMany(mappedBy = "tuyenXeId")
    private Set<ChuyenXe> chuyenXeSet;

    public TuyenXe() {
    }

    public TuyenXe(Integer id) {
        this.id = id;
    }

    public TuyenXe(Integer id, String tenTuyen, String diemDi, String diemDen, String tanSuat, String khoangCach) {
        this.id = id;
        this.tenTuyen = tenTuyen;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.tanSuat = tanSuat;
        this.khoangCach = khoangCach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getTanSuat() {
        return tanSuat;
    }

    public void setTanSuat(String tanSuat) {
        this.tanSuat = tanSuat;
    }

    public String getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(String khoangCach) {
        this.khoangCach = khoangCach;
    }

    @XmlTransient
    public Set<DatVe> getDatVeSet() {
        return datVeSet;
    }

    public void setDatVeSet(Set<DatVe> datVeSet) {
        this.datVeSet = datVeSet;
    }

    @XmlTransient
    public Set<ChuyenXe> getChuyenXeSet() {
        return chuyenXeSet;
    }

    public void setChuyenXeSet(Set<ChuyenXe> chuyenXeSet) {
        this.chuyenXeSet = chuyenXeSet;
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
        if (!(object instanceof TuyenXe)) {
            return false;
        }
        TuyenXe other = (TuyenXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.TuyenXe[ id=" + id + " ]";
    }
    
}
