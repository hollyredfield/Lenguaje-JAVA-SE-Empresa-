/**
 * @file Persona.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase abstracta que representa los atributos básicos de una persona.
 * Proporciona la base para las clases Empleado y sus subclases.
 */

public abstract class Persona {
    private String nombre;
    private char sexo;
    private String dni;
    private Fecha fechaNac;

    /**
     * Constructor de Persona.
     *
     * @param nombre Nombre de la persona
     * @param sexo Sexo de la persona ('M', 'H', 'F', 'O')
     * @param dni Documento Nacional de Identidad
     * @param fechaNac Fecha de nacimiento
     */
    public Persona(String nombre, char sexo, String dni, Fecha fechaNac) {
        setNombre(nombre);
        setSexo(sexo);
        setDni(dni);
        setFechaNac(fechaNac);
    }

    /**
     * Obtiene el nombre de la persona.
     * @return Nombre de la persona
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el sexo de la persona.
     * @return Sexo de la persona
     */
    public char getSexo() { return sexo; }

    /**
     * Obtiene el DNI de la persona.
     * @return DNI de la persona
     */
    public String getDni() { return dni; }

    /**
     * Obtiene la fecha de nacimiento.
     * @return Fecha de nacimiento
     */
    public Fecha getFechaNac() { return fechaNac; }

    /**
     * Asigna el nombre de la persona.
     * @param nombre Nombre de la persona
     * @throws IllegalArgumentException si el nombre es null o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null o vacío");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Asigna el sexo de la persona.
     * @param sexo Sexo de la persona ('M', 'H', 'F', 'O')
     * @throws IllegalArgumentException si el sexo no es válido
     */
    public void setSexo(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if (sexo != 'M' && sexo != 'F' && sexo != 'H' && sexo != 'O') {
            throw new IllegalArgumentException("Sexo inválido. Use 'M', 'H', 'F' u 'O'");
        }
        this.sexo = sexo;
    }

    /**
     * Asigna el DNI de la persona.
     * Permite DNI vacío para constructores sencillos.
     *
     * @param dni Documento Nacional de Identidad
     */
    public void setDni(String dni) {
        // Permito DNI vacío
        if (dni == null) {
            this.dni = "";
        } else {
            this.dni = dni.trim();
        }
    }

    /**
     * Asigna la fecha de nacimiento.
     * @param fechaNac Fecha de nacimiento
     * @throws IllegalArgumentException si la fecha es null
     */
    public void setFechaNac(Fecha fechaNac) {
        if (fechaNac == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser null");
        }
        this.fechaNac = fechaNac;
    }

    /**
     * Retorna una representación en String de la persona.
     * @return Cadena con los datos de la persona
     */
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', sexo=" + sexo + ", dni='" + dni + "', fechaNac=" + fechaNac + "}";
    }
}