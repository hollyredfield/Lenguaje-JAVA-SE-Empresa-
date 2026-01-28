import java.util.Date;

public class Empleado extends Persona {
    private String nss; // número de la seguridad social
    private int numEmpleado;
    private Date fechaContratacion;
    private double irpf;
    private String cargo;
    private double sueldo;

    // Constructor completo (como tenías antes, ahora con Date)
    public Empleado(String nombre, char sexo, String dni, Date fechaNac,
                    String nss, int numEmpleado, Date fechaContratacion,
                    double irpf, String cargo, double sueldo) {
        super(nombre, sexo, dni, fechaNac);
        setNss(nss);
        setNumEmpleado(numEmpleado);
        setFechaContratacion(fechaContratacion);
        setIrpf(irpf);
        setCargo(cargo);
        setSueldo(sueldo);
    }

    // Constructor sencillo para pruebas: no pide Date al crear
    public Empleado(String nombre, char sexo, String dni, double sueldo) {
        super(nombre, sexo, dni, new Date()); // usa la fecha actual como fechaNac
        this.nss = "";
        this.numEmpleado = 1;
        this.fechaContratacion = new Date(); // fecha por defecto
        this.irpf = 0.0;
        this.cargo = "";
        setSueldo(sueldo);
    }

    // Getters
    public String getNss() { return nss; }
    public int getNumEmpleado() { return numEmpleado; }
    public Date getFechaContratacion() { return fechaContratacion; }
    public double getIrpf() { return irpf; }
    public String getCargo() { return cargo; }
    public double getSueldo() { return sueldo; }

    // Setters simples
    public void setNss(String nss) {
        if (nss == null) nss = "";
        this.nss = nss.trim();
    }

    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado <= 0) {
            throw new IllegalArgumentException("Número de empleado debe ser positivo");
        }
        this.numEmpleado = numEmpleado;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        if (fechaContratacion == null) {
            throw new IllegalArgumentException("Fecha de contratación no puede ser null");
        }
        this.fechaContratacion = fechaContratacion;
    }

    public void setIrpf(double irpf) {
        if (irpf < 0.0 || irpf > 100.0) {
            throw new IllegalArgumentException("IRPF debe estar entre 0 y 100");
        }
        this.irpf = irpf;
    }

    public void setCargo(String cargo) {
        if (cargo == null) cargo = "";
        this.cargo = cargo.trim();
    }

    public void setSueldo(double sueldo) {
        if (sueldo < 0.0) {
            throw new IllegalArgumentException("Sueldo no puede ser negativo");
        }
        this.sueldo = sueldo;
    }

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