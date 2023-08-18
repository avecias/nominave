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
 * @author avecias date: Aug 16, 2023 5:46:27 PM
 *
 */
public class CodigoPostal implements Serializable {

    private String claveCodigopostal;
    private String claveEstado;
    private String claveMunicipio;
    private String claveLocalidad;
    private String estimuloFranjaFronteriza;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;
    private String referenciasDelHusoHorario;
    private String descripcionDelHusoHorario;
    private String mes_inicio_horario_verano;
    private String dia_inicio_horario_verano;
    private String diferencia_horaria_verano;
    private String mes_inicio_horario_invierno;
    private String dia_inicio_horario_invierno;
    private String diferencia_horaria_invierno;

    public CodigoPostal() {
    }

    public String getClaveCodigopostal() {
        return claveCodigopostal;
    }

    public void setClaveCodigopostal(String claveCodigopostal) {
        this.claveCodigopostal = claveCodigopostal;
    }

    public String getClaveEstado() {
        return claveEstado;
    }

    public void setClaveEstado(String claveEstado) {
        this.claveEstado = claveEstado;
    }

    public String getClaveMunicipio() {
        return claveMunicipio;
    }

    public void setClaveMunicipio(String claveMunicipio) {
        this.claveMunicipio = claveMunicipio;
    }

    public String getClaveLocalidad() {
        return claveLocalidad;
    }

    public void setClaveLocalidad(String claveLocalidad) {
        this.claveLocalidad = claveLocalidad;
    }

    public String getEstimuloFranjaFronteriza() {
        return estimuloFranjaFronteriza;
    }

    public void setEstimuloFranjaFronteriza(String estimuloFranjaFronteriza) {
        this.estimuloFranjaFronteriza = estimuloFranjaFronteriza;
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

    public String getReferenciasDelHusoHorario() {
        return referenciasDelHusoHorario;
    }

    public void setReferenciasDelHusoHorario(String referenciasDelHusoHorario) {
        this.referenciasDelHusoHorario = referenciasDelHusoHorario;
    }

    public String getDescripcionDelHusoHorario() {
        return descripcionDelHusoHorario;
    }

    public void setDescripcionDelHusoHorario(String descripcionDelHusoHorario) {
        this.descripcionDelHusoHorario = descripcionDelHusoHorario;
    }

    public String getMes_inicio_horario_verano() {
        return mes_inicio_horario_verano;
    }

    public void setMes_inicio_horario_verano(String mes_inicio_horario_verano) {
        this.mes_inicio_horario_verano = mes_inicio_horario_verano;
    }

    public String getDia_inicio_horario_verano() {
        return dia_inicio_horario_verano;
    }

    public void setDia_inicio_horario_verano(String dia_inicio_horario_verano) {
        this.dia_inicio_horario_verano = dia_inicio_horario_verano;
    }

    public String getDiferencia_horaria_verano() {
        return diferencia_horaria_verano;
    }

    public void setDiferencia_horaria_verano(String diferencia_horaria_verano) {
        this.diferencia_horaria_verano = diferencia_horaria_verano;
    }

    public String getMes_inicio_horario_invierno() {
        return mes_inicio_horario_invierno;
    }

    public void setMes_inicio_horario_invierno(String mes_inicio_horario_invierno) {
        this.mes_inicio_horario_invierno = mes_inicio_horario_invierno;
    }

    public String getDia_inicio_horario_invierno() {
        return dia_inicio_horario_invierno;
    }

    public void setDia_inicio_horario_invierno(String dia_inicio_horario_invierno) {
        this.dia_inicio_horario_invierno = dia_inicio_horario_invierno;
    }

    public String getDiferencia_horaria_invierno() {
        return diferencia_horaria_invierno;
    }

    public void setDiferencia_horaria_invierno(String diferencia_horaria_invierno) {
        this.diferencia_horaria_invierno = diferencia_horaria_invierno;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
