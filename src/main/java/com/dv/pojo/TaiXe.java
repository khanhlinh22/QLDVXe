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
@Table(name = "tai_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiXe.findAll", query = "SELECT t FROM TaiXe t"),
    @NamedQuery(name = "TaiXe.findById", query = "SELECT t FROM TaiXe t WHERE t.id = :id"),
    @NamedQuery(name = "TaiXe.findByBangCap", query = "SELECT t FROM TaiXe t WHERE t.bangCap = :bangCap")})
public class TaiXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bang_cap")
    private String bangCap;
    @JoinColumn(name = "nguoi_dung_tx_id", referencedColumnName = "id")
    @ManyToOne
    private NguoiDung nguoiDungTxId;

    public TaiXe() {
    }

    public TaiXe(Integer id) {
        this.id = id;
    }

    public TaiXe(Integer id, String bangCap) {
        this.id = id;
        this.bangCap = bangCap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBangCap() {
        return bangCap;
    }

    public void setBangCap(String bangCap) {
        this.bangCap = bangCap;
    }

    public NguoiDung getNguoiDungTxId() {
        return nguoiDungTxId;
    }

    public void setNguoiDungTxId(NguoiDung nguoiDungTxId) {
        this.nguoiDungTxId = nguoiDungTxId;
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
        if (!(object instanceof TaiXe)) {
            return false;
        }
        TaiXe other = (TaiXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.TaiXe[ id=" + id + " ]";
    }
    
}
