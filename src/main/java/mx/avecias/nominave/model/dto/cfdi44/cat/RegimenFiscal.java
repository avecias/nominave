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
 * @author avecias date: Aug 22, 2023 1:38:25 PM
 *
 */
public class RegimenFiscal implements Serializable {

    private String claveRegimenfiscal;
    private String descripcion;
    private String fisica;
    private String moral;
    private String fechaDeInicioDeVigencia;
    private String fechaDeFinDeVigencia;

    public RegimenFiscal() {
    }

    public String getClaveRegimenfiscal() {
        return claveRegimenfiscal;
    }

    public void setClaveRegimenfiscal(String claveRegimenfiscal) {
        this.claveRegimenfiscal = claveRegimenfiscal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }

    public String getFechaDeInicioDeVigencia() {
        return fechaDeInicioDeVigencia;
    }

    public void setFechaDeInicioDeVigencia(String fechaDeInicioDeVigencia) {
        this.fechaDeInicioDeVigencia = fechaDeInicioDeVigencia;
    }

    public String getFechaDeFinDeVigencia() {
        return fechaDeFinDeVigencia;
    }

    public void setFechaDeFinDeVigencia(String fechaDeFinDeVigencia) {
        this.fechaDeFinDeVigencia = fechaDeFinDeVigencia;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
