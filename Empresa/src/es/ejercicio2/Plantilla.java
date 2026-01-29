package es.ejercicio2;
/**
 * @file Plantilla.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase final de utilidades para gestionar operaciones sobre colecciones de empleados.
 * Proporciona métodos estáticos para calcular totalizaciones y aplicar descuentos polimórficos.
 */

public final class Plantilla {

    /**
     * Calcula la suma total de sueldos de todos los empleados.
     *
     * @param empleados Array de empleados
     * @return Suma total de los sueldos
     * @throws IllegalArgumentException si el array es null
     */
    public static double totalizarSueldos(Empleado[] empleados) {
        if (empleados == null) {
            throw new IllegalArgumentException("Array de empleados no puede ser null");
        }
        double total = 0.0;
        for (Empleado emp : empleados) {
            if (emp != null) {
                total += emp.getSueldo();
            }
        }
        return total;
    }

    /**
     * Descuenta un porcentaje al sueldo del empleado de forma polimórfica.
     * Descuenta un 5% a los Jefes y un 10% a los Empleados.
     *
     * @param empleado Empleado al que se aplica el descuento
     * @throws IllegalArgumentException si el empleado es null
     */
    public static void descontarPorcentaje(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado no puede ser null");
        }

        double descuento;
        if (empleado instanceof Jefe) {
            descuento = 0.05; // 5% para Jefes
        } else {
            descuento = 0.10; // 10% para Empleados
        }

        double sueldoActual = empleado.getSueldo();
        double nuevoSueldo = sueldoActual * (1 - descuento);
        empleado.setSueldo(nuevoSueldo);
    }
}