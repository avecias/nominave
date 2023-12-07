/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 22, 2023 12:40:05 PM
 *
 */
public class CfdiRelacionado implements Serializable {

    /*@UUID*/
    private String uuid;

    public CfdiRelacionado() {
    }

    public CfdiRelacionado(String uuid) {
        this.uuid = uuid;
    }

    /**
     * UUID
     *
     * Descripción Atributo requerido para registrar el folio fiscal (UUID) de
     * un CFDI relacionado con el presente comprobante, por ejemplo: Si el CFDI
     * relacionado es un comprobante de traslado que sirve para registrar el
     * movimiento de la mercancía. Si este comprobante se usa como nota de
     * crédito o nota de débito del comprobante relacionado. Si este comprobante
     * es una devolución sobre el comprobante relacionado. Si éste sustituye a
     * una factura cancelada.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 36 Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón
     * [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}
     *
     * @return
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * UUID
     *
     * Descripción Atributo requerido para registrar el folio fiscal (UUID) de
     * un CFDI relacionado con el presente comprobante, por ejemplo: Si el CFDI
     * relacionado es un comprobante de traslado que sirve para registrar el
     * movimiento de la mercancía. Si este comprobante se usa como nota de
     * crédito o nota de débito del comprobante relacionado. Si este comprobante
     * es una devolución sobre el comprobante relacionado. Si éste sustituye a
     * una factura cancelada.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 36 Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón
     * [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
