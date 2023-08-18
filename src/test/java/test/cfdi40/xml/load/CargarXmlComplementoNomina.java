/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml.load;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.avecias.nominave.model.dto.cfdi44.Comprobante;
import mx.avecias.nominave.model.enums.DateEnum;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author avecias date: Aug 17, 2023 11:45:42 AM
 *
 */
public class CargarXmlComplementoNomina {

    private static Integer folioFactura = 1;
    private static Integer folioDevolucion = 1;
    private static Integer folioTraslado = 1;
    private static Integer folioCredito = 1;
    private static Integer folioNotaCredito = 1;

    //Cfdi:
    private static String getUUID(Document document) {
        String uuid = "";
        NodeList listTimbreConceptos = document.getElementsByTagName("tfd:TimbreFiscalDigital");
        for (int i = 0; i < listTimbreConceptos.getLength(); i++) {
            Node timbreConceptos = listTimbreConceptos.item(i);
            if (timbreConceptos.getNodeType() == Node.ELEMENT_NODE) {
                Element timbreConceptosElement = (Element) timbreConceptos;

                uuid = timbreConceptosElement.getAttribute("UUID");
            }
        }// Fin For [tfd:TimbreFiscalDigital]
        return uuid;
    }

    //Cfdi:
    public static Comprobante getDatosGenerales(Element comprobanteElement) throws ParseException {
        Comprobante comprobante = new Comprobante();
        SimpleDateFormat sdf = new SimpleDateFormat(DateEnum.ISO_8601DT.toString());
        comprobante.setVersion(comprobanteElement.getAttribute("Version"));
        comprobante.setSerie(comprobanteElement.getAttribute("Serie"));
        comprobante.setFolio(comprobanteElement.getAttribute("Folio"));
        comprobante.setFecha(sdf.parse(comprobanteElement.getAttribute("Fecha")));
        comprobanteElement.getAttribute("FormaPago");
        comprobanteElement.getAttribute("MetodoPago");
        comprobanteElement.getAttribute("CondicionesDePago");
        comprobanteElement.getAttribute("SubTotal");
        comprobanteElement.getAttribute("Descuento");
        comprobanteElement.getAttribute("Moneda");
        comprobanteElement.getAttribute("Total");
        comprobanteElement.getAttribute("TipoDeComprobante");
        comprobanteElement.getAttribute("LugarExpedicion");
        return comprobante;
    }

    //Cfdi:
    public static void getDatosRelacionados(Element comprobanteElement) {
        comprobanteElement.getAttribute("Serie");
        comprobanteElement.getAttribute("Folio");
    }

