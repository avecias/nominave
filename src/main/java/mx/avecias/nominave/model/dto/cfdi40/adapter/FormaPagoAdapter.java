/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import mx.avecias.nominave.model.dto.cfdi40.FormaPago;

/**
 *
 * @author avecias date: Nov 29, 2023 5:29:51 PM
 *
 */
public class FormaPagoAdapter extends XmlAdapter<String, FormaPago> {

    @Override
    public FormaPago unmarshal(String fps) throws Exception {
        FormaPago formaPago = new FormaPago();
        formaPago.setClaveFormaPago(fps);
        return formaPago;
    }

    @Override
    public String marshal(FormaPago formaPago) throws Exception {
        if (formaPago != null) {
            return formaPago.getClaveFormaPago();
        }
        return null;
    }
}
