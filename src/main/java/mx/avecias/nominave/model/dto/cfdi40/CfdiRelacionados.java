/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.util.List;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoRelacion;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:26:42 PM
 *
 */
public class CfdiRelacionados implements Serializable {

    /*
    @TipoRelacion
    cfdi:CfdiRelacionado
     */
    private TipoRelacion tipoRelacion;
    private List<CfdiRelacionado> cfdiRelacionado;

    public CfdiRelacionados() {
    }

    /**
     * TipoRelacion
     *
     * Descripción Atributo requerido para indicar la clave de la relación que
     * existe entre éste que se está generando y el o los CFDI previos.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_TipoRelacion DIARIO OFICIAL Jueves 13 de enero de
     * 2022
     *
     * @return
     */
    public TipoRelacion getTipoRelacion() {
        return tipoRelacion;
    }

    /**
     * TipoRelacion
     *
     * Descripción Atributo requerido para indicar la clave de la relación que
     * existe entre éste que se está generando y el o los CFDI previos.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_TipoRelacion DIARIO OFICIAL Jueves 13 de enero de
     * 2022
     *
     * @param tipoRelacion
     */
    public void setTipoRelacion(TipoRelacion tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    /**
     *
     * Elemento: CfdiRelacionado
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para precisar la información de los comprobantes
     * relacionados.
     *
     * @return
     */
    public List<CfdiRelacionado> getCfdiRelacionado() {
        return cfdiRelacionado;
    }

    /**
     *
     * Elemento: CfdiRelacionado
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para precisar la información de los comprobantes
     * relacionados.
     *
     * @param cfdiRelacionado
     */
    public void setCfdiRelacionado(List<CfdiRelacionado> cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
