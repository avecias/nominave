/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml;

import jakarta.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.util.Converter2Comprobante;
import mx.avecias.nominave.model.util.Converter2Xml;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author avecias date: Aug 16, 2023 6:45:21 PM
 *
 */
public class CfdiNomina {

    public static Comprobante generar() {
        Comprobante comprobante = new Comprobante();
        comprobante.setVersion("4.0");
        return comprobante;
    }

    public static void main(String[] args) {
        try {
            // creamos el objecto convertidor 
            Converter2Comprobante converter2Comprobante = new Converter2Comprobante();
            Converter2Xml converter2Xml = new Converter2Xml();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parse del archivo
            Document document = builder.parse(new File("/Users/avecias/Downloads/xmls/1874-4577-QNC-2023-15-7660.xml"));
            // normalizar en objecto document
            document.getDocumentElement().normalize();
            // convertidor
            Comprobante comprobante = converter2Comprobante.cfdiNomina(document);
            System.out.println("comprobante serie: " + comprobante.getSerie() + ", folio: " + comprobante.getFolio());
            String xml = converter2Xml.cfdiNomina(comprobante);
            System.out.println(xml);
        } catch (FileNotFoundException ex) {
            System.out.println("Error, " + ex);
        } catch (IOException ex) {
            System.out.println("Error en IO, " + ex);
        } catch (ParseException ex) {
            System.err.println("Error en el parse " + ex);
        } catch (JAXBException ex) {
            System.err.println("Error en jaxb " + ex);
        } catch (TransformerException ex) {
            System.err.println("Error en el transforme " + ex);
        } catch (ParserConfigurationException ex) {
            System.err.println("Error en la configuracion parse " + ex);
        } catch (SAXException ex) {
            System.err.println("Error en sax " + ex);
        }
    }

}
