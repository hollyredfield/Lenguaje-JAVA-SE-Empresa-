import java.util.Date;

public abstract class Persona {
    private String nombre;
    private char sexo;
    private String dni;
    private Date fechaNac;

    public Persona(String nombre, char sexo, String dni, Date fechaNac) {
        setNombre(nombre);
        setSexo(sexo);
        setDni(dni);
        setFechaNac(fechaNac);
    }

    // Getters
    public String getNombre() { return nombre; }
    public char getSexo() { return sexo; }
    public String getDni() { return dni; }
    public Date getFechaNac() { return fechaNac; }

    // Setters
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null o vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setSexo(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if (sexo != 'M' && sexo != 'F' && sexo != 'O') {
            throw new IllegalArgumentException("Sexo inválido. Use 'M', 'F' u 'O'");
        }
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser null o vacío");
        }
        this.dni = dni.trim();
    }

    public void setFechaNac(Date fechaNac) {
        if (fechaNac == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser null");
        }
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', sexo=" + sexo + ", dni='" + dni + "', fechaNac=" + fechaNac + "}";
    }
}