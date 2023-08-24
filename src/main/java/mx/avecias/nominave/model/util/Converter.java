/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.util;

import java.text.ParseException;
import java.util.EnumSet;
import mx.avecias.nominave.model.dto.cfdi40.Complemento;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.dto.cfdi40.Conceptos;
import mx.avecias.nominave.model.dto.cfdi40.Emisor;
import mx.avecias.nominave.model.dto.cfdi40.Receptor;
import mx.avecias.nominave.model.dto.cfdi40.Timbre;
import mx.avecias.nominave.model.dto.cfdi40.cat.RegimenFiscal;
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

    private Comprobante getGeneral(Element comprobanteElement) throws ParseException {
        Comprobante comprobante = new Comprobante();
        comprobante.setVersion(comprobanteElement.getAttribute("Version"));
        comprobante.setSerie(comprobanteElement.getAttribute("Serie"));
        comprobante.setFolio(comprobanteElement.getAttribute("Folio"));
        comprobante.setFecha(cfdiFormat.formatFecha((comprobanteElement.getAttribute("Fecha"))));
        comprobanteElement.getAttribute("FormaPago");
        comprobanteElement.getAttribute("MetodoPago");
        comprobanteElement.getAttribute("CondicionesDePago");
        comprobanteElement.getAttribute("SubTotal");
        comprobanteElement.getAttribute("Descuento");
        return comprobante;
    }

    private void getDatosRelacionados(Element comprobanteElement) {
        comprobanteElement.getAttribute("Serie");
        comprobanteElement.getAttribute("Folio");
    }

    private Emisor getEmisor(Element comprobanteElement) {
        Emisor emisor = null;
        NodeList listEmisor = comprobanteElement.getElementsByTagName("cfdi:Emisor");
        for (int j = 0; j < listEmisor.getLength(); j++) {
            Node emisorNode = listEmisor.item(j);
            if (emisorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element emisorElement = (Element) emisorNode;
                emisor = new Emisor();
                emisor.setRfc(emisorElement.getAttribute("Rfc"));
                emisor.setNombre(emisorElement.getAttribute("Nombre"));
                emisor.setFacAtrAdquirente(emisorElement.getAttribute("FacAtrAdquirente"));
                RegimenFiscal regimenFiscal = new RegimenFiscal();
                regimenFiscal.setClaveRegimenfiscal(emisorElement.getAttribute("RegimenFiscal"));
                emisor.setRegimenFiscal(regimenFiscal);
            }
        }
        return emisor;
    }

    private Receptor getDatosReceptor(Element comprobanteElement) {
        Receptor receptor = null;
        NodeList listReceptor = comprobanteElement.getElementsByTagName("cfdi:Receptor");
        for (int j = 0; j < listReceptor.getLength(); j++) {
            Node receptorNode = listReceptor.item(j);
            if (receptorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element receptorElement = (Element) receptorNode;
                // datos receptor
                receptor = new Receptor();
                receptor.setRfc(receptorElement.getAttribute("Rfc"));
                receptor.setNombre(receptorElement.getAttribute("Nombre"));
            }
        }
        return receptor;
    }

    private Conceptos getDatosConceptos(Element comprobanteElement) {
        Conceptos conceptos = null;
        NodeList listConceptos = comprobanteElement.getElementsByTagName("cfdi:Conceptos");
        for (int j = 0; j < listConceptos.getLength(); j++) {
            Node conceptosNode = listConceptos.item(j);
            if (conceptosNode.getNodeType() == Node.ELEMENT_NODE) {
                conceptos = new Conceptos();
                Element conceptosElement = (Element) conceptosNode;
                NodeList listConcepto = conceptosElement.getElementsByTagName("cfdi:Concepto");
                for (int k = 0; k < listConcepto.getLength(); k++) {
                    Node concepto = listConcepto.item(k);
                    //
                    if (concepto.getNodeType() == Node.ELEMENT_NODE) {
                        Element conceptoElement = (Element) concepto;
                        //Conceptos                                        
                        conceptoElement.getAttribute("ClaveProdServ");
                        conceptoElement.getAttribute("NoIdentificacion");
                        conceptoElement.getAttribute("Cantidad");
                        conceptoElement.getAttribute("ClaveUnidad");
                        conceptoElement.getAttribute("Unidad");
                        conceptoElement.getAttribute("Descripcion");
                        conceptoElement.getAttribute("ValorUnitario");
                        conceptoElement.getAttribute("Importe");
                        conceptoElement.getAttribute("Descuento");
                    }

                }
            }
        }
        return conceptos;
    }

    private static Timbre getTimbre(Element comprobanteElement) {
        Timbre timbre = null;
        NodeList listTimbreConceptos = comprobanteElement.getElementsByTagName("tfd:TimbreFiscalDigital");
        for (int i = 0; i < listTimbreConceptos.getLength(); i++) {
            Node timbreConceptos = listTimbreConceptos.item(i);
            if (timbreConceptos.getNodeType() == Node.ELEMENT_NODE) {
                Element timbreConceptosElement = (Element) timbreConceptos;
                timbre = new Timbre();
                timbre.setUuid(timbreConceptosElement.getAttribute("UUID"));
            }
        }
        return timbre;
    }

    private void getDatosAddenda(Element comprobanteElement) {

    }

    public Comprobante xml2Cfdi() {
        Comprobante comprobante = new Comprobante();
        return comprobante;
    }

    public Comprobante xml2CfdiNomina(Document document) throws ParseException {
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
            // validar tipo de cfdi nomina
            if (comprobanteElement.getAttribute("TipoDeComprobante").contains("N")) {
                // Datos generales
                comprobante = getGeneral(comprobanteElement);
                // datos cfdi relacionados                        
                getDatosRelacionados(comprobanteElement);
                // Datos del Emisor
                Emisor emisor = getEmisor(comprobanteElement);
                comprobante.setEmisor(emisor);
                // Datos del Receptor
                Receptor receptor = getDatosReceptor(comprobanteElement);
                comprobante.setReceptor(receptor);
                // datos conceptos
                Conceptos conceptos = getDatosConceptos(comprobanteElement);
                comprobante.setConceptos(conceptos);
                // timbre
                Timbre timbre = getTimbre(comprobanteElement);
                Complemento complemento = new Complemento();
                // addenda
                getDatosAddenda(comprobanteElement);
            }

        }
        return comprobante;
    }
}
