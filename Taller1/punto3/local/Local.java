package punto3.local;

import punto3.Inmuebles;

public class Local extends Inmuebles {

    private Localizacion localizacion;

    public Local(int identificador, int area, String direccion, Localizacion localizacion) {
        super(identificador, area, direccion);
        this.localizacion = localizacion;
    }
}
