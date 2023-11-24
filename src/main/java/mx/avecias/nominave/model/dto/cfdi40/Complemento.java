/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.util.List;
import mx.avecias.nominave.model.dto.cfdi40.nomina12.Nomina;

/**
 *
 * @author avecias date: Aug 16, 2023 6:35:06 PM
 *
 */
public class Complemento implements Serializable {

    private Comprobante comprobante;
    private Timbre timbre;
    private List<Nomina> nominas;

    public Complemento() {
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Timbre getTimbre() {
        return timbre;
    }

    public void setTimbre(Timbre timbre) {
        this.timbre = timbre;
    }

    public List<Nomina> getNominas() {
        return nominas;
    }

    public void setNominas(List<Nomina> nominas) {
        this.nominas = nominas;
    }

}
