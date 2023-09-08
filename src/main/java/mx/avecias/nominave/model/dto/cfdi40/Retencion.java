/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias
 * date: Sep 7, 2023 3:10:53 PM
 *
 */
public class Retencion implements Serializable{

    private Integer idRetencionConcepto;
    private BigDecimal base;
    private BigDecimal tasaOCuota;
    private BigDecimal importe;
    private TipoFactor tipoFactor;
    
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
