/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author avecias date: Nov 23, 2023 6:15:42 PM
 *
 */
public class TImporteAdapter extends XmlAdapter<String, BigDecimal> {

    private final DecimalFormat df = new DecimalFormat("###,###,###,###,###,###.######");

    @Override
    public BigDecimal unmarshal(String vt) throws Exception {
        return vt != null ? new BigDecimal(vt) : null;
    }

    @Override
    public String marshal(BigDecimal bt) throws Exception {
        return bt != null ? df.format(bt) : null;
    }

}
