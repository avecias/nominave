/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoRelacion;

/**
 *
 * @author avecias date: Dec 6, 2023 6:16:44 PM
 *
 */
public class TipoRelacionAdapter extends XmlAdapter<String, TipoRelacion> {

    @Override
    public TipoRelacion unmarshal(String vt) throws Exception {
        TipoRelacion tipoRelacion = new TipoRelacion();
        tipoRelacion.setClaveTiporelacion(vt);
        return tipoRelacion;
    }

    @Override
    public String marshal(TipoRelacion bt) throws Exception {
        if (bt != null) {
            return bt.getClaveTiporelacion();
        }
        return null;
    }

}
