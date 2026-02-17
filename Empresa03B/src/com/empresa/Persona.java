package com.empresa;

import java.io.Serializable;

/**
 * Esta clase define una Persona
 * @author Pedro
 * @version 1.0
 */
public abstract class Persona implements Serializable {
    /**
     * Nombre alfanumérico
     */
    private final static long serialVersionUID = 12122024L;
    private static int contador = 0;
    private int numEmp;
    private String nombre;
    private char sexo;
    private Fecha fechaNac;
    
    /**
     * Construye una Persona a partir un nombre y un sexo
     * @param nombre La cadena de caracteres que represanta un nombre
     * @param sexo Sexo en forma de un carácter
     */
    public Persona(final String nombre, char sexo) {
        this.numEmp = ++contador;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public String getNombre() {
        final int IRPF = 15;
        return nombre;
    }

    public Persona setNombre(String nombre) { // Atípico
        this.nombre = nombre;
        return this;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + nombre + ", " + sexo + ", ";
    }
    
}
