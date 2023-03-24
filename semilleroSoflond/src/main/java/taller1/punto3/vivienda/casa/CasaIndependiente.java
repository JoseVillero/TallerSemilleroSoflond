package taller1.punto3.vivienda.casa;

public class CasaIndependiente extends CasaUrbana{

    public CasaIndependiente(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios) {
        super(identificador, area, direccion, numeroHabitaciones, numeroBanios);
        setVALOR_POR_METRO(3000000);
    }
}
