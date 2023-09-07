/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40.cat;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author avecias date: Sep 6, 2023 6:31:19 PM
 *
 */
public class ClaveUnidad implements Serializable {

    private String claveUnidad;
    private String nombre;
    private String descripcion;
    private String nota;
    private String fechaDeInicioDeVigencia;
    private String fechaDeFinDeVigencia;
    private String simbolo;

    public ClaveUnidad() {
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFechaDeInicioDeVigencia() {
        return fechaDeInicioDeVigencia;
    }

    public void setFechaDeInicioDeVigencia(String fechaDeInicioDeVigencia) {
        this.fechaDeInicioDeVigencia = fechaDeInicioDeVigencia;
    }

    public String getFechaDeFinDeVigencia() {
        return fechaDeFinDeVigencia;
    }

    public void setFechaDeFinDeVigencia(String fechaDeFinDeVigencia) {
        this.fechaDeFinDeVigencia = fechaDeFinDeVigencia;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
