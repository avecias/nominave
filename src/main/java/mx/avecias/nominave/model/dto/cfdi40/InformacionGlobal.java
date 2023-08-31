/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import mx.avecias.nominave.model.dto.cfdi40.cat.Meses;
import mx.avecias.nominave.model.dto.cfdi40.cat.Periodicidad;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:24:43 PM
 *
 */
public class InformacionGlobal implements Serializable {

    /*
    @Periodicidad
    @Meses
    @Año
     */
    private Integer idInformacionGlobal;
    private int anio;
    private Meses meses;
    private Periodicidad periodicidad;
    private Comprobante comprobante;

    /**
     *
     */
    public InformacionGlobal() {
    }

    /**
     *
     * @return
     */
    public Integer getIdInformacionGlobal() {
        return idInformacionGlobal;
    }

    /**
     *
     * @param idInformacionGlobal
     */
    public void setIdInformacionGlobal(Integer idInformacionGlobal) {
        this.idInformacionGlobal = idInformacionGlobal;
    }

    /**
     * Año
     *
     * Descripción Atributo requerido para expresar el año al que corresponde la
     * información del comprobante global.
     *
     * Uso requerido
     *
     * Tipo Base xs:short
     *
     * Valor Mínimo Incluyente 2021
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Año
     *
     * Descripción Atributo requerido para expresar el año al que corresponde la
     * información del comprobante global.
     *
     * Uso requerido
     *
     * Tipo Base xs:short
     *
     * Valor Mínimo Incluyente 2021
     *
     * Espacio en Blanco Colapsar
     *
     * @param anio
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Meses
     *
     * Descripción Atributo requerido para expresar el mes o los meses al que
     * corresponde la información del comprobante global.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Meses
     *
     * @return
     */
    public Meses getMeses() {
        return meses;
    }

    /**
     * Meses
     *
     * Descripción Atributo requerido para expresar el mes o los meses al que
     * corresponde la información del comprobante global.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Meses
     *
     * @param meses
     */
    public void setMeses(Meses meses) {
        this.meses = meses;
    }

    /**
     * Periodicidad
     *
     * Descripción Atributo requerido para expresar el período al que
     * corresponde la información del comprobante global. Jueves 13 de enero de
     * 2022 DIARIO OFICIAL
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Periodicidad
     *
     * @return
     */
    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    /**
     * Periodicidad
     *
     * Descripción Atributo requerido para expresar el período al que
     * corresponde la información del comprobante global. Jueves 13 de enero de
     * 2022 DIARIO OFICIAL
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Periodicidad
     *
     * @param periodicidad
     */
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
