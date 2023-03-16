package punto3;

public class Inmuebles {

    private int identificador;
    private int area;
    private String direccion;

    private float valor;

    private float valorPorMetro;

    public Inmuebles(int identificador, int area, String direccion) {
        this.identificador = identificador;
        this.area = area;
        this.direccion = direccion;
    }
    private void calcularValor(){
        valor = area * valorPorMetro;
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

    public float getValor() {
        return valor;
    }

    public void setValorPorMetro(float valorPorMetro) {
        this.valorPorMetro = valorPorMetro;
        calcularValor();
    }
}
