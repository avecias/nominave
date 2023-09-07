/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import mx.avecias.nominave.model.dto.cfdi40.cat.ClaveProdServ;
import mx.avecias.nominave.model.dto.cfdi40.cat.ClaveUnidad;
import mx.avecias.nominave.model.dto.cfdi40.cat.ObjetoImp;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 30, 2023 3:47:14 PM
 *
 */
public class Concepto implements Serializable {

    private Integer idConcepto;
    private String noIdentificacion;
    private BigDecimal cantidad;
    private String unidad;
    private String descripcion;
    private BigDecimal valorUnitario;
    private BigDecimal importe;
    private BigDecimal descuento;
    // catalogos
    private ClaveProdServ claveProdServ;
    private ClaveUnidad claveUnidad;
    private ObjetoImp objetoImp;
    // elmentos 
    /*
         Elementos Hijo (min,max)

          Secuencia (1, 1)                 Impuestos (0, 1)

                                           ACuentaTerceros (0, 1)

                                           InformacionAduanera (0, Ilimitado)

                                           CuentaPredial (0, Ilimitado)

                                           ComplementoConcepto (0, 1)

                                           Parte (0, Ilimitado)
     */
    private Impuestos impuestos;
    private ACuentaTerceros aCuentaTerceros;
    private List<InformacionAduanera> informacionAduanera;
    private List<CuentaPredial> cuentaPredial;
    private ComplementoConcepto complementoConcepto;
    private List<Parte> partes;
    // relacion de muchos a uno
    private Conceptos conceptos;

    public Concepto() {
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    /**
     * NoIdentificacion
     *
     * Descripción Atributo opcional para expresar el número de parte,
     * identificador del producto o del servicio, la clave de producto o
     * servicio, SKU o equivalente, propia de la operación del emisor, amparado
     * por el presente concepto. Opcionalmente se puede utilizar claves del
     * estándar GTIN.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 100
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,100}
     *
     * @return
     */
    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    /**
     * NoIdentificacion
     *
     * Descripción Atributo opcional para expresar el número de parte,
     * identificador del producto o del servicio, la clave de producto o
     * servicio, SKU o equivalente, propia de la operación del emisor, amparado
     * por el presente concepto. Opcionalmente se puede utilizar claves del
     * estándar GTIN.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 100
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,100}
     *
     * @param noIdentificacion
     */
    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    /**
     * Cantidad
     *
     * Descripción Atributo requerido para precisar la cantidad de bienes o
     * servicios del tipo particular definido por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Cantidad
     *
     * Descripción Atributo requerido para precisar la cantidad de bienes o
     * servicios del tipo particular definido por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     * @param cantidad
     */
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Unidad
     *
     * Descripción Atributo opcional para precisar la unidad de medida propia de
     * la operación del emisor, aplicable para la cantidad expresada en el
     * concepto. La unidad debe corresponder con la descripción del concepto.
     *
     * Uso opcional Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 20
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,20}
     *
     * @return
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Unidad
     *
     * Descripción Atributo opcional para precisar la unidad de medida propia de
     * la operación del emisor, aplicable para la cantidad expresada en el
     * concepto. La unidad debe corresponder con la descripción del concepto.
     *
     * Uso opcional Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 20
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,20}
     *
     * @param unidad
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * Descripcion
     *
     * Descripción Atributo requerido para precisar la descripción del bien o
     * servicio cubierto por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 1000
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,1000}
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Descripcion
     *
     * Descripción Atributo requerido para precisar la descripción del bien o
     * servicio cubierto por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 1000
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,1000}
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * ValorUnitario
     *
     * Descripción Atributo requerido para precisar el valor o precio unitario
     * del bien o servicio cubierto por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * ValorUnitario
     *
     * Descripción Atributo requerido para precisar el valor o precio unitario
     * del bien o servicio cubierto por el presente concepto.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @param valorUnitario
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Importe
     *
     * Descripción Atributo requerido para precisar el importe total de los
     * bienes o servicios del presente concepto. Debe ser equivalente al
     * resultado de multiplicar la cantidad por el valor unitario expresado en
     * el concepto. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Importe
     *
     * Descripción Atributo requerido para precisar el importe total de los
     * bienes o servicios del presente concepto. Debe ser equivalente al
     * resultado de multiplicar la cantidad por el valor unitario expresado en
     * el concepto. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @param importe
     */
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    /**
     * Descuento
     *
     * Descripción Atributo opcional para representar el importe de los
     * descuentos aplicables al concepto. No se permiten valores negativos.
     *
     * Uso opcional
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Descuento
     *
     * Descripción Atributo opcional para representar el importe de los
     * descuentos aplicables al concepto. No se permiten valores negativos.
     *
     * Uso opcional
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @param descuento
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    /**
     * ClaveProdServ
     *
     * Descripción Atributo requerido para expresar la clave del producto o del
     * servicio amparado por el presente concepto. Es requerido y deben utilizar
     * las claves del catálogo de productos y servicios, cuando los conceptos
     * que registren por sus actividades correspondan con dichos conceptos.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_ClaveProdServ
     *
     * @return
     */
    public ClaveProdServ getClaveProdServ() {
        return claveProdServ;
    }

    /**
     * ClaveProdServ
     *
     * Descripción Atributo requerido para expresar la clave del producto o del
     * servicio amparado por el presente concepto. Es requerido y deben utilizar
     * las claves del catálogo de productos y servicios, cuando los conceptos
     * que registren por sus actividades correspondan con dichos conceptos.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_ClaveProdServ
     *
     * @param claveProdServ
     */
    public void setClaveProdServ(ClaveProdServ claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    /**
     * ClaveUnidad
     *
     * Descripción Atributo requerido para precisar la clave de unidad de medida
     * estandarizada aplicable para la cantidad expresada en el concepto. La
     * unidad debe corresponder con la descripción del concepto.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_ClaveUnidad
     *
     * @return
     */
    public ClaveUnidad getClaveUnidad() {
        return claveUnidad;
    }

    /**
     * ClaveUnidad
     *
     * Descripción Atributo requerido para precisar la clave de unidad de medida
     * estandarizada aplicable para la cantidad expresada en el concepto. La
     * unidad debe corresponder con la descripción del concepto.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_ClaveUnidad
     *
     * @param claveUnidad
     */
    public void setClaveUnidad(ClaveUnidad claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public ObjetoImp getObjetoImp() {
        return objetoImp;
    }

    public void setObjetoImp(ObjetoImp objetoImp) {
        this.objetoImp = objetoImp;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public ACuentaTerceros getaCuentaTerceros() {
        return aCuentaTerceros;
    }

    public void setaCuentaTerceros(ACuentaTerceros aCuentaTerceros) {
        this.aCuentaTerceros = aCuentaTerceros;
    }

    public List<InformacionAduanera> getInformacionAduanera() {
        return informacionAduanera;
    }

    public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }

    public List<CuentaPredial> getCuentaPredial() {
        return cuentaPredial;
    }

    public void setCuentaPredial(List<CuentaPredial> cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }

    public ComplementoConcepto getComplementoConcepto() {
        return complementoConcepto;
    }

    public void setComplementoConcepto(ComplementoConcepto complementoConcepto) {
        this.complementoConcepto = complementoConcepto;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }

    public Conceptos getConceptos() {
        return conceptos;
    }

    public void setConceptos(Conceptos conceptos) {
        this.conceptos = conceptos;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
