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
 * @author avecias date: Aug 3, 2023 5:44:57 PM
 */
public class FormaPago implements Serializable {

    private String claveFormaPago;
    private String descripcion;
    private String bancarizado;
    private String numeroOperacion;
    private String rfcEmisorCuentaOrdenante;
    private String cuentaOrdenante;
    private String patronCuentaOrdenante;
    private String rfcEmisorCuentaBeneficiario;
    private String cuentaBenenficiario;
    private String patronCuentaBeneficiaria;
    private String tipoCadenaPago;
    private String nombreBancoEmisorCuentaOrdenanteCasoExtranjero;
    private String fechaInicioVigencia;
    private String fechaFinVigencia;

    public FormaPago() {
    }

    public String getClaveFormaPago() {
        return claveFormaPago;
    }

    public void setClaveFormaPago(String claveFormaPago) {
        this.claveFormaPago = claveFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBancarizado() {
        return bancarizado;
    }

    public void setBancarizado(String bancarizado) {
        this.bancarizado = bancarizado;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getRfcEmisorCuentaOrdenante() {
        return rfcEmisorCuentaOrdenante;
    }

    public void setRfcEmisorCuentaOrdenante(String rfcEmisorCuentaOrdenante) {
        this.rfcEmisorCuentaOrdenante = rfcEmisorCuentaOrdenante;
    }

    public String getCuentaOrdenante() {
        return cuentaOrdenante;
    }

    public void setCuentaOrdenante(String cuentaOrdenante) {
        this.cuentaOrdenante = cuentaOrdenante;
    }

    public String getPatronCuentaOrdenante() {
        return patronCuentaOrdenante;
    }

    public void setPatronCuentaOrdenante(String patronCuentaOrdenante) {
        this.patronCuentaOrdenante = patronCuentaOrdenante;
    }

    public String getRfcEmisorCuentaBeneficiario() {
        return rfcEmisorCuentaBeneficiario;
    }

    public void setRfcEmisorCuentaBeneficiario(String rfcEmisorCuentaBeneficiario) {
        this.rfcEmisorCuentaBeneficiario = rfcEmisorCuentaBeneficiario;
    }

    public String getCuentaBenenficiario() {
        return cuentaBenenficiario;
    }

    public void setCuentaBenenficiario(String cuentaBenenficiario) {
        this.cuentaBenenficiario = cuentaBenenficiario;
    }

    public String getPatronCuentaBeneficiaria() {
        return patronCuentaBeneficiaria;
    }

    public void setPatronCuentaBeneficiaria(String patronCuentaBeneficiaria) {
        this.patronCuentaBeneficiaria = patronCuentaBeneficiaria;
    }

    public String getTipoCadenaPago() {
        return tipoCadenaPago;
    }

    public void setTipoCadenaPago(String tipoCadenaPago) {
        this.tipoCadenaPago = tipoCadenaPago;
    }

    public String getNombreBancoEmisorCuentaOrdenanteCasoExtranjero() {
        return nombreBancoEmisorCuentaOrdenanteCasoExtranjero;
    }

    public void setNombreBancoEmisorCuentaOrdenanteCasoExtranjero(String nombreBancoEmisorCuentaOrdenanteCasoExtranjero) {
        this.nombreBancoEmisorCuentaOrdenanteCasoExtranjero = nombreBancoEmisorCuentaOrdenanteCasoExtranjero;
    }

    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public String getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(String fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
