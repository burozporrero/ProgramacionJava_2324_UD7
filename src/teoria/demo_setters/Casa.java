package teoria.demo_setters;

import java.util.Objects;

// Revisar como hacemos la comprobación de la excepción en los setter, de forma que en el constructor llamamos al
// setter en lugar de utilizar this.superficie así aseguramos que la restricción se cumple siempre en nuestra clase,
// no solo cuando creamos una nueva instáncia.
public class Casa {
    private String calle;
    private int numero;
    private double superficie;
    private boolean garaje;
    private int edad;
    private static int contador;
    private static final double SUPER_MINI = 43.50;

    public Casa(String calle, int numero, double superficie, boolean garaje, int edad) {
        super();
        setCalle(calle);
        this.numero = numero;
        setSuperficie(superficie);
        this.garaje = garaje;
        setEdad(edad);
        contador++;
    }
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle)throws IllegalArgumentException {
        if(calle == null || calle.isEmpty()){
            throw new IllegalArgumentException("No debe ingrear un valor nulo ni vacío");
        }
        this.calle = calle;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) throws IllegalArgumentException{
        if(superficie >= SUPER_MINI){
            this.superficie = superficie;

        }else throw new IllegalArgumentException("Debe ingresar un valor superior o igual a " + SUPER_MINI);
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws IllegalArgumentException{
        if(edad > 0){
            this.edad = edad;
        } else throw new IllegalArgumentException("Debe ingresar un valor mayor a 0");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return numero == casa.numero && Objects.equals(calle, casa.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, numero);
    }

    @Override
    public String toString() {
        return "Casa{" + contador +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", superficie=" + superficie +
                ", garaje=" + garaje +
                ", edad=" + edad +
                '}';
    }
}
