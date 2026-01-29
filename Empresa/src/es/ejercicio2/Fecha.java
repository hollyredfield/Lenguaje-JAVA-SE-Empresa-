package es.ejercicio2;
/**
 * @file Fecha.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase inmutable que representa una fecha con día, mes y año.
 * Proporciona validación básica de fechas y formato de salida.
 */

public final class Fecha {
    private final int dia;
    private final int mes;
    private final int anio;

    /**
     * Constructor de Fecha.
     * Realiza validación básica de los parámetros.
     *
     * @param dia Día de la fecha (1-31)
     * @param mes Mes de la fecha (1-12)
     * @param anio Año de la fecha
     * @throws IllegalArgumentException si el mes o día no son válidos
     */
    public Fecha(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes no válido");
        }
        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("Día no válido");
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Obtiene el día de la fecha.
     * @return Día de la fecha
     */
    public int getDia() { return dia; }

    /**
     * Obtiene el mes de la fecha.
     * @return Mes de la fecha
     */
    public int getMes() { return mes; }

    /**
     * Obtiene el año de la fecha.
     * @return Año de la fecha
     */
    public int getAnio() { return anio; }

    /**
     * Retorna una representación formateada de la fecha.
     * Formato: DD/MM/AAAA
     *
     * @return Cadena con la fecha formateada
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}