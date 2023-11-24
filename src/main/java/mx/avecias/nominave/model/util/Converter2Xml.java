/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.dto.cfdi40.nomina12.Nomina;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author avecias date: Nov 14, 2023 1:24:10 PM
 *
 */
public class Converter2Xml {

    public String cfdi(Comprobante comprobante) throws JAXBException {
        // Converter ComprobanteXml to XML string
        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        // 
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");
        jaxbMarshaller.marshal(comprobante, sw);
        return sw.toString();
    }

    public String cfdiNomina(Comprobante comprobante) throws JAXBException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        // Converter ComprobanteXml to XML string
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        StringWriter sw = new StringWriter();
        // CFDI 4.0
        JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");
        jaxbMarshaller.marshal(comprobante, doc);
        // Adding Node
        NodeList nodeComplemento = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/4", "Complemento");
        JAXBContext jc = JAXBContext.newInstance(Nomina.class);
        Marshaller jm = jc.createMarshaller();
        jm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jm.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/informacion_fiscal/factura_electronica/Documents/Complementoscfdi/nomina12.xsd");
        jm.marshal(comprobante.getComplemento().getNominas().get(0), nodeComplemento.item(0));
        //
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(sw);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        Properties oprops = new Properties();
//        oprops.put(OutputKeys.OMIT_XML_DECLARATION, "no");
        oprops.put(OutputKeys.INDENT, "yes");
        oprops.put(OutputKeys.METHOD, "xml");
        oprops.put(OutputKeys.ENCODING, "UTF-8");
        oprops.put("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperties(oprops);
        transformer.transform(domSource, result);
        return sw.toString();
    }

//    public static String createDocumentCfdiPago(Comprobante comprobante) throws JAXBException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
//        // Converter ComprobanteXml to XML string
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setNamespaceAware(true);
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.newDocument();
//        StringWriter sw = new StringWriter();
//        // CFDI 4.0
//        JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");
//        jaxbMarshaller.marshal(comprobante, doc);
//        // Adding Node
//        NodeList nodeComplemento = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/4", "Complemento");
//        JAXBContext jc = JAXBContext.newInstance(Pagos.class);
//        Marshaller jm = jc.createMarshaller();
//        jm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jm.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd");
////        jm.marshal(comprobante.getComplemento().getPagos(), nodeComplemento.item(0));
//        //
//        DOMSource domSource = new DOMSource(doc);
//        StreamResult result = new StreamResult(sw);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer transformer = tf.newTransformer();
//        Properties oprops = new Properties();
////        oprops.put(OutputKeys.OMIT_XML_DECLARATION, "no");
//        oprops.put(OutputKeys.INDENT, "yes");
//        oprops.put(OutputKeys.METHOD, "xml");
//        oprops.put(OutputKeys.ENCODING, "UTF-8");
//        oprops.put("{http://xml.apache.org/xslt}indent-amount", "2");
//        transformer.setOutputProperties(oprops);
//        transformer.transform(domSource, result);
//        return sw.toString();
//    }
//
//    public static String createDocumentCfdiComercioExterior(Comprobante comprobante) throws ParserConfigurationException, JAXBException, TransformerConfigurationException, TransformerException {
//        // Converter ComprobanteXml to XML string
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setNamespaceAware(true);
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.newDocument();
//        StringWriter sw = new StringWriter();
//        // CFDI 4.0
//        JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");
//        jaxbMarshaller.marshal(comprobante, doc);
//        // Adding Node
//        NodeList nodeComplemento = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/4", "Complemento");
//        JAXBContext jc = JAXBContext.newInstance(ComercioExterior.class);
//        Marshaller jm = jc.createMarshaller();
//        jm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jm.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/ComercioExterior11 http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd");
//        jm.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/ComercioExterior11 http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd");
////        jm.marshal(comprobante.getComplemento().getComercioExterior(), nodeComplemento.item(0));
//        //
//        DOMSource domSource = new DOMSource(doc);
//        StreamResult result = new StreamResult(sw);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer transformer = tf.newTransformer();
//        Properties oprops = new Properties();
////        oprops.put(OutputKeys.OMIT_XML_DECLARATION, "no");
//        oprops.put(OutputKeys.INDENT, "yes");
//        oprops.put(OutputKeys.METHOD, "xml");
//        oprops.put(OutputKeys.ENCODING, "UTF-8");
//        oprops.put("{http://xml.apache.org/xslt}indent-amount", "2");
//        transformer.setOutputProperties(oprops);
//        transformer.transform(domSource, result);
//        return sw.toString();
//    }
//
//    public static String createDocumentCartaPorte(Comprobante comprobante) throws ParserConfigurationException, JAXBException, TransformerConfigurationException, TransformerException {
//        // Converter ComprobanteXml to XML string
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setNamespaceAware(true);
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.newDocument();
//        StringWriter sw = new StringWriter();
//        // CFDI 4.0
//        JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");
//        jaxbMarshaller.marshal(comprobante, doc);
//        // Adding Node
//        NodeList nodeComplemento = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/4", "Complemento");
//        JAXBContext jc = JAXBContext.newInstance(CartaPorte.class);
//        Marshaller jm = jc.createMarshaller();
//        jm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        jm.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/CartaPorte20 http://www.sat.gob.mx/sitio_internet/cfd/CartaPorte/CartaPorte20.xsd");
//        jm.marshal(comprobante.getComplemento().getCartaPortes().get(0), nodeComplemento.item(0));
//        //
//        DOMSource domSource = new DOMSource(doc);
//        StreamResult result = new StreamResult(sw);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer transformer = tf.newTransformer();
//        Properties oprops = new Properties();
////        oprops.put(OutputKeys.OMIT_XML_DECLARATION, "no");
//        oprops.put(OutputKeys.INDENT, "yes");
//        oprops.put(OutputKeys.METHOD, "xml");
//        oprops.put(OutputKeys.ENCODING, "UTF-8");
//        oprops.put("{http://xml.apache.org/xslt}indent-amount", "2");
//        transformer.setOutputProperties(oprops);
//        transformer.transform(domSource, result);
//        return sw.toString();
//    }
}
