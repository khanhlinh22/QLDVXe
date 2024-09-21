/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.formatters;

import com.dv.pojo.DatVe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class DatVeFomatter implements Formatter<DatVe>{
    @Override
    public String print(DatVe dv, Locale locale) {
        return String.valueOf(dv.getId());
    }

    @Override
    public DatVe parse(String dvId, Locale locale) throws ParseException {
        DatVe d = new DatVe();
        d.setId(Integer.parseInt(dvId));
        
        return d;
    }
}
