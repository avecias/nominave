/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
    private CfdiRelacionados cfdiRelacionados;
    private Emisor emisor;
    private Receptor receptor;
    private Conceptos conceptos;
    private Impuestos impuestos;
    private Complemento complemento;
    private Addenda addenda;
    private User user;

    public Comprobante() {
    }

    /**
     * version 
     * regresa version
     * requerido
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     * version
     * establecer la version
     * requerido
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCondicionesDepago() {
        return condicionesDepago;
    }

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

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public TipoDeComprobante getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(TipoDeComprobante tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public Exportacion getExportacion() {
        return exportacion;
    }

    public void setExportacion(Exportacion exportacion) {
        this.exportacion = exportacion;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public CodigoPostal getLugarDeExpedicion() {
        return lugarDeExpedicion;
    }

    public void setLugarDeExpedicion(CodigoPostal lugarDeExpedicion) {
        this.lugarDeExpedicion = lugarDeExpedicion;
    }

    public InformacionGlobal getInformacionGlobal() {
        return informacionGlobal;
    }

    public void setInformacionGlobal(InformacionGlobal informacionGlobal) {
        this.informacionGlobal = informacionGlobal;
    }

    public CfdiRelacionados getCfdiRelacionados() {
        return cfdiRelacionados;
    }

    public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public Receptor getReceptor() {
        return receptor;
    }

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
