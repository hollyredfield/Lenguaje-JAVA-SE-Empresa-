/**
 * @file EmpresaTest.java
 * @author Álex de Santiago Vicente
 * @date 29-01-2026
 * @version 1.0
 * @license GNU General Public License v3.0
 * @copyright (c) 2026 Álex de Santiago Vicente
 *
 * Descripción: Clase de prueba principal para el sistema de gestión de empleados.
 * Inicializa la aplicación y prueba las funcionalidades de las clases Empleado y Jefe.
 */

public class EmpresaTest {

    /**
     * Método principal de la aplicación.
     * Crea un array heterogéneo de empleados y jefes, y los visualiza.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Empleado e[] = new Empleado[8];//Constructor: Nombre, sexo, fecha-contr. y sueldo
        e[0] = new Empleado("Ana", 'M', new Fecha(14, 10, 2015), 1000);
        e[1] = new Jefe("Alfonso", 'H', new Fecha(10, 2, 2000), 1200, "rrhh"); // depto.
        e[2] = new Empleado("Benito", 'H', new Fecha(1, 6, 2014), 1250);
        e[3] = new Jefe("Mónica", 'M', new Fecha(8, 4, 2012), 1300, "contabilidad");
        e[4] = new Empleado("Alfredo", 'H', new Fecha(1, 10, 2010), (int) 995.20);
        e[5] = new Empleado("Vicente", 'H', new Fecha(14, 11, 2020), (int) 1020.45);
        e[6] = new Empleado("Silvio", 'H', new Fecha(25, 9, 2019), (int) 1070.50);
        e[7] = new Empleado("Marta", 'M', new Fecha(3, 4, 2018), (int) 1020.45);

        // Listamos el array usando el método toString() que debes añadir a las clases:
        for (Empleado emple : e) {
            System.out.println(emple);
        }
    }
}