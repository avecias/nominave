/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:34:33 PM
 *
 */
public class Impuestos implements Serializable {

    private Integer idImpuestos;
    private Retenciones retenciones;
    private Traslados traslados;

    /**
     * Elemento: Impuestos
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo condicional para capturar los impuestos aplicables al presente
     * concepto.
     *
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) Traslados (0, 1)
     *
     * Retenciones (0, 1)
     */
    public Impuestos() {
    }

    /**
     *
     * @return
     */
    public Integer getIdImpuestos() {
        return idImpuestos;
    }

    /**
     *
     * @param idImpuestos
     */
    public void setIdImpuestos(Integer idImpuestos) {
        this.idImpuestos = idImpuestos;
    }

    /**
     * Elemento: Retenciones
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para asentar los impuestos retenidos aplicables al presente
     * concepto.
     *
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) Retencion (1, Ilimitado)
     *
     * @return
     */
    public Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Elemento: Retenciones
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para asentar los impuestos retenidos aplicables al presente
     * concepto.
     *
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) Retencion (1, Ilimitado)
     *
     * @param retenciones
     */
    public void setRetenciones(Retenciones retenciones) {
        this.retenciones = retenciones;
    }

    /**
     * Elemento: Traslados
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para asentar los impuestos trasladados aplicables al
     * presente concepto.
     *
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) Traslado (1, Ilimitado) Jueves 13 de enero de 2022
     * DIARIO OFICIAL
     *
     * @return
     */
    public Traslados getTraslados() {
        return traslados;
    }

    /**
     * Elemento: Traslados
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para asentar los impuestos trasladados aplicables al
     * presente concepto.
     *
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) Traslado (1, Ilimitado) Jueves 13 de enero de 2022
     * DIARIO OFICIAL
     *
     * @param traslados
     */
    public void setTraslados(Traslados traslados) {
        this.traslados = traslados;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
