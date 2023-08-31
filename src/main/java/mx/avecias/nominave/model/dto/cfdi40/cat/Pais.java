/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.cat;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 22, 2023 4:02:13 PM
 *
 */
public class Pais implements Serializable {

    private String clavePais;
    private String descripcion;
    private String formatoDeCodigoPostal;
    private String formatoDeRegistroDeIdentidadTributaria;
    private String validacionDelRegistroDeIdentidadTributaria;
    private String agrupaciones;

    public Pais() {
    }

    public String getClavePais() {
        return clavePais;
    }

    public void setClavePais(String clavePais) {
        this.clavePais = clavePais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormatoDeCodigoPostal() {
        return formatoDeCodigoPostal;
    }

    public void setFormatoDeCodigoPostal(String formatoDeCodigoPostal) {
        this.formatoDeCodigoPostal = formatoDeCodigoPostal;
    }

    public String getFormatoDeRegistroDeIdentidadTributaria() {
        return formatoDeRegistroDeIdentidadTributaria;
    }

    public void setFormatoDeRegistroDeIdentidadTributaria(String formatoDeRegistroDeIdentidadTributaria) {
        this.formatoDeRegistroDeIdentidadTributaria = formatoDeRegistroDeIdentidadTributaria;
    }

    public String getValidacionDelRegistroDeIdentidadTributaria() {
        return validacionDelRegistroDeIdentidadTributaria;
    }

    public void setValidacionDelRegistroDeIdentidadTributaria(String validacionDelRegistroDeIdentidadTributaria) {
        this.validacionDelRegistroDeIdentidadTributaria = validacionDelRegistroDeIdentidadTributaria;
    }

    public String getAgrupaciones() {
        return agrupaciones;
    }

    public void setAgrupaciones(String agrupaciones) {
        this.agrupaciones = agrupaciones;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
