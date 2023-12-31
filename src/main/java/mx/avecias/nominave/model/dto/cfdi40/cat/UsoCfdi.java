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
 * @author avecias date: Aug 22, 2023 4:03:15 PM
 *
 */
public class UsoCfdi implements Serializable {

    private String claveUsocfdi;
    private String descripcion;
    private String aplicaParaTipoPersonaFisica;
    private String aplicaParaTipoPersonaMoral;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;
    private String regimenFiscalReceptor;

    public UsoCfdi() {
    }

    public String getClaveUsocfdi() {
        return claveUsocfdi;
    }

    public void setClaveUsocfdi(String claveUsocfdi) {
        this.claveUsocfdi = claveUsocfdi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAplicaParaTipoPersonaFisica() {
        return aplicaParaTipoPersonaFisica;
    }

    public void setAplicaParaTipoPersonaFisica(String aplicaParaTipoPersonaFisica) {
        this.aplicaParaTipoPersonaFisica = aplicaParaTipoPersonaFisica;
    }

    public String getAplicaParaTipoPersonaMoral() {
        return aplicaParaTipoPersonaMoral;
    }

    public void setAplicaParaTipoPersonaMoral(String aplicaParaTipoPersonaMoral) {
        this.aplicaParaTipoPersonaMoral = aplicaParaTipoPersonaMoral;
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

    public String getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }

    public void setRegimenFiscalReceptor(String regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
