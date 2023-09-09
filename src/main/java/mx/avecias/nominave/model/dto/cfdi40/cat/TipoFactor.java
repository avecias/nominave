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
 * @author avecias date: Sep 7, 2023 6:38:06 PM
 *
 */
public class TipoFactor implements Serializable {

    private String claveTipofactor;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;

    public TipoFactor() {
    }

    public String getClaveTipofactor() {
        return claveTipofactor;
    }

    public void setClaveTipofactor(String claveTipofactor) {
        this.claveTipofactor = claveTipofactor;
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
