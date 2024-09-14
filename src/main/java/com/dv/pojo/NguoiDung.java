/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "nguoi_dung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiDung.findAll", query = "SELECT n FROM NguoiDung n"),
    @NamedQuery(name = "NguoiDung.findById", query = "SELECT n FROM NguoiDung n WHERE n.id = :id"),
    @NamedQuery(name = "NguoiDung.findByHo", query = "SELECT n FROM NguoiDung n WHERE n.ho = :ho"),
    @NamedQuery(name = "NguoiDung.findByTen", query = "SELECT n FROM NguoiDung n WHERE n.ten = :ten"),
    @NamedQuery(name = "NguoiDung.findByUsername", query = "SELECT n FROM NguoiDung n WHERE n.username = :username"),
    @NamedQuery(name = "NguoiDung.findByPassword", query = "SELECT n FROM NguoiDung n WHERE n.password = :password"),
    @NamedQuery(name = "NguoiDung.findByEmail", query = "SELECT n FROM NguoiDung n WHERE n.email = :email"),
    @NamedQuery(name = "NguoiDung.findByCccd", query = "SELECT n FROM NguoiDung n WHERE n.cccd = :cccd"),
    @NamedQuery(name = "NguoiDung.findByAvatar", query = "SELECT n FROM NguoiDung n WHERE n.avatar = :avatar"),
    @NamedQuery(name = "NguoiDung.findByNamSinh", query = "SELECT n FROM NguoiDung n WHERE n.namSinh = :namSinh"),
    @NamedQuery(name = "NguoiDung.findBySdt", query = "SELECT n FROM NguoiDung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "NguoiDung.findByRoleName", query = "SELECT n FROM NguoiDung n WHERE n.roleName = :roleName")})
public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CCCD")
    private String cccd;
    @Size(max = 205)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nam_sinh")
    private int namSinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SDT")
    private String sdt;
    @Size(max = 50)
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "nguoiDungNvId")
    private Collection<NhanVien> nhanVienCollection;
    @OneToMany(mappedBy = "nguoiDungKhId")
    private Collection<KhachHang> khachHangCollection;
    @OneToMany(mappedBy = "nguoiDungTxId")
    private Collection<TaiXe> taiXeCollection;

    public NguoiDung() {
    }

    public NguoiDung(Integer id) {
        this.id = id;
    }

    public NguoiDung(Integer id, String ho, String ten, String username, String password, String email, String cccd, int namSinh, String sdt) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cccd = cccd;
        this.namSinh = namSinh;
        this.sdt = sdt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public Collection<NhanVien> getNhanVienCollection() {
        return nhanVienCollection;
    }

    public void setNhanVienCollection(Collection<NhanVien> nhanVienCollection) {
        this.nhanVienCollection = nhanVienCollection;
    }

    @XmlTransient
    public Collection<KhachHang> getKhachHangCollection() {
        return khachHangCollection;
    }

    public void setKhachHangCollection(Collection<KhachHang> khachHangCollection) {
        this.khachHangCollection = khachHangCollection;
    }

    @XmlTransient
    public Collection<TaiXe> getTaiXeCollection() {
        return taiXeCollection;
    }

    public void setTaiXeCollection(Collection<TaiXe> taiXeCollection) {
        this.taiXeCollection = taiXeCollection;
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
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.NguoiDung[ id=" + id + " ]";
    }
    
}
