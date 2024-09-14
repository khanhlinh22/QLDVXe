/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.formatters;

import com.dv.pojo.TuyenXe;
import java.util.Locale;
import java.text.ParseException;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class TuyenXeFormatter implements Formatter<TuyenXe>{
     @Override
    public String print(TuyenXe tx, Locale locale) {
        return String.valueOf(tx.getId());
    }

    @Override
    public TuyenXe parse(String txId, Locale locale) throws ParseException {
        TuyenXe t = new TuyenXe();
        t.setId(Integer.parseInt(txId));
        
        return t;
    }
}
