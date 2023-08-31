/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import mx.avecias.nominave.model.dto.cfdi40.cat.CodigoPostal;
import mx.avecias.nominave.model.dto.cfdi40.cat.Pais;
import mx.avecias.nominave.model.dto.cfdi40.cat.RegimenFiscal;
import mx.avecias.nominave.model.dto.cfdi40.cat.UsoCfdi;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 16, 2023 6:27:54 PM
 *
 */
public class Receptor implements Serializable {

    /*
    Requerido@Rfc
    Requerido@Nombre
    Requerido@DomicilioFiscalReceptor
    Opcional@ResidenciaFiscal
    Opcional@NumRegIdTrib
    Requerido@RegimenFiscalReceptor
    Requerido@UsoCFDI
     */
    private Integer idReceptor;
    private String rfc;
    private String nombre;
    private String numRegIdTrib;
    // catalogos
    private CodigoPostal domicilioFiscalReceptor;
    private Pais residenciaFiscal;
    private RegimenFiscal regimenFiscalReceptor;
    private UsoCfdi usoCfdi;

    public Receptor() {
    }

    public Integer getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(Integer idReceptor) {
        this.idReceptor = idReceptor;
    }

    /**
     * Rfc Descripción Atributo requerido para registrar la Clave del Registro
     * Federal de Contribuyentes correspondiente al contribuyente receptor del
     * comprobante. Uso requerido Tipo Especial tdCFDI:t_RFC
     *
     * @return
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Rfc Descripción Atributo requerido para registrar la Clave del Registro
     * Federal de Contribuyentes correspondiente al contribuyente receptor del
     * comprobante. Uso requerido Tipo Especial tdCFDI:t_RFC
     *
     * @param rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Nombre Descripción Atributo requerido para registrar el nombre(s), primer
     * apellido, segundo apellido, según corresponda, denominación o razón
     * social del contribuyente, inscrito en el RFC, del receptor del
     * comprobante. Uso requerido Tipo Base xs:string Longitud Mínima 1 Longitud
     * Máxima 254 Espacio en Blanco Colapsar Patrón [^|]{1,254} Jueves 13 de
     * enero de 2022 DIARIO OFICIAL
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nombre Descripción Atributo requerido para registrar el nombre(s), primer
     * apellido, segundo apellido, según corresponda, denominación o razón
     * social del contribuyente, inscrito en el RFC, del receptor del
     * comprobante. Uso requerido Tipo Base xs:string Longitud Mínima 1 Longitud
     * Máxima 254 Espacio en Blanco Colapsar Patrón [^|]{1,254} Jueves 13 de
     * enero de 2022 DIARIO OFICIAL
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * NumRegIdTrib
     *
     * Descripción Atributo condicional para expresar el número de registro de
     * identidad fiscal del receptor cuando sea residente en el extranjero. Es
     * requerido cuando se incluya el complemento de comercio exterior.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 40
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    /**
     * NumRegIdTrib
     *
     * Descripción Atributo condicional para expresar el número de registro de
     * identidad fiscal del receptor cuando sea residente en el extranjero. Es
     * requerido cuando se incluya el complemento de comercio exterior.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 40
     *
     * Espacio en Blanco Colapsar
     *
     * @param numRegIdTrib
     */
    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    /**
     * DomicilioFiscalReceptor
     *
     * Descripción Atributo requerido para registrar el código postal del
     * domicilio fiscal del receptor del comprobante.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 5
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [0-9]{5}
     *
     * @return
     */
    public CodigoPostal getDomicilioFiscalReceptor() {
        return domicilioFiscalReceptor;
    }

    /**
     * DomicilioFiscalReceptor
     *
     * Descripción Atributo requerido para registrar el código postal del
     * domicilio fiscal del receptor del comprobante.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 5
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [0-9]{5}
     *
     * @param domicilioFiscalReceptor
     */
    public void setDomicilioFiscalReceptor(CodigoPostal domicilioFiscalReceptor) {
        this.domicilioFiscalReceptor = domicilioFiscalReceptor;
    }

    /**
     * ResidenciaFiscal
     *
     * Descripción Atributo condicional para registrar la clave del país de
     * residencia para efectos fiscales del receptor del comprobante, cuando se
     * trate de un extranjero, y que es conforme con la especificación ISO
     * 3166-1 alpha-3. Es requerido cuando se incluya el complemento de comercio
     * exterior o se registre el atributo NumRegIdTrib.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_Pais
     *
     * @return
     */
    public Pais getResidenciaFiscal() {
        return residenciaFiscal;
    }

    /**
     * ResidenciaFiscal
     *
     * Descripción Atributo condicional para registrar la clave del país de
     * residencia para efectos fiscales del receptor del comprobante, cuando se
     * trate de un extranjero, y que es conforme con la especificación ISO
     * 3166-1 alpha-3. Es requerido cuando se incluya el complemento de comercio
     * exterior o se registre el atributo NumRegIdTrib.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_Pais
     *
     * @param residenciaFiscal
     */
    public void setResidenciaFiscal(Pais residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }

    /**
     * RegimenFiscalReceptor
     *
     * Descripción Atributo requerido para incorporar la clave del régimen
     * fiscal del contribuyente receptor al que aplicará el efecto fiscal de
     * este comprobante.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_RegimenFiscal
     *
     * @return
     */
    public RegimenFiscal getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }

    /**
     * RegimenFiscalReceptor
     *
     * Descripción Atributo requerido para incorporar la clave del régimen
     * fiscal del contribuyente receptor al que aplicará el efecto fiscal de
     * este comprobante.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_RegimenFiscal
     *
     * @param regimenFiscalReceptor
     */
    public void setRegimenFiscalReceptor(RegimenFiscal regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }

    /**
     * UsoCFDI
     *
     * Descripción Atributo requerido para expresar la clave del uso que dará a
     * esta factura el receptor del CFDI.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_UsoCFDI DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * @return
     */
    public UsoCfdi getUsoCfdi() {
        return usoCfdi;
    }

    /**
     * UsoCFDI
     *
     * Descripción Atributo requerido para expresar la clave del uso que dará a
     * esta factura el receptor del CFDI.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_UsoCFDI DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * @param usoCfdi
     */
    public void setUsoCfdi(UsoCfdi usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
