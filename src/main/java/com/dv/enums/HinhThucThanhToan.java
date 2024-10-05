/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.enums;

/**
 *
 * @author ADMIN
 */
public enum HinhThucThanhToan {
    CASH("CASH"),
    BANK("Bank"),
    VNPAY("Vnpay");
    private final String displayName;

    HinhThucThanhToan(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
