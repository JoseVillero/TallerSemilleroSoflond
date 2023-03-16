package punto3.local;

public class Oficina extends Local{

    private boolean esDelGobierno;

    public Oficina(int identificador, int area, String direccion, Localizacion localizacion, boolean esDelGobierno) {
        super(identificador, area, direccion, localizacion);
        this.esDelGobierno = esDelGobierno;
    }
}
