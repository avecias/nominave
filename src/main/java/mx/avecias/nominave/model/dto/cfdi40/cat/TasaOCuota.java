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
 * @author avecias date: Sep 8, 2023 7:30:43 PM
 *
 */
public class TasaOCuota implements Serializable {

    private String claveTasaOCuota;
    private String rangoOFijo;
    private String valorMinimo;
    private String valorMaximo;
    private String impuesto;
    private String factor;
    private String traslado;
    private String retencion;
    private String fechaInicioDeVigencia;
    private String fechaFinDeVigencia;

    public TasaOCuota() {
    }

    public String getClaveTasaOCuota() {
        return claveTasaOCuota;
    }

    public void setClaveTasaOCuota(String claveTasaOCuota) {
        this.claveTasaOCuota = claveTasaOCuota;
    }

    public String getRangoOFijo() {
        return rangoOFijo;
    }

    public void setRangoOFijo(String rangoOFijo) {
        this.rangoOFijo = rangoOFijo;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getTraslado() {
        return traslado;
    }

    public void setTraslado(String traslado) {
        this.traslado = traslado;
    }

    public String getRetencion() {
        return retencion;
    }

    public void setRetencion(String retencion) {
        this.retencion = retencion;
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
