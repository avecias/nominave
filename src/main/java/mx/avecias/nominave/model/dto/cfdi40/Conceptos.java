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

    private List<Concepto> conceptos;

    public Conceptos() {
    }

    /**
     *
     * @return
     */
    public List<Concepto> getConceptos() {
        return conceptos;
    }

    /**
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
