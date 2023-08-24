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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public CodigoPostal getDomicilioFiscalReceptor() {
        return domicilioFiscalReceptor;
    }

    public void setDomicilioFiscalReceptor(CodigoPostal domicilioFiscalReceptor) {
        this.domicilioFiscalReceptor = domicilioFiscalReceptor;
    }

    public Pais getResidenciaFiscal() {
        return residenciaFiscal;
    }

    public void setResidenciaFiscal(Pais residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }

    public RegimenFiscal getRegimenFiscalReceptor() {
        return regimenFiscalReceptor;
    }

    public void setRegimenFiscalReceptor(RegimenFiscal regimenFiscalReceptor) {
        this.regimenFiscalReceptor = regimenFiscalReceptor;
    }

    public UsoCfdi getUsoCfdi() {
        return usoCfdi;
    }

    public void setUsoCfdi(UsoCfdi usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
