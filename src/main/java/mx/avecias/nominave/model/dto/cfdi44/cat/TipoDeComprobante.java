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
 * @author avecias date: Aug 16, 2023 4:04:02 PM
 *
 */
public class TipoDeComprobante implements Serializable {

    private String claveTipoDeComprobante;
    private String descripcion;
    private String valorMaximo;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;

    public TipoDeComprobante() {
    }

    public String getClaveTipoDeComprobante() {
        return claveTipoDeComprobante;
    }

    public void setClaveTipoDeComprobante(String claveTipoDeComprobante) {
        this.claveTipoDeComprobante = claveTipoDeComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
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
