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
 * @author avecias date: Sep 6, 2023 5:44:33 PM
 *
 */
public class ClaveProdServ implements Serializable {

    private String claveprodserv;
    private String descripcion;
    private String incluirIvaTrasladado;
    private String incluirIepsTrasladado;
    private String complementoQueDebeIncluir;
    private String fechainiciovigencia;
    private String fechafinvigencia;
    private String estimuloFranjaFronteriza;
    private String palabrasSimilares;

    public ClaveProdServ() {
    }

    public String getClaveprodserv() {
        return claveprodserv;
    }

    public void setClaveprodserv(String claveClaveprodserv) {
        this.claveprodserv = claveClaveprodserv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIncluirIvaTrasladado() {
        return incluirIvaTrasladado;
    }

    public void setIncluirIvaTrasladado(String incluirIvaTrasladado) {
        this.incluirIvaTrasladado = incluirIvaTrasladado;
    }

    public String getIncluirIepsTrasladado() {
        return incluirIepsTrasladado;
    }

    public void setIncluirIepsTrasladado(String incluirIepsTrasladado) {
        this.incluirIepsTrasladado = incluirIepsTrasladado;
    }

    public String getComplementoQueDebeIncluir() {
        return complementoQueDebeIncluir;
    }

    public void setComplementoQueDebeIncluir(String complementoQueDebeIncluir) {
        this.complementoQueDebeIncluir = complementoQueDebeIncluir;
    }

    public String getFechainiciovigencia() {
        return fechainiciovigencia;
    }

    public void setFechainiciovigencia(String fechainiciovigencia) {
        this.fechainiciovigencia = fechainiciovigencia;
    }

    public String getFechafinvigencia() {
        return fechafinvigencia;
    }

    public void setFechafinvigencia(String fechafinvigencia) {
        this.fechafinvigencia = fechafinvigencia;
    }

    public String getEstimuloFranjaFronteriza() {
        return estimuloFranjaFronteriza;
    }

    public void setEstimuloFranjaFronteriza(String estimuloFranjaFronteriza) {
        this.estimuloFranjaFronteriza = estimuloFranjaFronteriza;
    }

    public String getPalabrasSimilares() {
        return palabrasSimilares;
    }

    public void setPalabrasSimilares(String palabrasSimilares) {
        this.palabrasSimilares = palabrasSimilares;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
