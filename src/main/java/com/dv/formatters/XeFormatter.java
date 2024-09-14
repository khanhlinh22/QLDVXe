/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.formatters;

import com.dv.pojo.Xe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class XeFormatter implements Formatter<Xe>{
    @Override
    public String print(Xe xe, Locale locale) {
        return String.valueOf(xe.getId());
    }

    @Override
    public Xe parse(String xeId, Locale locale) throws ParseException {
        Xe x = new Xe();
        x.setId(Integer.parseInt(xeId));
        
        return x;
    }
}
