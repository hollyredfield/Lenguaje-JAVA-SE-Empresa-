/**
 * @file Empleado.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase que representa a un empleado de la empresa.
 * Hereda de Persona y añade atributos específicos del empleo como NSS, número de empleado,
 * fecha de contratación, IRPF, cargo y sueldo.
 */

public class Empleado extends Persona {
    private String nss;
    private int numEmpleado;
    private Fecha fechaContratacion;
    private double irpf;
    private String cargo;
    private double sueldo;

    /**
     * Constructor completo de Empleado.
     *
     * @param nombre Nombre del empleado
     * @param sexo Sexo del empleado ('M', 'H', 'F', 'O')
     * @param dni Documento Nacional de Identidad
     * @param fechaNac Fecha de nacimiento
     * @param nss Número de la Seguridad Social
     * @param numEmpleado Número de empleado
     * @param fechaContratacion Fecha de contratación
     * @param irpf Porcentaje de IRPF (0-100)
     * @param cargo Cargo o puesto de trabajo
     * @param sueldo Sueldo base
     */
    public Empleado(String nombre, char sexo, String dni, Fecha fechaNac,
                    String nss, int numEmpleado, Fecha fechaContratacion,
                    double irpf, String cargo, double sueldo) {
        super(nombre, sexo, dni, fechaNac);
        setNss(nss);
        setNumEmpleado(numEmpleado);
        setFechaContratacion(fechaContratacion);
        setIrpf(irpf);
        setCargo(cargo);
        setSueldo(sueldo);
    }

    /**
     * Constructor sencillo para pruebas.
     * Inicializa un empleado con los datos básicos.
     *
     * @param nombre Nombre del empleado
     * @param sexo Sexo del empleado
     * @param fechaContratacion Fecha de contratación
     * @param sueldo Sueldo del empleado
     */
    public Empleado(String nombre, char sexo, Fecha fechaContratacion, double sueldo) {
        super(nombre, sexo, "", fechaContratacion);
        this.nss = "";
        this.numEmpleado = 1;
        this.fechaContratacion = fechaContratacion;
        this.irpf = 0.0;
        this.cargo = "";
        setSueldo(sueldo);
    }

    /**
     * Obtiene el número de la Seguridad Social.
     * @return NSS del empleado
     */
    public String getNss() { return nss; }

    /**
     * Obtiene el número de empleado.
     * @return Número de empleado
     */
    public int getNumEmpleado() { return numEmpleado; }

    /**
     * Obtiene la fecha de contratación.
     * @return Fecha de contratación
     */
    public Fecha getFechaContratacion() { return fechaContratacion; }

    /**
     * Obtiene el porcentaje de IRPF.
     * @return IRPF del empleado
     */
    public double getIrpf() { return irpf; }

    /**
     * Obtiene el cargo del empleado.
     * @return Cargo o puesto de trabajo
     */
    public String getCargo() { return cargo; }

    /**
     * Obtiene el sueldo del empleado.
     * @return Sueldo base
     */
    public double getSueldo() { return sueldo; }

    /**
     * Asigna el número de la Seguridad Social.
     * @param nss Número de la Seguridad Social
     */
    public void setNss(String nss) {
        if (nss == null) nss = "";
        this.nss = nss.trim();
    }

    /**
     * Asigna el número de empleado.
     * @param numEmpleado Número de empleado (debe ser positivo)
     * @throws IllegalArgumentException si el número es menor o igual a 0
     */
    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado <= 0) {
            throw new IllegalArgumentException("Número de empleado debe ser positivo");
        }
        this.numEmpleado = numEmpleado;
    }

    /**
     * Asigna la fecha de contratación.
     * @param fechaContratacion Fecha de contratación
     * @throws IllegalArgumentException si la fecha es null
     */
    public void setFechaContratacion(Fecha fechaContratacion) {
        if (fechaContratacion == null) {
            throw new IllegalArgumentException("Fecha de contratación no puede ser null");
        }
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Asigna el porcentaje de IRPF.
     * @param irpf Porcentaje de IRPF (debe estar entre 0 y 100)
     * @throws IllegalArgumentException si el IRPF está fuera del rango válido
     */
    public void setIrpf(double irpf) {
        if (irpf < 0.0 || irpf > 100.0) {
            throw new IllegalArgumentException("IRPF debe estar entre 0 y 100");
        }
        this.irpf = irpf;
    }

    /**
     * Asigna el cargo del empleado.
     * @param cargo Cargo o puesto de trabajo
     */
    public void setCargo(String cargo) {
        if (cargo == null) cargo = "";
        this.cargo = cargo.trim();
    }

    /**
     * Asigna el sueldo del empleado.
     * @param sueldo Sueldo base (debe ser no negativo)
     * @throws IllegalArgumentException si el sueldo es negativo
     */
    public void setSueldo(double sueldo) {
        if (sueldo < 0.0) {
            throw new IllegalArgumentException("Sueldo no puede ser negativo");
        }
        this.sueldo = sueldo;
    }

    /**
     * Retorna una representación en String del empleado.
     * @return Cadena con los datos del empleado
     */
    @Override
    public String toString() {
        return "Empleado{" + super.toString() +
                ", nss='" + nss + '\'' +
                ", numEmpleado=" + numEmpleado +
                ", fechaContratacion=" + fechaContratacion +
                ", irpf=" + irpf +
                ", cargo='" + cargo + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}