/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.enums;

/**
 *
 * @author ADMIN
 */
public enum TrangThai {
    ACTIVE("Active"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    PAID("Paid"),               // Trạng thái thanh toán
    CANCELLED_DV("Cancelled"),
    PENDING("Pending");

    private final String displayName;

    TrangThai(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
