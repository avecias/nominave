/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import mx.avecias.nominave.model.dto.cfdi40.cat.RegimenFiscal;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:27:24 PM
 *
 */
public class Emisor implements Serializable {

    /*
    @Rfc
    @Nombre
    @RegimenFiscal
    @FacAtrAdquirente
     */
    private Integer idEmisor;
    private String rfc;
    private String nombre;
    private String facAtrAdquirente;
    // catalogos
    private RegimenFiscal regimenFiscal;

    public Emisor() {
    }

    public Integer getIdEmisor() {
        return idEmisor;
    }

    /**
     * @param idEmisor
     */
    public void setIdEmisor(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    /**
     * Rfc
     *
     * Descripción Atributo requerido para registrar la Clave del Registro
     * Federal de Contribuyentes correspondiente al contribuyente emisor del
     * comprobante.
     *
     * Uso requerido DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Tipo Especial tdCFDI:t_RFC
     *
     * @return
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Rfc
     *
     * Descripción Atributo requerido para registrar la Clave del Registro
     * Federal de Contribuyentes correspondiente al contribuyente emisor del
     * comprobante.
     *
     * Uso requerido DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Tipo Especial tdCFDI:t_RFC
     *
     * @param rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Nombre
     *
     * Descripción Atributo requerido para registrar el nombre, denominación o
     * razón social del contribuyente inscrito en el RFC, del emisor del
     * comprobante.
     *
     * Uso requerido Tipo Base xs:string Longitud Mínima 1 Longitud Máxima 254
     * Espacio en Blanco Colapsar Patrón [^|]{1,254}
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nombre
     *
     * Descripción Atributo requerido para registrar el nombre, denominación o
     * razón social del contribuyente inscrito en el RFC, del emisor del
     * comprobante.
     *
     * Uso requerido Tipo Base xs:string Longitud Mínima 1 Longitud Máxima 254
     * Espacio en Blanco Colapsar Patrón [^|]{1,254}
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * FacAtrAdquirente Descripción Atributo condicional para expresar el número
     * de operación proporcionado por el SAT cuando se trate de un comprobante a
     * través de un PCECFDI o un PCGCFDISP. Uso opcional Tipo Base xs:string
     * Longitud 10 Espacio en Blanco Colapsar Patrón [0-9]{10}
     *
     * @return
     */
    public String getFacAtrAdquirente() {
        return facAtrAdquirente;
    }

    /**
     * FacAtrAdquirente Descripción Atributo condicional para expresar el número
     * de operación proporcionado por el SAT cuando se trate de un comprobante a
     * través de un PCECFDI o un PCGCFDISP. Uso opcional Tipo Base xs:string
     * Longitud 10 Espacio en Blanco Colapsar Patrón [0-9]{10}
     *
     * @param facAtrAdquirente
     */
    public void setFacAtrAdquirente(String facAtrAdquirente) {
        this.facAtrAdquirente = facAtrAdquirente;
    }

    /**
     * RegimenFiscal Descripción Atributo requerido para incorporar la clave del
     * régimen del contribuyente emisor al que aplicará el efecto fiscal de este
     * comprobante. Uso requerido Tipo Especial catCFDI:c_RegimenFiscal
     *
     * @return
     */
    public RegimenFiscal getRegimenFiscal() {
        return regimenFiscal;
    }

    /**
     * RegimenFiscal Descripción Atributo requerido para incorporar la clave del
     * régimen del contribuyente emisor al que aplicará el efecto fiscal de este
     * comprobante. Uso requerido Tipo Especial catCFDI:c_RegimenFiscal
     *
     * @param regimenFiscal
     */
    public void setRegimenFiscal(RegimenFiscal regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
