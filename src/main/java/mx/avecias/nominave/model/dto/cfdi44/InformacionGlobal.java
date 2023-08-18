/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi44;

import java.io.Serializable;
import mx.avecias.nominave.model.dto.cfdi44.cat.Meses;
import mx.avecias.nominave.model.dto.cfdi44.cat.Periodicidad;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:24:43 PM
 *
 */
public class InformacionGlobal implements Serializable {

    private Integer idInformacionGlobal;
    private int anio;
    private Meses meses;
    private Periodicidad periodicidad;
    private Comprobante comprobante;

    public InformacionGlobal() {
    }

    public Integer getIdInformacionGlobal() {
        return idInformacionGlobal;
    }

    public void setIdInformacionGlobal(Integer idInformacionGlobal) {
        this.idInformacionGlobal = idInformacionGlobal;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Meses getMeses() {
        return meses;
    }

    public void setMeses(Meses meses) {
        this.meses = meses;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
