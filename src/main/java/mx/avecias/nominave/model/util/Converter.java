/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.util;

import java.text.ParseException;
import mx.avecias.nominave.model.dto.cfdi40.CfdiRelacionados;
import mx.avecias.nominave.model.dto.cfdi40.Complemento;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.dto.cfdi40.Conceptos;
import mx.avecias.nominave.model.dto.cfdi40.Emisor;
import mx.avecias.nominave.model.dto.cfdi40.FormaPago;
import mx.avecias.nominave.model.dto.cfdi40.InformacionGlobal;
import mx.avecias.nominave.model.dto.cfdi40.Receptor;
import mx.avecias.nominave.model.dto.cfdi40.Timbre;
import mx.avecias.nominave.model.dto.cfdi40.cat.CodigoPostal;
import mx.avecias.nominave.model.dto.cfdi40.cat.Exportacion;
import mx.avecias.nominave.model.dto.cfdi40.cat.Meses;
import mx.avecias.nominave.model.dto.cfdi40.cat.MetodoPago;
import mx.avecias.nominave.model.dto.cfdi40.cat.Moneda;
import mx.avecias.nominave.model.dto.cfdi40.cat.Pais;
import mx.avecias.nominave.model.dto.cfdi40.cat.Periodicidad;
import mx.avecias.nominave.model.dto.cfdi40.cat.RegimenFiscal;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoDeComprobante;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoRelacion;
import mx.avecias.nominave.model.dto.cfdi40.cat.UsoCfdi;
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
        comprobante.setSerie(cfdiFormat.opcionalString(comprobanteElement.getAttribute("Serie")));
        comprobante.setFolio(cfdiFormat.opcionalString(comprobanteElement.getAttribute("Folio")));
        comprobante.setFecha(cfdiFormat.formatFecha((comprobanteElement.getAttribute("Fecha"))));
        comprobante.setSello(comprobanteElement.getAttribute("Sello"));
        FormaPago formaPago = new FormaPago();
        formaPago.setClaveFormaPago(cfdiFormat.opcionalString(comprobanteElement.getAttribute("FormaPago")));
        comprobante.setFormaPago(formaPago);
        comprobante.setNoCertificado(comprobanteElement.getAttribute("NoCertificado"));
        comprobante.setCertificado(comprobanteElement.getAttribute("Certificado"));
        comprobante.setCondicionesDepago(comprobanteElement.getAttribute("CondicionesDePago"));
        comprobante.setSubTotal(cfdiFormat.formatImporte(comprobanteElement.getAttribute("SubTotal")));
        comprobante.setDescuento(cfdiFormat.formatImporte(comprobanteElement.getAttribute("Descuento")));
        Moneda moneda = new Moneda();
        moneda.setClaveMoneda(comprobanteElement.getAttribute("Moneda"));
        comprobante.setMoneda(moneda);
        comprobante.setTipoCambio(cfdiFormat.formatImporte(comprobanteElement.getAttribute("TipoCambio")));
        comprobante.setTotal(cfdiFormat.formatImporte(comprobanteElement.getAttribute("Total")));
        TipoDeComprobante tdc = new TipoDeComprobante();
        tdc.setClaveTipoDeComprobante(comprobanteElement.getAttribute("TipoDeComprobante"));
        comprobante.setTipoDeComprobante(tdc);
        Exportacion exportacion = new Exportacion();
        exportacion.setClaveExportacion(comprobanteElement.getAttribute("Exportacion"));
        comprobante.setExportacion(exportacion);
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setClaveMetodopago(cfdiFormat.opcionalString(comprobanteElement.getAttribute("MetodoPago")));
        comprobante.setMetodoPago(metodoPago);
        CodigoPostal cp = new CodigoPostal();
        cp.setClaveCodigopostal(comprobanteElement.getAttribute("LugarExpedicion"));
        comprobante.setLugarDeExpedicion(cp);
        comprobante.setConfirmacion(cfdiFormat.opcionalString(comprobanteElement.getAttribute("Confirmacion")));
        return comprobante;
    }

    private InformacionGlobal getInformacionGlobal(Element comprobanteElement) {
        InformacionGlobal informacionGlobal = null;
        NodeList listInformacionGlobal = comprobanteElement.getElementsByTagName("cfdi:InformacionGlobal");
        for (int j = 0; j < listInformacionGlobal.getLength(); j++) {
            Node informacionGlobalNode = listInformacionGlobal.item(j);
            if (informacionGlobalNode.getNodeType() == Node.ELEMENT_NODE) {
                Element informacionGlobalElement = (Element) informacionGlobalNode;
                informacionGlobal = new InformacionGlobal();
                informacionGlobal.setAnio(cfdiFormat.formatInt(informacionGlobalElement.getAttribute("Año")));
                Periodicidad periodicidad = new Periodicidad();
                periodicidad.setClavePeriodicidad(informacionGlobalElement.getAttribute(""));
                informacionGlobal.setPeriodicidad(periodicidad);
                Meses meses = new Meses();
                meses.setClaveMeses(informacionGlobalElement.getAttribute(""));
                informacionGlobal.setMeses(meses);
            }
        }
        return informacionGlobal;
    }

    private CfdiRelacionados getDatosRelacionados(Element comprobanteElement) {
        CfdiRelacionados cfdiRelacionados = null;
        NodeList listCfdiRelacionados = comprobanteElement.getElementsByTagName("cfdi:CfdiRelacionados");
        for (int j = 0; j < listCfdiRelacionados.getLength(); j++) {
            Node cfdiRelacionadosNode = listCfdiRelacionados.item(j);
            if (cfdiRelacionadosNode.getNodeType() == Node.ELEMENT_NODE) {
                Element cfdiRelacionadosElement = (Element) cfdiRelacionadosNode;
                cfdiRelacionados = new CfdiRelacionados();
                TipoRelacion tipoRelacion = new TipoRelacion();
                tipoRelacion.setClaveTiporelacion(cfdiRelacionadosElement.getAttribute("TipoRelacion"));
                cfdiRelacionados.setTipoRelacion(tipoRelacion);
                NodeList listCfdiRelacionado = cfdiRelacionadosElement.getElementsByTagName("cfdi:CfdiRelacionado");
                for (int k = 0; k < listCfdiRelacionado.getLength(); k++) {
                    Node conceptoCfdiRelacionado = listCfdiRelacionado.item(k);
                    //
                    if (conceptoCfdiRelacionado.getNodeType() == Node.ELEMENT_NODE) {
                        Element cfdiRelacionadoElement = (Element) conceptoCfdiRelacionado;
                        //Conceptos                                        
                        cfdiRelacionadoElement.getAttribute("UUID");
                    }
                }
            }
        }
        return cfdiRelacionados;
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
                CodigoPostal cp = new CodigoPostal();
                cp.setClaveCodigopostal(receptorElement.getAttribute("DomicilioFiscalReceptor"));
                receptor.setDomicilioFiscalReceptor(cp);
                Pais pais = new Pais();
                pais.setClavePais(cfdiFormat.opcionalString(receptorElement.getAttribute("ResidenciaFiscal")));
                receptor.setResidenciaFiscal(pais);
                receptor.setNumRegIdTrib(cfdiFormat.opcionalString(receptorElement.getAttribute("NumRegIdTrib")));
                RegimenFiscal regimenFiscal = new RegimenFiscal();
                regimenFiscal.setClaveRegimenfiscal(receptorElement.getAttribute("RegimenFiscalReceptor"));
                receptor.setRegimenFiscalReceptor(regimenFiscal);
                UsoCfdi usoCfdi = new UsoCfdi();
                usoCfdi.setClaveUsocfdi(receptorElement.getAttribute("UsoCFDI"));
                receptor.setUsoCfdi(usoCfdi);
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
                        System.out.println(conceptoElement.getAttribute("ClaveProdServ"));
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

    public static void getOtros(Element c) {
        c.getAttribute("Importe");
        c.getAttribute("Descuento");
        c.getAttribute("Impuesto");
        c.getAttribute("Base");
        c.getAttribute("Impuesto");
        c.getAttribute("TasaOCuota");
        c.getAttribute("TasaOCuota");
        c.getAttribute("TipoFactor");
        c.getAttribute("TipoFactor");
        c.getAttribute("TasaOCuota");
        c.getAttribute("Importe");
        c.getAttribute("TotalImpuestosTrasladados");
        c.getAttribute("TotalImpuestosTrasladados");
        c.getAttribute("TotalImpuestosTrasladados");
        c.getAttribute("TasaOCuota");
        c.getAttribute("Impuesto");
        c.getAttribute("TipoFactor");
        c.getAttribute("TasaOCuota");
        c.getAttribute("Importe");
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
                // datos informacion global
                InformacionGlobal informacionGlobal = getInformacionGlobal(comprobanteElement);
                comprobante.setInformacionGlobal(informacionGlobal);
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
