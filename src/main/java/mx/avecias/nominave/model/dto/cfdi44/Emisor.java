/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi44;

import java.io.Serializable;
import mx.avecias.nominave.model.dto.cfdi44.cat.RegimenFiscal;
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

    public void setIdEmisor(Integer idEmisor) {
        this.idEmisor = idEmisor;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacAtrAdquirente() {
        return facAtrAdquirente;
    }

    public void setFacAtrAdquirente(String facAtrAdquirente) {
        this.facAtrAdquirente = facAtrAdquirente;
    }

    public RegimenFiscal getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(RegimenFiscal regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
