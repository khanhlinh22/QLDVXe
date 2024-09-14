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
      HUY("Hủy"),               // Cancelled
    DA_HOAN_THANH("Đã hoàn thành"), // Completed
    DANG_HOAT_DONG("Đang hoạt động"); // Active

    private final String displayName;

    TrangThai(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static TrangThai fromString(String text) {
        for (TrangThai b : TrangThai.values()) {
            if (b.displayName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
