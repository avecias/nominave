/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.Meses;

/**
 *
 * @author avecias date: Dec 5, 2023 12:56:34 PM
 *
 */
public class MesesAdapter extends XmlAdapter<String, Meses> {

    @Override
    public Meses unmarshal(String vt) throws Exception {
        Meses meses = new Meses();
        meses.setClaveMeses(vt);
        return meses;
    }

    @Override
    public String marshal(Meses bt) throws Exception {
        if (bt != null) {
            return bt.getClaveMeses();
        }
        return null;
    }

}
