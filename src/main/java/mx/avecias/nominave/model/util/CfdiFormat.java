/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mx.avecias.nominave.model.enums.DateEnum;
import mx.avecias.nominave.model.enums.DecimalEnum;

/**
 *
 * @author avecias date: Aug 18, 2023 1:20:22 PM
 *
 */
public class CfdiFormat {

    SimpleDateFormat sdf = new SimpleDateFormat(DateEnum.ISO_8601DT.getValue());
    DecimalFormat df = new DecimalFormat(DecimalEnum.IMPORTE.getValue());

    /**
     *
     * @param a
     * @return
     * @throws ParseException
     */
    public Date formatFecha(String a) throws ParseException {
        if (a == null || a.isEmpty()) {
            return null;
        }
        return sdf.parse(a);
    }

    /**
     *
     * @param f
     * @return
     */
    public String parseFecha(Date f) {
        return (f == null) ? null : sdf.format(f);
    }

    /**
     *
     * @param s
     * @return
     */
    public String opcionalString(String s) {
        return (s == null || s.isEmpty()) ? null : s;
    }

    /**
     *
     * @param d
     * @return
     * @throws ParseException
     */
    public BigDecimal formatImporte(String d) throws ParseException {
        if (d == null || d.isEmpty()) {
            return null;
        }
        return new BigDecimal(d);
    }
    
    public Integer formatInt(String i){
        if (i == null || i.isEmpty()) {
            return null;
        }
        return Integer.valueOf(i);
    }

}
