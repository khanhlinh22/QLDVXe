/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.formatters;

import com.dv.pojo.TaiXe;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class TaiXeFormatter implements Formatter<TaiXe>{
      @Override
    public String print(TaiXe taix, Locale locale) {
        return String.valueOf(taix.getId());
    }
//taixId viet tat cho taixe de tranh lon voi tx cua tuyenxe
    @Override
    public TaiXe parse(String taixId, Locale locale) throws ParseException {
        TaiXe ta = new TaiXe();
        ta.setId(Integer.parseInt(taixId));
        
        return ta;
    }
}
