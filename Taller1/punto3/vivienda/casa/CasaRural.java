package punto3.vivienda.casa;

public class CasaRural extends Casa{


    private float distanciaACabecera;
    private float altitud;

    public CasaRural(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios, float distanciaACabecera, float altitud) {
        super(identificador, area, direccion, numeroHabitaciones, numeroBanios);
        this.distanciaACabecera = distanciaACabecera;
        this.altitud = altitud;
    }
}
