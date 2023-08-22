/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml.load;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.avecias.nominave.model.dto.cfdi44.Comprobante;
import mx.avecias.nominave.model.util.Converter;
import org.apache.commons.io.FileUtils;
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

    //Cfdi:Complemento:
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
            // creamos el objecto convertidor 
            Converter converter = new Converter();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            for (File file : files) {
                System.out.println("archivo: " + file.getName());
                // parse del archivo
                Document document = builder.parse(file);
                // normalizar en objecto document
                document.getDocumentElement().normalize();
                // convertidor
                Comprobante comprobante = converter.xml2CfdiNomina(document);
                System.out.println(comprobante);
            }
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
