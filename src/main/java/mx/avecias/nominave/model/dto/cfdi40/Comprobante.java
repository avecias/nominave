/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import mx.avecias.nominave.model.dto.User;
import mx.avecias.nominave.model.dto.cfdi40.cat.CodigoPostal;
import mx.avecias.nominave.model.dto.cfdi40.cat.Exportacion;
import mx.avecias.nominave.model.dto.cfdi40.cat.MetodoPago;
import mx.avecias.nominave.model.dto.cfdi40.cat.Moneda;
import mx.avecias.nominave.model.dto.cfdi40.cat.TipoDeComprobante;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias
 */
public class Comprobante implements Serializable {

    /*
    @Version
    @Serie
    @Folio
    @Fecha
    @FormaPago
    @NoCertificado
    @CondicionesDePago
    @SubTotal
    @Descuento
    @Moneda
    @TipoCambio
    @Total
    @TipoDeComprobante
    @Exportacion
    @MetodoPago
    @LugarExpedicion
    @Confirmacion*/
    private String version;
    private String serie;
    private String folio;
    private Date fecha;
    @JsonIgnore
    private String sello;
    @JsonIgnore
    private String noCertificado;
    @JsonIgnore
    private String certificado;
    private String condicionesDepago;
    private BigDecimal subTotal;
    private BigDecimal descuento;
    private BigDecimal tipoCambio;
    private BigDecimal total;
    private String confirmacion;
    // Catalogos
    private FormaPago formaPago;
    private Moneda moneda;
    private TipoDeComprobante tipoDeComprobante;
    private Exportacion exportacion;
    private MetodoPago metodoPago;
    private CodigoPostal lugarDeExpedicion;
    // Elementos
    private InformacionGlobal informacionGlobal;
    private List<CfdiRelacionados> cfdiRelacionados;
    private Emisor emisor;
    private Receptor receptor;
    private Conceptos conceptos;
    private Impuestos impuestos;
    private Complemento complemento;
    private Addenda addenda;
    // Adicional
    private User user;
    // Relaciones de 0 a muchos

    public Comprobante() {
    }

    /**
     * Version
     *
     * Descripción Atributo requerido con valor prefijado a 4.0 que indica la
     * versión del estándar bajo el que se encuentra expresado el comprobante.
     *
     * Uso requerido
     *
     * Valor Prefijado 4.0
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * Version
     *
     * Descripción Atributo requerido con valor prefijado a 4.0 que indica la
     * versión del estándar bajo el que se encuentra expresado el comprobante.
     *
     * Uso requerido
     *
     * Valor Prefijado 4.0
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * opcional
     *
     * @return
     */
    public String getSerie() {
        return serie;
    }

    /**
     * opcional
     *
     * @param serie
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * opcional
     *
     * @return
     */
    public String getFolio() {
        return folio;
    }

    /**
     * opcional
     *
     * @param folio
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * requerido
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * requerido
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getSello() {
        return sello;
    }

    /**
     *
     * @param sello
     */
    public void setSello(String sello) {
        this.sello = sello;
    }

    /**
     *
     * @return
     */
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     *
     * @param noCertificado
     */
    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    /**
     *
     * @return
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     *
     * @param certificado
     */
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    /**
     * condicional
     *
     * @return
     */
    public String getCondicionesDepago() {
        return condicionesDepago;
    }

