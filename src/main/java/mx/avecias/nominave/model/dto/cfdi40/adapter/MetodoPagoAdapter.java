/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.MetodoPago;

/**
 *
 * @author avecias date: Nov 29, 2023 6:13:46 PM
 *
 */
public class MetodoPagoAdapter extends XmlAdapter<String, MetodoPago> {

    @Override
    public MetodoPago unmarshal(String vt) throws Exception {
        MetodoPago mp = new MetodoPago();
        mp.setClaveMetodopago(vt);
        return mp;
    }

    @Override
    public String marshal(MetodoPago bt) throws Exception {
        if (bt != null) {
            return bt.getClaveMetodopago();
        }
        return null;
    }

}
