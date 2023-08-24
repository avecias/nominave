/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package test.cfdi40;

import mx.avecias.nominave.model.dto.cfdi40.Comprobante;

/**
 *
 * @author avecias
 * date: Aug 1, 2023 7:15:17 PM
 */
public class TestXml {
    
    public static void main(String[] args) {
        System.out.println("cfdi version 4.0");
        Comprobante comprobante = new Comprobante();
        comprobante.setVersion("4.0");
        System.out.println(comprobante);
    }

}
