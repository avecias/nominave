/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.CodigoPostal;

/**
 *
 * @author avecias date: Nov 29, 2023 6:20:17 PM
 *
 */
public class CodigoPostalAdapter extends XmlAdapter<String, CodigoPostal> {

    @Override
    public CodigoPostal unmarshal(String vt) throws Exception {
        CodigoPostal cp = new CodigoPostal();
        cp.setClaveCodigopostal(vt);
        return cp;
    }

    @Override
    public String marshal(CodigoPostal bt) throws Exception {
        if (bt != null) {
            return bt.getClaveCodigopostal();
        }
        return null;
    }

}
