import java.util.Date;

public class Jefe extends Empleado {
    private String departamento;
    private int numSubordinados;

    public Jefe(String nombre, char sexo, String dni, Date fechaNac,
                String nss, int numEmpleado, Date fechaContratacion,
                double irpf, String cargo, double sueldo,
                String departamento, int numSubordinados) {
        super(nombre, sexo, dni, fechaNac, nss, numEmpleado, fechaContratacion, irpf, cargo, sueldo);
        setDepartamento(departamento);
        setNumSubordinados(numSubordinados);
    }

    // Constructor sencillo para pruebas: usa el constructor sencillo de Empleado
    public Jefe(String nombre, char sexo, String dni, double sueldo) {
        super(nombre, sexo, dni, sueldo);
        this.departamento = "General";
        this.numSubordinados = 0;
    }

    public String getDepartamento() { return departamento; }
    public int getNumSubordinados() { return numSubordinados; }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Departamento no puede ser null o vacío");
        }
        this.departamento = departamento.trim();
    }

    public void setNumSubordinados(int numSubordinados) {
        if (numSubordinados < 0) {
            throw new IllegalArgumentException("Número de subordinados no puede ser negativo");
        }
        this.numSubordinados = numSubordinados;
    }

    @Override
    public String toString() {
        return "Jefe{" + super.toString() +
                ", departamento='" + departamento + '\'' +
                ", numSubordinados=" + numSubordinados +
                '}';
    }

    // Cambiar sueldo de otro empleado (usa el setter público de Empleado)
    public void setSueldoEmpleado(Empleado empleado, double nuevoSueldo) {
        if (empleado == null) throw new IllegalArgumentException("El empleado no puede ser nulo");
        if (nuevoSueldo <= 0.0) throw new IllegalArgumentException("El sueldo ha de ser mayor que 0");
        empleado.setSueldo(nuevoSueldo);
    }

    // Aumentar sueldo del empleado en xdddddd (mantengo tus nombres)
    public void setSubirSueldoEmpleado(Empleado xd, double xdddddd) {
        if (xd == null) throw new IllegalArgumentException("El empleado no puede ser nulo");
        if (xdddddd <= 0.0) throw new IllegalArgumentException("El valor no ha de ser 0 o negativo");

        double actual = xd.getSueldo();
        double nuevo = actual + xdddddd;

        if (nuevo <= 0.0) throw new IllegalArgumentException("El nuevo sueldo no puede ser 0 o negativo");

        xd.setSueldo(nuevo); // guarda el cambio en la instancia
        System.out.println("Sueldo anterior: " + actual + "\nNuevo sueldo: " + xd.getSueldo());
    }

    // main de prueba (temporal)
    public static void main(String... args) {
        // creamos un empleado con el constructor sencillo (no hace falta crear Date aquí)
        Empleado e = new Empleado("Pepe", 'M', "12345678A", 1200);
        System.out.println("Sueldo inicial empleado Pepe: " + e.getSueldo());

        // creamos jefe con constructor sencillo
        Jefe jefe = new Jefe("Ana", 'F', "87654321B", 3000.0);

        // aumentamos sueldo usando tu método
        jefe.setSubirSueldoEmpleado(e, 200.0);

        System.out.println("Sueldo final empleado Pepe: " + e.getSueldo());
    }
}