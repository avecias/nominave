/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml.load;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.avecias.nominave.model.dto.cfdi40.Comprobante;
import mx.avecias.nominave.model.util.Converter2Comprobante;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author avecias date: Aug 17, 2023 11:45:42 AM
 *
 */
public class CargarXmlComplementoNomina {

    public static void getDatosAddenda(Element comprobanteElement) {
        comprobanteElement.getAttribute("Serie");
    }

    public static void main(String[] args) {
        try {
            // Directorio raiz de los XMLs
            File root = new File("/Users/avecias/Downloads/xmls/");
            String[] extensions = {"xml"}; // archivos con extencion xml
            // Coleccion de archivos de xml
            Collection<File> files = FileUtils.listFiles(root, extensions, true);
            // creamos el objecto convertidor 
            Converter2Comprobante converter = new Converter2Comprobante();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            for (File file : files) {
                System.out.println("archivo: " + file.getName());
                // parse del archivo
                Document document = builder.parse(file);
                // normalizar en objecto document
                document.getDocumentElement().normalize();
                // convertidor
                Comprobante comprobante = converter.cfdiNomina(document);
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
