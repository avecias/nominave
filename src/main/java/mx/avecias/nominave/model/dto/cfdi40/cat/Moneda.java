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
 * @author avecias date: Aug 16, 2023 3:55:19 PM
 *
 */
public class Moneda implements Serializable {

    private String claveMoneda;
    private String descripcion;
    private String decimales;
    private String porcentajeVariacion;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;

    public Moneda() {
    }

    public String getClaveMoneda() {
        return claveMoneda;
    }

    public void setClaveMoneda(String claveMoneda) {
        this.claveMoneda = claveMoneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDecimales() {
        return decimales;
    }

    public void setDecimales(String decimales) {
        this.decimales = decimales;
    }

    public String getPorcentajeVariacion() {
        return porcentajeVariacion;
    }

    public void setPorcentajeVariacion(String porcentajeVariacion) {
        this.porcentajeVariacion = porcentajeVariacion;
    }

    public String getFechaInicioDeVigencia() {
        return fechaInicioDeVigencia;
    }

    public void setFechaInicioDeVigencia(String fechaInicioDeVigencia) {
        this.fechaInicioDeVigencia = fechaInicioDeVigencia;
    }

    public String getFechaFinDeVigencia() {
        return fechaFinDeVigencia;
    }

    public void setFechaFinDeVigencia(String fechaFinDeVigencia) {
        this.fechaFinDeVigencia = fechaFinDeVigencia;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
