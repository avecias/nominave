/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:30:22 PM
 *
 */
public class Conceptos implements Serializable {

    private Integer idConceptos;
    private List<Concepto> conceptos;

    public Conceptos() {
    }

    public Integer getIdConceptos() {
        return idConceptos;
    }

    public void setIdConceptos(Integer idConceptos) {
        this.idConceptos = idConceptos;
    }

    /**
     * lemento: Concepto Diagrama Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para registrar la información detallada de un bien o
     * servicio amparado en el comprobante. DIARIO OFICIAL Jueves 13 de enero de
     * 2022
     *
     * @return
     */
    public List<Concepto> getConceptos() {
        return conceptos;
    }

    /**
     * lemento: Concepto Diagrama Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para registrar la información detallada de un bien o
     * servicio amparado en el comprobante. DIARIO OFICIAL Jueves 13 de enero de
     * 2022
     *
     * @param conceptos
     */
    public void setConceptos(List<Concepto> conceptos) {
        this.conceptos = conceptos;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
