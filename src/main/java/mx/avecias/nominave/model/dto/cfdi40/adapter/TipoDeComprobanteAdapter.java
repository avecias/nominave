/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoDeComprobante;

/**
 *
 * @author avecias date: Nov 29, 2023 6:06:04 PM
 *
 */
public class TipoDeComprobanteAdapter extends XmlAdapter<String, TipoDeComprobante> {

    @Override
    public TipoDeComprobante unmarshal(String vt) throws Exception {
        TipoDeComprobante tipoDeComprobante = new TipoDeComprobante();
        tipoDeComprobante.setClaveTipoDeComprobante(vt);
        return tipoDeComprobante;
    }

    @Override
    public String marshal(TipoDeComprobante bt) throws Exception {
        if (bt != null) {
            return bt.getClaveTipoDeComprobante();
        }
        return null;
    }

}
