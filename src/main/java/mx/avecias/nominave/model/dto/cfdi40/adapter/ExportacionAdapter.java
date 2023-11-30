/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.Exportacion;

/**
 *
 * @author avecias date: Nov 29, 2023 6:10:12 PM
 *
 */
public class ExportacionAdapter extends XmlAdapter<String, Exportacion> {

    @Override
    public Exportacion unmarshal(String vt) throws Exception {
        Exportacion e = new Exportacion();
        e.setClaveExportacion(vt);
        return e;
    }

    @Override
    public String marshal(Exportacion bt) throws Exception {
        if (bt != null) {
            return bt.getClaveExportacion();
        }
        return null;
    }

}
