/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import mx.avecias.nominave.model.dto.cfdi40.cat.TipoFactor;
import java.io.Serializable;
import java.math.BigDecimal;
import mx.avecias.nominave.model.dto.cfdi40.cat.Impuesto;
import mx.avecias.nominave.model.dto.cfdi40.cat.TasaOCuota;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Sep 7, 2023 6:35:49 PM
 *
 */
public class Traslado implements Serializable {

    private Integer idTraslado;
    private BigDecimal base;
    private BigDecimal importe;
    // catalogos
    private Impuesto impuesto;
    private TipoFactor tipoFactor;
    private TasaOCuota tasaOCuota;

    public Traslado() {
    }

    public Integer getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Integer idTraslado) {
        this.idTraslado = idTraslado;
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

    /**
     * TasaOCuota
     *
     * Descripción Atributo condicional para señalar el valor de la tasa o cuota
     * del impuesto que se traslada para el presente concepto. Es requerido
     * cuando el atributo TipoFactor tenga una clave que corresponda a Tasa o
     * Cuota.
     *
     * Uso opcional
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000000
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public TasaOCuota getTasaOCuota() {
        return tasaOCuota;
    }

    /**
     * TasaOCuota
     *
     * Descripción Atributo condicional para señalar el valor de la tasa o cuota
     * del impuesto que se traslada para el presente concepto. Es requerido
     * cuando el atributo TipoFactor tenga una clave que corresponda a Tasa o
     * Cuota.
     *
     * Uso opcional
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000000
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @param tasaOCuota
     */
    public void setTasaOCuota(TasaOCuota tasaOCuota) {
        this.tasaOCuota = tasaOCuota;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Impuesto
     *
     * Descripción Atributo requerido para señalar la clave del tipo de impuesto
     * trasladado aplicable al concepto.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Impuesto
     *
     * @param importe
     */
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    /**
     * Impuesto
     *
     * Descripción Atributo requerido para señalar la clave del tipo de impuesto
     * trasladado aplicable al concepto.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Impuesto
     *
     * @return
     */
    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
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
