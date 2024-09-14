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
@Table(name = "xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x"),
    @NamedQuery(name = "Xe.findById", query = "SELECT x FROM Xe x WHERE x.id = :id"),
    @NamedQuery(name = "Xe.findBySoHieu", query = "SELECT x FROM Xe x WHERE x.soHieu = :soHieu"),
    @NamedQuery(name = "Xe.findByLoai", query = "SELECT x FROM Xe x WHERE x.loai = :loai")})
public class Xe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "so_hieu")
    private String soHieu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "loai")
    private String loai;

    public Xe() {
    }

    public Xe(Integer id) {
        this.id = id;
    }

    public Xe(Integer id, String soHieu, String loai) {
        this.id = id;
        this.soHieu = soHieu;
        this.loai = loai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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
        if (!(object instanceof Xe)) {
            return false;
        }
        Xe other = (Xe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.Xe[ id=" + id + " ]";
    }
    
}
