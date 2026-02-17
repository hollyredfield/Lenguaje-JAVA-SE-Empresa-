package com.empresa;

/**
 *
 * @author oracle
 */
public class Jefe extends Empleado {
    protected String departam;
    
    public Jefe(String nombre, char sexo, Fecha fechaCon, double sueldo, String departam) {
        super(nombre, sexo, fechaCon, sueldo);
        this.departam = departam;
    }

    /**
     * 
     * @return Un texto informativo de la clase 
     */
    @Override
    public String toString() {
        return super.toString() + ", " + departam;
    }
    
    public void subirSueldo(Empleado empleado, double incremento){
        if (empleado.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
            System.out.println("> Prohibido subir sueldo a Jefes");
        }else{
            System.out.println("> Permitido subir sueldo a Empleado");
            empleado.setSueldo(empleado.getSueldo() + incremento);
        }
    }
}
