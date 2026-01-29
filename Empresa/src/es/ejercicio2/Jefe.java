package es.ejercicio2;
/**
 * @file Jefe.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase que representa a un Jefe de la empresa.
 * Hereda de Empleado y añade atributos específicos como departamento y número de subordinados.
 * Solo los Jefes pueden subir el sueldo a empleados de inferior categoría.
 */

public class Jefe extends Empleado {
    private String departamento;
    private int numSubordinados;

    /**
     * Constructor completo de Jefe.
     *
     * @param nombre Nombre del jefe
     * @param sexo Sexo del jefe
     * @param dni Documento Nacional de Identidad
     * @param fechaNac Fecha de nacimiento
     * @param nss Número de la Seguridad Social
     * @param numEmpleado Número de empleado
     * @param fechaContratacion Fecha de contratación
     * @param irpf Porcentaje de IRPF
     * @param cargo Cargo o puesto de trabajo
     * @param sueldo Sueldo base
     * @param departamento Departamento que dirige
     * @param numSubordinados Número de subordinados
     */
    public Jefe(String nombre, char sexo, String dni, Fecha fechaNac,
                String nss, int numEmpleado, Fecha fechaContratacion,
                double irpf, String cargo, double sueldo,
                String departamento, int numSubordinados) {
        super(nombre, sexo, dni, fechaNac, nss, numEmpleado, fechaContratacion, irpf, cargo, sueldo);
        setDepartamento(departamento);
        setNumSubordinados(numSubordinados);
    }

    /**
     * Constructor sencillo para pruebas.
     *
     * @param nombre Nombre del jefe
     * @param sexo Sexo del jefe
     * @param fechaContratacion Fecha de contratación
     * @param sueldo Sueldo del jefe
     * @param departamento Departamento que dirige
     */
    public Jefe(String nombre, char sexo, Fecha fechaContratacion, double sueldo, String departamento) {
        super(nombre, sexo, fechaContratacion, sueldo);
        setDepartamento(departamento);
        this.numSubordinados = 0;
    }

    /**
     * Obtiene el departamento que dirige el jefe.
     * @return Nombre del departamento
     */
    public String getDepartamento() { return departamento; }

    /**
     * Obtiene el número de subordinados.
     * @return Número de subordinados
     */
    public int getNumSubordinados() { return numSubordinados; }

    /**
     * Asigna el departamento que dirige el jefe.
     * @param departamento Nombre del departamento
     * @throws IllegalArgumentException si el departamento es null o vacío
     */
    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Departamento no puede ser null o vacío");
        }
        this.departamento = departamento.trim();
    }

    /**
     * Asigna el número de subordinados.
     * @param numSubordinados Número de subordinados (debe ser no negativo)
     * @throws IllegalArgumentException si el número es negativo
     */
    public void setNumSubordinados(int numSubordinados) {
        if (numSubordinados < 0) {
            throw new IllegalArgumentException("Número de subordinados no puede ser negativo");
        }
        this.numSubordinados = numSubordinados;
    }

    /**
     * Sube el sueldo a un empleado de inferior categoría.
     * Solo los Jefes pueden ejecutar este método y no pueden subir sueldo a otros Jefes.
     *
     * @param empleado Empleado al que se le sube el sueldo
     * @param incremento Cantidad a incrementar (debe ser positiva)
     * @throws IllegalArgumentException si el empleado es null, es otro Jefe o el incremento es inválido
     */
    public void subirSueldo(Empleado empleado, double incremento) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        // Un Jefe no puede subir sueldo a otro Jefe
        if (empleado instanceof Jefe) {
            throw new IllegalArgumentException("Un Jefe no puede subir el sueldo a otro Jefe");
        }
        if (incremento <= 0.0) {
            throw new IllegalArgumentException("El incremento debe ser positivo");
        }

        double sueldoActual = empleado.getSueldo();
        empleado.setSueldo(sueldoActual + incremento);
    }

    /**
     * Retorna una representación en String del jefe.
     * @return Cadena con los datos del jefe
     */
    @Override
    public String toString() {
        return "Jefe{" + super.toString() +
                ", departamento='" + departamento + '\'' +
                ", numSubordinados=" + numSubordinados +
                '}';
    }
}