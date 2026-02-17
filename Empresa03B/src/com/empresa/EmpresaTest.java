package com.empresa;

import java.util.Scanner;

/**
 *
 * @author Pedro
 * @version 2.0
 */
public class EmpresaTest {
    static char opcion;
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        do {
            System.out.println("\t\tG E S T I O N   D E   E M P R E S A");
            System.out.println("\t\t===================================\n");
            System.out.println("C) Crear un empleado/jefe");
            System.out.println("L) Listar empleados");
            System.out.println("S) Subir sueldo");
            System.out.println("T) Totalizar sueldos");
            System.out.println("D) Descontar porcentaje");
            System.out.println("B) Borrar empleado");
            System.out.println("G) Grabar empleados");
            System.out.println("E) lEer empleados");
            System.out.println("F) Finalizar aplicación");
            System.out.print("\n\tIntroduce opción: ");
            
            opcion = scanner.nextLine().toUpperCase().charAt(0);
            
            switch(opcion){
                case 'C':
                    Plantilla.crearEmpleado();
                    break;
                case 'L':
                    Plantilla.listarEmpleados();
                    break;
                case 'T':
                    double totalSueldos = Plantilla.totalizarSueldos();
                    System.out.printf("\nEl total de sueldos a pagar es de %,.2f€%n", totalSueldos);
                    break;
                case 'G':
                    Plantilla.grabarEmpleados();
                    break;
                case 'E':
                    Plantilla.leerEmpleados();
            }
        }
        while(opcion != 'F');
    }
}
