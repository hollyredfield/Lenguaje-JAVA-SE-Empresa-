public final class Fecha {
    private final int dia;
    private final int mes;
    private final int anio;

    public Fecha(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes no válido");
        }
        if (dia < 1 || dia > 31) { // validación simple (no contempla meses con menos de 31 días)
            throw new IllegalArgumentException("Día no válido");
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }



    public static void main (String ... xd) {
        Fecha f = new Fecha(1, 11, 2009);
        System.out.println(f);
    }
}