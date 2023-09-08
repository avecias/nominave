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
 * @author avecias date: Sep 7, 2023 3:07:37 PM
 *
 */
public class Retenciones implements Serializable {

    private Integer idReteciones;
    private Retencion retencion;

    public Retenciones() {
    }

    public Integer getIdReteciones() {
        return idReteciones;
    }

    public void setIdReteciones(Integer idReteciones) {
        this.idReteciones = idReteciones;
    }

    /**
     * Elemento: Retencion
     *
     * Diagrama DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Descripción
     *
     * Nodo requerido para asentar la información detallada de una retención de
     * impuestos aplicable al presente concepto.
     *
     * @return
     */
    public Retencion getRetencion() {
        return retencion;
    }

    /**
     * Elemento: Retencion
     *
     * Diagrama DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Descripción
     *
     * Nodo requerido para asentar la información detallada de una retención de
     * impuestos aplicable al presente concepto.
     *
     * @param retencion
     */
    public void setRetencion(Retencion retencion) {
        this.retencion = retencion;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
