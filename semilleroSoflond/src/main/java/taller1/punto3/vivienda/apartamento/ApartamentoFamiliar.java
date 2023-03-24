package taller1.punto3.vivienda.apartamento;

public class ApartamentoFamiliar extends Apartamento{

    public ApartamentoFamiliar(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios, float valorAdministracion) {
        super(identificador, area, direccion, numeroHabitaciones, numeroBanios, valorAdministracion);
        setVALOR_POR_METRO(2000000);
    }
}
