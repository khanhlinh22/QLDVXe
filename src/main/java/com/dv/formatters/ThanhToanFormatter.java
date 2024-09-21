/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.formatters;

import com.dv.pojo.ThanhToan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class ThanhToanFormatter implements Formatter<ThanhToan>{
      @Override
    public String print(ThanhToan tt, Locale locale) {
        return String.valueOf(tt.getId());
    }

    @Override
    public ThanhToan parse(String ttId, Locale locale) throws ParseException {
        ThanhToan thanh = new ThanhToan();
        thanh.setId(Integer.parseInt(ttId));
        
        return thanh;
    }
}
