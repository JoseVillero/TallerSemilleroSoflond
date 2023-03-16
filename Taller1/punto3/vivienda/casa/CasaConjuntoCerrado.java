package punto3.vivienda.casa;

public class CasaConjuntoCerrado extends CasaUrbana{

    private float valorAdministracion;
    private boolean areasComunes;

    public CasaConjuntoCerrado(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios,
                               float valorAdministracion, boolean areasComunes) {
        super(identificador, area, direccion, numeroHabitaciones, numeroBanios);
        this.valorAdministracion = valorAdministracion;
        this.areasComunes = areasComunes;
    }
}
