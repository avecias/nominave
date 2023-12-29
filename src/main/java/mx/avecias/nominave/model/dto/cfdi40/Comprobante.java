/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import mx.avecias.nominave.model.dto.User;
import mx.avecias.nominave.model.dto.cfdi40.adapter.CodigoPostalAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.ExportacionAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.FechaAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.FormaPagoAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.MetodoPagoAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.MonedaAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.TImporteAdapter;
import mx.avecias.nominave.model.dto.cfdi40.adapter.TipoDeComprobanteAdapter;
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
@XmlRootElement(name = "Comprobante")
@XmlType(propOrder = {"informacionGlobal", "cfdiRelacionados", "emisor", "receptor", "conceptos", "impuestos", "complemento", "addenda"})
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
    private String sello;
    private String noCertificado;
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
    /**
     * Elementos Hijo (min,max)
     *
     * Secuencia (1, 1) InformacionGlobal (0, 1)
     *
     * CfdiRelacionados (0, Ilimitado)
     *
     * Emisor (1, 1)
     *
     * Receptor (1, 1)
     *
     * Conceptos (1, 1)
     *
     * Impuestos (0, 1)
     *
     * Complemento (0, 1)
     *
     * Addenda (0, 1)
     *
     */
    private InformacionGlobal informacionGlobal;
    private CfdiRelacionados cfdiRelacionados;
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
    @XmlAttribute(name = "Version", required = true)
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
     * Serie
     *
     * Descripción Atributo opcional para precisar la serie para control interno
     * del contribuyente. Este atributo acepta una cadena de caracteres.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 25
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,25}
     *
     * @return
     */
    @XmlAttribute(name = "Serie", required = false)
    public String getSerie() {
        return serie;
    }

    /**
     * Serie
     *
     * Descripción Atributo opcional para precisar la serie para control interno
     * del contribuyente. Este atributo acepta una cadena de caracteres.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 25
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,25}
     *
     * @param serie
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Folio
     *
     * Descripción Atributo opcional para control interno del contribuyente que
     * expresa el folio del comprobante, acepta una cadena de caracteres.
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
     * Patrón [^|]{1,40}
     *
     * @return
     */
    @XmlAttribute(name = "Folio", required = false)
    public String getFolio() {
        return folio;
    }

    /**
     * Folio
     *
     * Descripción Atributo opcional para control interno del contribuyente que
     * expresa el folio del comprobante, acepta una cadena de caracteres.
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
     * Patrón [^|]{1,40}
     *
     * @param folio
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Fecha
     *
     * Descripción Atributo requerido para la expresión de la fecha y hora de
     * expedición del Comprobante Fiscal Digital por Internet. Se expresa en la
     * forma AAAA- MM-DDThh:mm:ss y debe corresponder con la hora local donde se
     * expide el comprobante.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_FechaH Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * Sello
     *
     * Descripción Atributo requerido para contener el sello digital del
     * comprobante fiscal, al que hacen referencia las reglas de resolución
     * miscelánea vigente. El sello debe ser expresado como una cadena de texto
     * en formato Base 64.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
     *
     * @return
     */
    @XmlJavaTypeAdapter(FechaAdapter.class)
    @XmlAttribute(name = "Fecha", required = true)
    public Date getFecha() {
        return fecha;
    }

    /**
     * Fecha
     *
     * Descripción Atributo requerido para la expresión de la fecha y hora de
     * expedición del Comprobante Fiscal Digital por Internet. Se expresa en la
     * forma AAAA- MM-DDThh:mm:ss y debe corresponder con la hora local donde se
     * expide el comprobante.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_FechaH Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * Sello
     *
     * Descripción Atributo requerido para contener el sello digital del
     * comprobante fiscal, al que hacen referencia las reglas de resolución
     * miscelánea vigente. El sello debe ser expresado como una cadena de texto
     * en formato Base 64.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
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
    @XmlAttribute(name = "Sello", required = false)
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
     * NoCertificado
     *
     * Descripción Atributo requerido para expresar el número de serie del
     * certificado de sello digital que ampara al comprobante, de acuerdo con el
     * acuse correspondiente a 20 posiciones otorgado por el sistema del SAT.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 20
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [0-9]{20}
     *
     * @return
     */
    @XmlAttribute(name = "NoCertificado", required = true)
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     * NoCertificado
     *
     * Descripción Atributo requerido para expresar el número de serie del
     * certificado de sello digital que ampara al comprobante, de acuerdo con el
     * acuse correspondiente a 20 posiciones otorgado por el sistema del SAT.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Longitud 20
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [0-9]{20}
     *
     * @param noCertificado
     */
    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    /**
     * Certificado
     *
     * Descripción Atributo requerido que sirve para incorporar el certificado
     * de sello digital que ampara al comprobante, como texto en formato base
     * 64.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
     * @return
     */
    @XmlAttribute(name = "Certificado", required = true)
    public String getCertificado() {
        return certificado;
    }

    /**
     * Certificado
     *
     * Descripción Atributo requerido que sirve para incorporar el certificado
     * de sello digital que ampara al comprobante, como texto en formato base
     * 64.
     *
     * Uso requerido
     *
     * Tipo Base xs:string
     *
     * Espacio en Blanco Colapsar
     *
     * @param certificado
     */
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    /**
     * CondicionesDePago
     *
     * Descripción Atributo condicional para expresar las condiciones
     * comerciales aplicables para el pago del comprobante fiscal digital por
     * Internet. Este atributo puede ser condicionado mediante atributos o
     * complementos.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 1000
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,1000} DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * @return
     */
    @XmlAttribute(name = "CondicionesDePago", required = false)
    public String getCondicionesDepago() {
        return condicionesDepago;
    }

    /**
     * CondicionesDePago
     *
     * Descripción Atributo condicional para expresar las condiciones
     * comerciales aplicables para el pago del comprobante fiscal digital por
     * Internet. Este atributo puede ser condicionado mediante atributos o
     * complementos.
     *
     * Uso opcional
     *
     * Tipo Base xs:string
     *
     * Longitud Mínima 1
     *
     * Longitud Máxima 1000
     *
     * Espacio en Blanco Colapsar
     *
     * Patrón [^|]{1,1000} DIARIO OFICIAL Jueves 13 de enero de 2022
     *
     * @param condicionesDepago
     */
    public void setCondicionesDepago(String condicionesDepago) {
        this.condicionesDepago = condicionesDepago;
    }

    /**
     * SubTotal
     *
     * Descripción Atributo requerido para representar la suma de los importes
     * de los conceptos antes de descuentos e impuesto. No se permiten valores
     * negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    @XmlJavaTypeAdapter(TImporteAdapter.class)
    @XmlAttribute(name = "SubTotal", required = true)
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * SubTotal
     *
     * Descripción Atributo requerido para representar la suma de los importes
     * de los conceptos antes de descuentos e impuesto. No se permiten valores
     * negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @param subTotal
     */
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Descuento
     *
     * Descripción Atributo condicional para representar el importe total de los
     * descuentos aplicables antes de impuestos. No se permiten valores
     * negativos. Se debe registrar cuando existan conceptos con descuento.
     *
     * Uso opcional
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    @XmlJavaTypeAdapter(TImporteAdapter.class)
    @XmlAttribute(name = "SubTotal", required = false)
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Descuento
     *
     * Descripción Atributo condicional para representar el importe total de los
     * descuentos aplicables antes de impuestos. No se permiten valores
     * negativos. Se debe registrar cuando existan conceptos con descuento.
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
     * TipoCambio
     *
     * Descripción Atributo condicional para representar el tipo de cambio FIX
     * conforme con la moneda usada. Es requerido cuando la clave de moneda es
     * distinta de MXN y de XXX. El valor debe reflejar el número de pesos
     * mexicanos que equivalen a una unidad de la divisa señalada en el atributo
     * moneda. Si el valor está fuera del porcentaje aplicable a la moneda
     * tomado del catálogo c_Moneda, el emisor debe obtener del PAC que vaya a
     * timbrar el CFDI, de manera no automática, una clave de confirmación para
     * ratificar que el valor es correcto e integrar dicha clave en el atributo
     * Confirmacion.
     *
     * Uso opcional
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     *
     * @return
     */
    @XmlJavaTypeAdapter(TImporteAdapter.class)
    @XmlAttribute(name = "TipoCambio", required = false)
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    /**
     * TipoCambio
     *
     * Descripción Atributo condicional para representar el tipo de cambio FIX
     * conforme con la moneda usada. Es requerido cuando la clave de moneda es
     * distinta de MXN y de XXX. El valor debe reflejar el número de pesos
     * mexicanos que equivalen a una unidad de la divisa señalada en el atributo
     * moneda. Si el valor está fuera del porcentaje aplicable a la moneda
     * tomado del catálogo c_Moneda, el emisor debe obtener del PAC que vaya a
     * timbrar el CFDI, de manera no automática, una clave de confirmación para
     * ratificar que el valor es correcto e integrar dicha clave en el atributo
     * Confirmacion.
     *
     * Uso opcional
     *
     * Tipo Base xs:decimal
     *
     * Valor Mínimo Incluyente 0.000001
     *
     * Posiciones Decimales 6
     *
     * Espacio en Blanco Colapsar
     *
     *
     * @param tipoCambio
     */
    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    /**
     * Total
     *
     * Descripción Atributo requerido para representar la suma del subtotal,
     * menos los descuentos aplicables, más las contribuciones recibidas
     * (impuestos trasladados - federales y/o locales, derechos, productos,
     * aprovechamientos, aportaciones de seguridad social, contribuciones de
     * mejoras) menos los impuestos retenidos federales y/o locales. Si el valor
     * es superior al límite que establezca el SAT en la Resolución Miscelánea
     * Fiscal vigente, el emisor debe obtener del PAC que vaya a timbrar el
     * CFDI, de manera no automática, una clave de confirmación para ratificar
     * Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * que el valor es correcto e integrar dicha clave en el atributo
     * Confirmacion. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
     *
     * @return
     */
    @XmlJavaTypeAdapter(TImporteAdapter.class)
    @XmlAttribute(name = "Total", required = false)
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Total
     *
     * Descripción Atributo requerido para representar la suma del subtotal,
     * menos los descuentos aplicables, más las contribuciones recibidas
     * (impuestos trasladados - federales y/o locales, derechos, productos,
     * aprovechamientos, aportaciones de seguridad social, contribuciones de
     * mejoras) menos los impuestos retenidos federales y/o locales. Si el valor
     * es superior al límite que establezca el SAT en la Resolución Miscelánea
     * Fiscal vigente, el emisor debe obtener del PAC que vaya a timbrar el
     * CFDI, de manera no automática, una clave de confirmación para ratificar
     * Jueves 13 de enero de 2022 DIARIO OFICIAL
     *
     * que el valor es correcto e integrar dicha clave en el atributo
     * Confirmacion. No se permiten valores negativos.
     *
     * Uso requerido
     *
     * Tipo Especial tdCFDI:t_Importe
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
    @XmlAttribute(name = "Confirmacion", required = false)
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
     * FormaPago
     *
     * Descripción Atributo condicional para expresar la clave de la forma de
     * pago de los bienes o servicios amparados por el comprobante.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_FormaPago
     *
     * @return
     */
    @XmlJavaTypeAdapter(FormaPagoAdapter.class)
    @XmlAttribute(name = "FormaPago", required = false)
    public FormaPago getFormaPago() {
        return formaPago;
    }

    /**
     * FormaPago
     *
     * Descripción Atributo condicional para expresar la clave de la forma de
     * pago de los bienes o servicios amparados por el comprobante.
     *
     * Uso opcional
     *
     * Tipo Especial catCFDI:c_FormaPago
     *
     * @param formaPago
     */
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Moneda
     *
     * Descripción Atributo requerido para identificar la clave de la moneda
     * utilizada para expresar los montos, cuando se usa moneda nacional se
     * registra MXN. Conforme con la especificación ISO 4217.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Moneda
     *
     *
     * @return
     */
    @XmlJavaTypeAdapter(MonedaAdapter.class)
    @XmlAttribute(name = "Moneda", required = true)
    public Moneda getMoneda() {
        return moneda;
    }

    /**
     * Moneda
     *
     * Descripción Atributo requerido para identificar la clave de la moneda
     * utilizada para expresar los montos, cuando se usa moneda nacional se
     * registra MXN. Conforme con la especificación ISO 4217.
     *
     * Uso requerido
     *
     * Tipo Especial catCFDI:c_Moneda
     *
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
    @XmlJavaTypeAdapter(TipoDeComprobanteAdapter.class)
    @XmlAttribute(name = "TipoDeComprobante", required = true)
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
    @XmlJavaTypeAdapter(ExportacionAdapter.class)
    @XmlAttribute(name = "Exportacion", required = true)
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
    @XmlJavaTypeAdapter(MetodoPagoAdapter.class)
    @XmlAttribute(name = "MetodoPago", required = true)
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
    @XmlJavaTypeAdapter(CodigoPostalAdapter.class)
    @XmlAttribute(name = "LugarExpedicion", required = true)
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
    @XmlElement(name = "InformacionGlobal", required = false)
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
    @XmlElement(name = "CfdiRelacionados", required = false)
    public CfdiRelacionados getCfdiRelacionados() {
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
    public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
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
    @XmlElement(name = "Emisor", required = true)
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
    @XmlElement(name = "Receptor", required = true)
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

    /**
     * Elemento: Conceptos Diagrama
     *
     *
     *
     *
     * Descripción Nodo requerido para listar los conceptos cubiertos por el
     * comprobante.
     *
     * @return
     */
    @XmlElement(name = "Conceptos", required = true)
    public Conceptos getConceptos() {
        return conceptos;
    }

    /**
     * Elemento: Conceptos Diagrama
     *
     *
     *
     *
     * Descripción Nodo requerido para listar los conceptos cubiertos por el
     * comprobante.
     *
     * @param conceptos
     */
    public void setConceptos(Conceptos conceptos) {
        this.conceptos = conceptos;
    }

    /**
     *
     * @return
     */
    public Impuestos getImpuestos() {
        return impuestos;
    }

    /**
     *
     * @param impuestos
     */
    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    /**
     *
     * @return
     */
    public Complemento getComplemento() {
        return complemento;
    }

    /**
     *
     * @param complemento
     */
    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    /**
     *
     * @return
     */
    public Addenda getAddenda() {
        return addenda;
    }

    /**
     *
     * @param addenda
     */
    public void setAddenda(Addenda addenda) {
        this.addenda = addenda;
    }

    @XmlTransient
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
