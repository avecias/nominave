/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.cfdi40.xml;

import mx.avecias.nominave.model.dto.cfdi44.Comprobante;

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
        System.out.println("Comprobante de nomina");
        Comprobante comprobante = generar();
        System.out.println(comprobante);
    }

}
