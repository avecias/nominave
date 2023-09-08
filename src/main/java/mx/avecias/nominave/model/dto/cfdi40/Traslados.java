/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.avecias.nominave.model.dto.cfdi40;

import java.io.Serializable;

/**
 *
 * @author avecias date: Sep 7, 2023 3:08:09 PM
 *
 */
public class Traslados implements Serializable {

    private Integer idTraslado;
    private Traslado traslado;

    public Traslados() {
    }

    public Integer getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Integer idTraslado) {
        this.idTraslado = idTraslado;
    }

    /**
     * Elemento: Traslado
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para asentar la información detallada de un traslado de
     * impuestos aplicable al presente concepto. DIARIO OFICIAL Jueves 13 de
     * enero de 2022
     *
     * @return
     */
    public Traslado getTraslado() {
        return traslado;
    }

    /**
     * Elemento: Traslado
     *
     * Diagrama
     *
     *
     *
     *
     * Descripción
     *
     * Nodo requerido para asentar la información detallada de un traslado de
     * impuestos aplicable al presente concepto. DIARIO OFICIAL Jueves 13 de
     * enero de 2022
     *
     * @param traslado
     */
    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

}
