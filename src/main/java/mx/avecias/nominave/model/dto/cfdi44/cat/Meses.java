/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi44.cat;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 7:21:56 PM
 *
 */
public class Meses implements Serializable {

    private String claveMeses;
    private String descripcion;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;

    public Meses() {
    }

    public String getClaveMeses() {
        return claveMeses;
    }

    public void setClaveMeses(String claveMeses) {
        this.claveMeses = claveMeses;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
