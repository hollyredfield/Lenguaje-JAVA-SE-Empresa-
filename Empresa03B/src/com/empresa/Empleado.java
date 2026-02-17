package com.empresa;

public class Empleado extends Persona {
    private int numEmple;
    private Fecha fechaCon;
    private double sueldo;
    private Estado estado;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
        
    public Empleado(final String nombre, final char sexo,final Fecha fechaCon, final double sueldo) {
        super(nombre, sexo);
        this.numEmple = Plantilla.numEmple++;
        this.fechaCon = fechaCon;
        this.sueldo = sueldo;
        this.estado = Estado.A;
    }

    public Fecha getFechaCon() {
        return fechaCon;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(final double sueldo) throws IllegalArgumentException{
        if (sueldo > 500 && sueldo < 5000){
            this.sueldo = sueldo;
        }else{
            throw new IllegalArgumentException("El sueldo no puede ser < de 500 ni mayor de 5000");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.sueldo != other.sueldo) {
            return false;
        }
        if (!this.getNombre().equals(other.getNombre())) {
            return false;
        }
        if (this.getSexo() != other.getSexo()){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + estado.getEstado() + ", " + fechaCon + ", " + sueldo;
    }

}