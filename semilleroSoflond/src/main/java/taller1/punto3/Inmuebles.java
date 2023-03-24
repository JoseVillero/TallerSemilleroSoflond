package taller1.punto3;

public abstract class Inmuebles {

    private int identificador;
    private int area;
    private String direccion;

    private float valor;


    private float VALOR_POR_METRO;


    public Inmuebles(int identificador, int area, String direccion) {
        this.identificador = identificador;
        this.area = area;
        this.direccion = direccion;
        calcularValor();
    }
    private void calcularValor(){
        valor = area * VALOR_POR_METRO;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getArea() {
        return area;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setVALOR_POR_METRO(float VALOR_POR_METRO) {
        this.VALOR_POR_METRO = VALOR_POR_METRO;
    }

    public float getValor() {
        return valor;
    }

}
