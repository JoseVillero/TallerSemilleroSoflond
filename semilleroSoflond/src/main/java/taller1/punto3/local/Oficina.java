package taller1.punto3.local;

public class Oficina extends Local{

    private boolean esDelGobierno;

    public Oficina(int identificador, int area, String direccion, Localizacion localizacion, boolean esDelGobierno) {
        super(identificador, area, direccion, localizacion);
        this.esDelGobierno = esDelGobierno;
        setVALOR_POR_METRO(3500000);
    }
}
