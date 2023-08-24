/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Aug 23, 2023 7:37:07 PM
 *
 */
public class Timbre implements Serializable {

    private Integer idTimbreFiscalDigital;
    private String version;
    private String uuid;
    private String rfcProvCertif;
    private String selloCFD;
    private String selloSAT;
    private String noCertificadoSAT;
    private byte[] codigoQR;
    private String cadenaOriginal;
    private Date fechaTimbrado;
    private Complemento complemento;

    public Timbre() {
    }

    public Integer getIdTimbreFiscalDigital() {
        return idTimbreFiscalDigital;
    }

    public void setIdTimbreFiscalDigital(Integer idTimbreFiscalDigital) {
        this.idTimbreFiscalDigital = idTimbreFiscalDigital;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRfcProvCertif() {
        return rfcProvCertif;
    }

    public void setRfcProvCertif(String rfcProvCertif) {
        this.rfcProvCertif = rfcProvCertif;
    }

    public String getSelloCFD() {
        return selloCFD;
    }

    public void setSelloCFD(String selloCFD) {
        this.selloCFD = selloCFD;
    }

    public String getSelloSAT() {
        return selloSAT;
    }

    public void setSelloSAT(String selloSAT) {
        this.selloSAT = selloSAT;
    }

    public String getNoCertificadoSAT() {
        return noCertificadoSAT;
    }

    public void setNoCertificadoSAT(String noCertificadoSAT) {
        this.noCertificadoSAT = noCertificadoSAT;
    }

    public byte[] getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(byte[] codigoQR) {
        this.codigoQR = codigoQR;
    }

    public String getCadenaOriginal() {
        return cadenaOriginal;
    }

    public void setCadenaOriginal(String cadenaOriginal) {
        this.cadenaOriginal = cadenaOriginal;
    }

    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
