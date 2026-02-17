package com.empresa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Pedro
 */
public class Plantilla {
    private static List<Empleado> empleados;
    private static final Scanner scanner = new Scanner(System.in);
    private static String linea;
    private static char opcion;
    protected static int numEmple = 1;
        // Nombre, sexo, fecha y sueldo
    
    static {
        empleados = new ArrayList();
        empleados.add(new Empleado("Ana", 'M', new Fecha(14, 10, 2015), 1000));
        empleados.add(new Jefe("Alfonso", 'H', new Fecha(10, 2, 2000), 1200, "rrhh"));
        empleados.add(new Empleado("Benito", 'H', new Fecha(1, 6, 2014), 1250));
        empleados.add(new Empleado("Antonio", 'H', new Fecha(13, 11, 2017), 1250));
        empleados.add(new Empleado("Javier", 'H', new Fecha(21, 4, 2013), 1250));
        empleados.add(new Empleado("Montserrat", 'M', new Fecha(1, 7, 2010), 1250));
        empleados.add(new Jefe("Alicia", 'M', new Fecha(1, 6, 2000), 2150, "marketing"));
        empleados.add(new Jefe("Jorge", 'H', new Fecha(31, 5, 2010), 2210, "contabilidad"));
    }
    
    public static double totalizarSueldos() {
               
        double total = empleados.stream()
                .mapToDouble(e -> e.getSueldo())
                .sum();
        return total;
    }

    public static void descontarPorcentaje(Empleado empleado) {
        double sueldoActual = empleado.getSueldo();
        
        if (empleado instanceof Jefe){
            System.out.println(" > Es un Jefe");
            sueldoActual = sueldoActual * 0.90;
        }else  if (empleado instanceof Empleado) {
            System.out.println(" > Es un Empleado");
            sueldoActual = sueldoActual * 0.95;
        }
        empleado.setSueldo(sueldoActual);
    }

    public static void crearEmpleado() {
        System.out.println("\n\t*** C R E A R   E M P L E A D O ***");
        System.out.println("\t-----------------------------------");
        do {
            System.out.println("Elije <E> Empleado, <J> Jefe, <V> Volver...");
            linea = scanner.nextLine().toUpperCase();
            if (linea.length() < 1){
                linea = " "; // Si línea vacia, metemos un espacio para evitar error
            }
            opcion = linea.toUpperCase().charAt(0);
            String nombre, departamento;
            char sexo;
            int dia, mes, anio;
            Fecha fechaCon;
            double sueldo;
            
            switch(opcion){
                case 'E': case 'J':
                    System.out.print("\nIntroduce nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("\nIntroduce sexo  : ");
                    sexo = scanner.nextLine().charAt(0);
                    System.out.print("\nIntroduce dia   : ");
                    dia = scanner.nextInt();
                    System.out.print("\nIntroduce mes   : ");
                    mes = scanner.nextInt();
                    System.out.print("\nIntroduce año   : ");
                    anio = scanner.nextInt();
                    fechaCon = new Fecha(dia, mes, anio);
                    scanner.nextLine(); // Limpia buffer del teclado <Enter>
                    System.out.print("\nIntroduce sueldo: ");
                    sueldo = Double.parseDouble(scanner.nextLine());
                    if (opcion == 'E'){
                        Empleado empleadoAlta = new Empleado(nombre, sexo, fechaCon, sueldo);
                        empleados.add(empleadoAlta);
                        System.out.println("Se ha dado de alta un empleado...");
                    }else if (opcion == 'J'){
                        System.out.print("\nIntroduce dept.: ");
                        departamento = scanner.nextLine();
                        Jefe jefeAlta = new Jefe(nombre, sexo, fechaCon, sueldo, departamento);                        
                        empleados.add(jefeAlta);
                        System.out.println("Se ha dado de alta un Jefe...");
                    }
                    break;

                default:
                    System.out.println("Opción errónea. Escoge E/J/V");
            }
            
        }while(opcion != 'V');
        
    }

    public static void listarEmpleados() {
        System.out.println("\n\t*** L I S T A R   E M P L E A D O S ***");
        System.out.println("\n\t---------------------------------------");
        empleados.forEach((empleado) -> {
            System.out.println(empleado);
        }); 
    }

    public static void grabarEmpleados() {
        System.out.println("\n\t*** G R A B A R   E M P L E A D O S ***");
        System.out.println("\n\t---------------------------------------");
        try(FileOutputStream fos = new FileOutputStream("empleados.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(empleados);
        } catch (FileNotFoundException ex) {
            System.err.println("Error de acceso al fichero empleados.dat");                   
        } catch (IOException ex) {
            System.err.println("Error al grabar los empleados: ");
            ex.printStackTrace();
        }
    }

    public static void leerEmpleados() {
        System.out.println("\n\t*** R E C U P E R A R   E M P L E A D O S ***");
        System.out.println("\n\t---------------------------------------------");
        try(InputStream fis = new FileInputStream("empleados.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)){
            empleados = (List<Empleado>) ois.readObject();
            System.out.println("\nEmpleados leídos correctamente. Pulse <Enter>");
            scanner.nextLine();
        }catch(IOException | ClassNotFoundException ioe){
            System.out.println("Error al deserializar: " + ioe.getMessage());
        }
    }
}
