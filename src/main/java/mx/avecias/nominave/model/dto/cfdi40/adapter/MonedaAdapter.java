/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.Moneda;

/**
 *
 * @author avecias date: Nov 29, 2023 5:43:21 PM
 *
 */
public class MonedaAdapter extends XmlAdapter<String, Moneda> {

    @Override
    public Moneda unmarshal(String vt) throws Exception {
        Moneda moneda = new Moneda();
        moneda.setClaveMoneda(vt);
        return moneda;
    }

    @Override
    public String marshal(Moneda bt) throws Exception {
        if (bt != null) {
            return bt.getClaveMoneda();
        }
        return null;
    }

}
