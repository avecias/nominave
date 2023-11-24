/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author avecias date: Nov 23, 2023 5:05:57 PM
 *
 */
public class FechaAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Date unmarshal(String vt) throws Exception {
        return df.parse(vt);
    }

    @Override
    public String marshal(Date bt) throws Exception {
        return df.format(bt);
    }

}
