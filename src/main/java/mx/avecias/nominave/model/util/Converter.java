/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.util;

import mx.avecias.nominave.model.dto.cfdi44.Comprobante;
import mx.avecias.nominave.model.dto.cfdi44.Emisor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avecias date: Aug 18, 2023 3:04:10 PM
 *
 */
public class Converter {

    private final CfdiFormat cfdiFormat = new CfdiFormat();

    private Comprobante getGeneral(Element comprobanteElement) {
        Comprobante comprobante = new Comprobante();
        // SimpleDateFormat sdf = new SimpleDateFormat(DateEnum.ISO_8601DT.toString());
        comprobante.setVersion(comprobanteElement.getAttribute("Version"));
        comprobante.setSerie(comprobanteElement.getAttribute("Serie"));
        comprobante.setFolio(comprobanteElement.getAttribute("Folio"));
        // comprobante.setFecha(sdf.parse(comprobanteElement.getAttribute("Fecha")));
        comprobanteElement.getAttribute("FormaPago");
        comprobanteElement.getAttribute("MetodoPago");
        comprobanteElement.getAttribute("CondicionesDePago");
        comprobanteElement.getAttribute("SubTotal");
        comprobanteElement.getAttribute("Descuento");
        return comprobante;
    }

    private void getDatosRelacionados(Element comprobanteElement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Emisor getEmisor() {
        Emisor emisor = new Emisor();
        return emisor;
    }

    private void getDatosReceptor(Element receptorElement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void getDatosConceptos(Element conceptoElement, int k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void getDatosAddenda(Element comprobanteElement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Comprobante xml2Cfdi() {
        Comprobante comprobante = new Comprobante();
        return comprobante;
    }

    public Comprobante xml2CfdiNomina(Document document) {
        Comprobante comprobante = null;
        //
        NodeList listComprobante = document.getElementsByTagName("cfdi:Comprobante");
        Element comprobanteElement = null;
        for (int i = 0; i < listComprobante.getLength(); i++) {// [cfdi:Comprobante]
            Node comprobanteNode = listComprobante.item(i);
            if (comprobanteNode.getNodeType() == Node.ELEMENT_NODE) {
                comprobanteElement = (Element) comprobanteNode;
            }
        }
        //
        if (comprobanteElement != null) {
            if (comprobanteElement.getAttribute("TipoDeComprobante").contains("N")) {
                // Datos generales
                comprobante = getGeneral(comprobanteElement);
                // datos cfdi relacionados                        
                getDatosRelacionados(comprobanteElement);
                // Datos del Emisor
                Emisor emisor = getEmisor();
                comprobante.setEmisor(emisor);
                // Datos del Receptor
                // datos receptor
                NodeList listReceptor = document.getElementsByTagName("cfdi:Receptor");
                for (int j = 0; j < listReceptor.getLength(); j++) {
                    Node receptor = listReceptor.item(j);

                    if (receptor.getNodeType() == Node.ELEMENT_NODE) {
                        Element receptorElement = (Element) receptor;
                        // datos receptor
                        getDatosReceptor(receptorElement);
                    }
                }
                // datos conceptos
                NodeList listConceptos = comprobanteElement.getElementsByTagName("cfdi:Conceptos");
                for (int j = 0; j < listConceptos.getLength(); j++) {
                    Node conceptos = listConceptos.item(j);

                    if (conceptos.getNodeType() == Node.ELEMENT_NODE) {
                        Element conceptosElement = (Element) conceptos;

                        NodeList listConcepto = conceptosElement.getElementsByTagName("cfdi:Concepto");
                        for (int k = 0; k < listConcepto.getLength(); k++) {
                            Node concepto = listConcepto.item(k);
                            //
                            if (concepto.getNodeType() == Node.ELEMENT_NODE) {
                                Element conceptoElement = (Element) concepto;
                                //Conceptos                                        
                                getDatosConceptos(conceptoElement, k);
                            }

                        }//Fin For [cfdi:Concepto]
                    }
                }//Fin FOR [cfdi:Conceptos]       
                getDatosAddenda(comprobanteElement);
            }

        }
        return comprobante;
    }
}
