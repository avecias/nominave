/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.Periodicidad;

/**
 *
 * @author avecias date: Dec 5, 2023 1:04:13 PM
 *
 */
public class PeriodicidadAdapter extends XmlAdapter<String, Periodicidad> {

    @Override
    public Periodicidad unmarshal(String vt) throws Exception {
        Periodicidad periodicidad = new Periodicidad();
        periodicidad.setClavePeriodicidad(vt);
        return periodicidad;
    }

    @Override
    public String marshal(Periodicidad bt) throws Exception {
        if (bt != null) {
            return bt.getClavePeriodicidad();
        }
        return null;
    }

}
