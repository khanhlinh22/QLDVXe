/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

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
    //Khai bao cac quyen
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String NHANVIEN = "ROLE_NHANVIEN";
    public static final String KHACHHANG = "ROLE_KHACHHANG";
    public static final String TAIXE = "ROLE_TAIXE";

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
        //Get controll passworod
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        //Set confirmPassword
    }
    /**
     * @return the confirmPassword
     */

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
    // co tuy chinh cho nay 
    private String roleName;
    @OneToMany(mappedBy = "nguoiDungNvId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// them phan cascade 
    @JsonIgnore // Can them ignore tat ca các truong du lieu onetomany
    private Set<NhanVien> nhanVienSet;
    @OneToMany(mappedBy = "nguoiDungKhId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// them phan cascade 
    @JsonIgnore
    private Set<KhachHang> khachHangSet;
    @OneToMany(mappedBy = "nguoiDungTxId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// them phan cascade 
    @JsonIgnore
    private Set<TaiXe> taiXeSet;
    //Phai transient ca hai cai la multipartFile và confirmPassword
    @Transient
    private MultipartFile file;
    @Transient
    private String confirmPassword;

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
    public Set<NhanVien> getNhanVienSet() {
        return nhanVienSet;
    }

    public void setNhanVienSet(Set<NhanVien> nhanVienSet) {
        this.nhanVienSet = nhanVienSet;
    }

    @XmlTransient
    public Set<KhachHang> getKhachHangSet() {
        return khachHangSet;
    }

    public void setKhachHangSet(Set<KhachHang> khachHangSet) {
        this.khachHangSet = khachHangSet;
    }

    @XmlTransient
    public Set<TaiXe> getTaiXeSet() {
        return taiXeSet;
    }

    public void setTaiXeSet(Set<TaiXe> taiXeSet) {
        this.taiXeSet = taiXeSet;
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

    

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
