/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi44;

import java.io.Serializable;
import java.util.List;
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
    private String tipoRelacion;
    private List<CfdiRelacionado> cfdiRelacionado;

    public CfdiRelacionados() {
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public List<CfdiRelacionado> getCfdiRelacionado() {
        return cfdiRelacionado;
    }

    public void setCfdiRelacionado(List<CfdiRelacionado> cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
