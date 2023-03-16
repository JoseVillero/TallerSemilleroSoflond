package punto3.local;

public class LocalComercial extends Local{

    private String centroComercial;

    public LocalComercial(int identificador, int area, String direccion, Localizacion localizacion, String centroComercial) {
        super(identificador, area, direccion, localizacion);
        this.centroComercial = centroComercial;
    }
}
