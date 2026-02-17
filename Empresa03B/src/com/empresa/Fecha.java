package com.empresa;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class Fecha implements Serializable {
    private final int dia;
    private final int mes;
    private final int anio;
    private final static long serialVersionUID = 12122024L;
    
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
