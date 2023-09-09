/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import mx.avecias.nominave.model.dto.cfdi40.cat.TipoFactor;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Sep 7, 2023 3:10:53 PM
 *
 */
public class Retencion implements Serializable {

    private Integer idRetencion;
    private BigDecimal base;
    private BigDecimal tasaOCuota;
    private BigDecimal importe;
    private TipoFactor tipoFactor;

    public Retencion() {
    }

    public Integer getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(Integer idRetencion) {
        this.idRetencion = idRetencion;
    }

    /**
     * Base
     *
     * Descripción Atributo requerido para señalar la base para el cálculo del
     * impuesto, la determinación de la base se realiza de acuerdo con las
     * disposiciones fiscales vigentes. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public BigDecimal getBase() {
        return base;
    }

    /**
     * Base
     *
     * Descripción Atributo requerido para señalar la base para el cálculo del
     * impuesto, la determinación de la base se realiza de acuerdo con las
     * disposiciones fiscales vigentes. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @param base
     */
    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getTasaOCuota() {
        return tasaOCuota;
    }

    public void setTasaOCuota(BigDecimal tasaOCuota) {
        this.tasaOCuota = tasaOCuota;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public TipoFactor getTipoFactor() {
        return tipoFactor;
    }

    public void setTipoFactor(TipoFactor tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
