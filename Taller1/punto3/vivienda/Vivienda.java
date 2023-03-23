package taller1.punto3.vivienda;

import taller1.punto3.Inmuebles;

public class Vivienda extends Inmuebles {

    private int numeroHabitaciones;
    private int numeroBanios;

    public Vivienda(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios) {
        super(identificador, area, direccion);
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanios = numeroBanios;
    }
}
