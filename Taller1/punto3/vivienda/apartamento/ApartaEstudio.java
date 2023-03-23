package taller1.punto3.vivienda.apartamento;

public class ApartaEstudio extends Apartamento{

    public ApartaEstudio(int identificador, int area, String direccion, int numeroBanios, float valorAdministracion) {
        super(identificador, area, direccion, 1, numeroBanios, valorAdministracion);
        setVALOR_POR_METRO(1500000);
    }
}