    /**
     *
     * @param condicionesDepago
     */
    public void setCondicionesDepago(String condicionesDepago) {
        this.condicionesDepago = condicionesDepago;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    /**
     * condicional
     *
     * @return
     */
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    /**
     * condicional
     *
     * @param tipoCambio
     */
    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    /**
     * requerido
     *
     * @return
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * requerido
     *
     * @param total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * Confirmacion
     *
     * Descripción Atributo condicional para registrar la clave de confirmación
     * que entregue el PAC para expedir el comprobante con importes grandes, con
     * un tipo de cambio fuera del rango establecido o con ambos casos. Es
     * requerido cuando se registra un tipo de cambio o un total fuera del rango
     * establecido.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud 5
     *
     * Espacio en Blanco Colapsar DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Patrón [0-9a-zA-Z]{5}
     *
     * @return confirmacion
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * Confirmacion
     *
     * Descripción Atributo condicional para registrar la clave de confirmación
     * que entregue el PAC para expedir el comprobante con importes grandes, con
     * un tipo de cambio fuera del rango establecido o con ambos casos. Es
     * requerido cuando se registra un tipo de cambio o un total fuera del rango
     * establecido.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud 5
     *
     * Espacio en Blanco Colapsar DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * Patrón [0-9a-zA-Z]{5}
     *
     * @param confirmacion
     */
    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    /**
     * requerido
     *
     * @return
     */
    public FormaPago getFormaPago() {
        return formaPago;
    }

    /**
     * requerido
     *
     * @param formaPago
     */
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * requerido
     *
     * @return
     */
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * requerido
     *
     * @param moneda
     */
    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * TipoDeComprobante
     *
     * Descripción Atributo requerido para expresar la clave del efecto del
     * comprobante fiscal para el contribuyente emisor.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_TipoDeComprobante
     *
     * @return
     */
    public TipoDeComprobante getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    /**
     * TipoDeComprobante
     *
     * Descripción Atributo requerido para expresar la clave del efecto del
     * comprobante fiscal para el contribuyente emisor.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_TipoDeComprobante
     *
     * @param tipoDeComprobante
     */
    public void setTipoDeComprobante(TipoDeComprobante tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    /**
     * Exportacion
     *
     * Descripción Atributo requerido para expresar si el comprobante ampara una
     * operación de exportación.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Exportacion
     *
     * @return
     */
    public Exportacion getExportacion() {
        return exportacion;
    }

    /**
     * Exportacion
     *
     * Descripción Atributo requerido para expresar si el comprobante ampara una
     * operación de exportación.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Exportacion
     *
     * @param exportacion
     */
    public void setExportacion(Exportacion exportacion) {
        this.exportacion = exportacion;
    }

    /**
     * MetodoPago
     *
     * Descripción Atributo condicional para precisar la clave del método de
     * pago que aplica para este comprobante fiscal digital por Internet,
     * conforme al Artículo 29- A fracción VII incisos a y b del CFF.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_MetodoPago
     *
     * @return
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * MetodoPago
     *
     * Descripción Atributo condicional para precisar la clave del método de
     * pago que aplica para este comprobante fiscal digital por Internet,
     * conforme al Artículo 29- A fracción VII incisos a y b del CFF.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_MetodoPago
     *
     * @param metodoPago
     */
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * LugarExpedicion
     *
     * Descripción Atributo requerido para incorporar el código postal del lugar
     * de expedición del comprobante (domicilio de la matriz o de la sucursal).
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_CodigoPostal
     *
     * @return lugarDeExpedicion
     */
    public CodigoPostal getLugarDeExpedicion() {
        return lugarDeExpedicion;
    }

    /**
     * LugarExpedicion
     *
     * Descripción Atributo requerido para incorporar el código postal del lugar
     * de expedición del comprobante (domicilio de la matriz o de la sucursal).
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_CodigoPostal
     *
     * @param lugarDeExpedicion
     */
    public void setLugarDeExpedicion(CodigoPostal lugarDeExpedicion) {
        this.lugarDeExpedicion = lugarDeExpedicion;
    }

    /**
     * Elemento: InformacionGlobal
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo condicional para precisar la información relacionada con el
     * comprobante global.
     *
     * @return
     */
    public InformacionGlobal getInformacionGlobal() {
        return informacionGlobal;
    }

    /**
     * Elemento: InformacionGlobal
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo condicional para precisar la información relacionada con el
     * comprobante global.
     *
     * @param informacionGlobal
     */
    public void setInformacionGlobal(InformacionGlobal informacionGlobal) {
        this.informacionGlobal = informacionGlobal;
    }

    /**
     * Elemento: CfdiRelacionados
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para precisar la información de los comprobantes
     * relacionados.
     *
     * @return cfdiRelacionados
     */
    public List<CfdiRelacionados> getCfdiRelacionados() {
        return cfdiRelacionados;
    }

    /**
     * Elemento: CfdiRelacionados
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo opcional para precisar la información de los comprobantes
     * relacionados.
     *
     * @param cfdiRelacionados
     */
    public void setCfdiRelacionados(List<CfdiRelacionados> cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }

    /**
     * Elemento: Emisor
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para expresar la información del contribuyente emisor del
     * comprobante.
     *
     * @return
     */
    public Emisor getEmisor() {
        return emisor;
    }

    /**
     * Elemento: Emisor
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para expresar la información del contribuyente emisor del
     * comprobante.
     *
     * @param emisor
     */
    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    /**
     * Elemento: Receptor
     *
     * Diagrama Jueves 13 de enero de 2022 DIARIO OFICIAL DIARIO OFICIAL Jueves
     * 13 de enero de 2022
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para precisar la información del contribuyente receptor
     * del comprobante.
     *
     * @return
     */
    public Receptor getReceptor() {
        return receptor;
    }

    /**
     * Elemento: Receptor
     *
     * Diagrama Jueves 13 de enero de 2022 DIARIO OFICIAL DIARIO OFICIAL Jueves
     * 13 de enero de 2022
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para precisar la información del contribuyente receptor
     * del comprobante.
     *
     * @param receptor
     */
    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

    public Conceptos getConceptos() {
        return conceptos;
    }

    public void setConceptos(Conceptos conceptos) {
        this.conceptos = conceptos;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    public Addenda getAddenda() {
        return addenda;
    }

    public void setAddenda(Addenda addenda) {
        this.addenda = addenda;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
