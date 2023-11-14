/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.util.Converter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import test.cfdi40.xml.load.CargarXmlComplementoNomina;

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
            Converter converter = new Converter();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parse del archivo
            Document document = builder.parse(new File("/Users/avecias/Downloads/xmls/1874-4577-QNC-2023-15-7660.xml"));
            // normalizar en objecto document
            document.getDocumentElement().normalize();
            // convertidor
            Comprobante comprobante = converter.xml2CfdiNomina(document);
            System.out.println(comprobante);
        } catch (FileNotFoundException ex) {
            System.out.println("Error, " + ex);
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            System.out.println("Error, " + ex);
        } catch (ParseException ex) {
            Logger.getLogger(CargarXmlComplementoNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
