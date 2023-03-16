package punto3.vivienda.apartamento;

import punto3.vivienda.Vivienda;

public class Apartamento extends Vivienda {
    private float valorAdministracion;

    public Apartamento(int identificador, int area, String direccion, int numeroHabitaciones, int numeroBanios, float valorAdministracion) {
        super(identificador, area, direccion, numeroHabitaciones, numeroBanios);
        this.valorAdministracion = valorAdministracion;
    }

    public float getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(float valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }




}