    //Cfdi:
    public static StringBuilder getDatosEmisor() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n#\n#--EMISOR EDITORIAL TRILLAS S.A DE C.V.\n#\n"
                + "rfcEmisor= ETR820329K89\n"
                + "nombre=EDITORIAL TRILLAS,S.A.DE C.V.\n"
                + "regimenFiscal=601");
        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosReceptor(Element receptorElement) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n#\n#--RECEPTOR FACTURAR A:\n#\n");
        sb.append("rfcReceptor=").append(receptorElement.getAttribute("Rfc")).append("\nusoCFDI=")
                .append(receptorElement.getAttribute("UsoCFDI")).append("\nnombreReceptor=")
                .append(receptorElement.getAttribute("Nombre"));
        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosConceptos(Element conceptoElement, int contador) {
        DecimalFormat df = new DecimalFormat("00000");
        StringBuilder sb = new StringBuilder();
        sb.append("\n#\n#--CONCEPTO OBRA_0000").append(contador + 1).append(" REG 6");
        sb.append("\nclaveProdServ_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("ClaveProdServ"))
                .append("\nnoIdentificacion_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("NoIdentificacion"))
                .append("\ncantidad_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Cantidad"))
                .append("\nclaveUnidad_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("ClaveUnidad"))
                .append("\nunidad_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Unidad"))
                .append("\ndescripcion_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Descripcion"))
                .append("\nvalorUnitario_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("ValorUnitario"))
                .append("\nimporte_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Importe"))
                .append("\ndescuento_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Descuento"));
        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosImpuestosTrasladadosConceptoPorDefecto(Element conceptoElement, int contador) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("00000");
        //if (impuestosElement.getAttribute("Impuestos").contains("TotalImpuestosTrasladados")) {
        int importe = Integer.parseInt(conceptoElement.getAttribute("Importe"));
        int descuento = Integer.parseInt(conceptoElement.getAttribute("Descuento"));
        String baseCalculada = Integer.toString(importe - descuento);

        sb.append("\nbaseTraslado_").append(df.format(contador + 1)).append("=").append(baseCalculada);
        //}
        sb.append("\nimpuestoTraslado_").append(df.format(contador + 1)).append("=").append(conceptoElement.getAttribute("Impuesto"));

        sb.append("\ntipoFactorTraslado_").append(df.format(contador + 1)).append("=Tasa")
                .append("\ntasaOCuotaTraslado_").append(df.format(contador + 1)).append("=").append("0.000000")
                .append("\nimporteTraslado_").append(df.format(contador + 1)).append("=").append("0.00");

        return sb;
    }

    public static StringBuilder getDatosImpuestosTrasladadosConcepto(Element impuestosTrasladoElement, int contador) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("00000");
        //if (impuestosElement.getAttribute("Impuestos").contains("TotalImpuestosTrasladados")) {
        sb.append("\nbaseTraslado_").append(df.format(contador + 1)).append("=").append(impuestosTrasladoElement.getAttribute("Base"));
        //}

        sb.append("\nimpuestoTraslado_").append(df.format(contador + 1)).append("=").append(impuestosTrasladoElement.getAttribute("Impuesto"));

        if (impuestosTrasladoElement.getAttribute("TasaOCuota") != null && impuestosTrasladoElement.getAttribute("TasaOCuota").isEmpty() && impuestosTrasladoElement.getAttribute("TipoFactor").equals("Exento")) {
            sb.append("\ntipoFactorTraslado_").append(df.format(contador + 1)).append("=Tasa")
                    .append("\ntasaOCuotaTraslado_").append(df.format(contador + 1)).append("=").append("0.000000")
                    .append("\nimporteTraslado_").append(df.format(contador + 1)).append("=").append("0.00");

        } else {
            sb.append("\ntipoFactorTraslado_").append(df.format(contador + 1)).append("=").append(impuestosTrasladoElement.getAttribute("TipoFactor"));
            sb.append("\ntasaOCuotaTraslado_").append(df.format(contador + 1)).append("=").append(impuestosTrasladoElement.getAttribute("TasaOCuota"))
                    .append("\nimporteTraslado_").append(df.format(contador + 1)).append("=").append(impuestosTrasladoElement.getAttribute("Importe"));
        }

        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosImpuestosGeneral(Element impuestosElement) {
        StringBuilder sb = new StringBuilder();

        if (impuestosElement.getAttribute("TotalImpuestosTrasladados") != null && !impuestosElement.getAttribute("TotalImpuestosTrasladados").isEmpty()) {
            sb.append("\n#\n#\n#--TOTAL IMPUESTOS TRASLADADOS\n#")
                    .append("\ntotalImpuestosTrasladados=").append(impuestosElement.getAttribute("TotalImpuestosTrasladados"));
        }

        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosImpuestosGeneralPorDefecto() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n#\n#\n#--TOTAL IMPUESTOS TRASLADADOS\n#")
                .append("\ntotalImpuestosTrasladados=").append("0");

        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosImpuestosTrasladadosGeneral(Element totalImpuestosTrasladoElement, int contador) {

        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("00000");
        DecimalFormat dfi = new DecimalFormat("0.000000");

        sb.append("\n#\n#-IMPUESTOS TRASLADOS TASA ").append(totalImpuestosTrasladoElement.getAttribute("TasaOCuota")).append("\n#");

        sb.append("\nimpuestoTraslados_").append(df.format(contador + 2)).append("=").append(totalImpuestosTrasladoElement.getAttribute("Impuesto"))
                .append("\ntipoFactorTraslados_").append(df.format(contador + 2)).append("=").append(totalImpuestosTrasladoElement.getAttribute("TipoFactor"))
                .append("\ntasaOCuotaTraslados_").append(df.format(contador + 2)).append("=").append(totalImpuestosTrasladoElement.getAttribute("TasaOCuota"))
                .append("\nimporteTraslados_").append(df.format(contador + 2)).append("=").append(totalImpuestosTrasladoElement.getAttribute("Importe"))
                .append("\n#\n");

        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosImpuestosTrasladadosGeneralPorDefecto() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n#\n#-IMPUESTOS TRASLADOS TASA ").append("0.000000").append("\n#");

        sb.append("\nimpuestoTraslados_").append("00001").append("=").append("002")
                .append("\ntipoFactorTraslados_").append("00001").append("=").append("Tasa")
                .append("\ntasaOCuotaTraslados_").append("00001").append("=").append("0.000000")
                .append("\nimporteTraslados_").append("00001").append("=0")
                .append("\n#\n");

        return sb;
    }

    //Cfdi:
    public static StringBuilder getDatosAddenda(Element comprobanteElement) {

        StringBuilder sb = new StringBuilder();

        sb.append("\nclaveCliente=").append("\nusuario=").append("\nterminal=").append("\nprograma=")
                .append("\npesoBruto=").append("\nclaveVendedor=").append("\nvendedor=");

        String serie = comprobanteElement.getAttribute("Serie");

        if (serie.length() == 3 && serie.endsWith("A")) {
            sb.append("\ntipoFactura=50");
        } else if (serie.length() == 3 && serie.endsWith("B")) {
            sb.append("\ntipoFactura=60");
        } else if (serie.length() == 3 && serie.endsWith("T")) {
            sb.append("\ntipoFactura=02");
        } else if (serie.length() == 3 && serie.endsWith("Z")) {
            sb.append("\ntipoFactura=11");
        } else if (serie.length() >= 2) {
            sb.append("\ntipoFactura=01");
        } else {
            sb.append("\ntipoFactura=");
        }

        sb.append("\nnoInventario=").append("\n\ncalleReceptor=").append("\nnomaut=").append("\nemail1=")
                .append("\nemail2=").append("\n\ncoloniaReceptor=").append("\nciudadReceptor=").append("\nestadoReceptor=")
                .append("\npaisReceptor=").append("\ncpReceptor=").append("\nmunicipioReceptor=").append("\ntelefonoReceptor=")
                .append("\nnombrepagare=").append("\n\nnombreEnviar=").append("\ncalleEnviar=").append("\n\ncoloniaEnviar=")
                .append("\nciudadEnviar=").append("\nestadoEnviar=").append("\npaisEnviar=").append("\ncpEnviar=")
                .append("\ntelefonoEnviar=").append("\n\nreferencia=").append("\nfechaReferencia=").append("\nobservaciones=")
                .append("\npedtri=").append("\nnointe=").append("\nnrinte=").append("\napbanco=").append("\npaypal=")
                .append("\n\n\ngarantia=").append("\nfechaVencimiento=").append("\nconductoEnvio=").append("\n\nformaDePagoDescripcion=POR DEFINIR")
                .append("\nctametpag=").append("\n\nclavePedido=").append("\nfuentePedido=").append("\ntotalLibros=0.0").append("\ntotalOtros=0.0")
                .append("\nimporteAnticipo=").append("\n\ntunif=").append("\n#--FIN DE FACTURA");

        return sb;
    }

    public static void main(String[] args) {
        try {
            // Directorio raiz de los XMLs
            File root = new File("/Users/avecias/Downloads/");
            String[] extensions = {"xml"}; // archivos con extencion xml
            // Coleccion de archivos de xml
            Collection<File> files = FileUtils.listFiles(root, extensions, true);
            // 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            for (File file : files) {
                System.out.println("archivo: " + file.getName());
                // comprobante nulo
                Comprobante comprobante = null;
                // parse del archivo
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();
                // obtenemos comprobante
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
                        // datos generales                        
                        comprobante = getDatosGenerales(comprobanteElement);
                        // datos cfdi relacionados                        
                        getDatosRelacionados(comprobanteElement);
                        // datos emisor                       
                        getDatosEmisor();
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
                    System.out.println(comprobante);
                }
            }// Fil For [cfdi:Comprobante]
            System.out.println("comprobante ");
        } catch (FileNotFoundException ex) {
            System.out.println("Error, " + ex);
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            System.out.println("Error, " + ex);
        } catch (ParseException ex) {
            Logger.getLogger(CargarXmlComplementoNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
