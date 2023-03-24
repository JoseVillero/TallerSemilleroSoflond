package taller1.punto2;

public class Cuenta {
    private float saldo;
    private int numeroDeConsignaciones = 0;
    private int numeroDeRetiros = 0;
    private float tasaAnual;
    private float comisionMensual = 0;

    public Cuenta (float saldo, float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }
    public void consignar(float monto){
        saldo += monto;
        numeroDeConsignaciones++;
    }
    public void retirar(float monto){
        float saldoNuevo = saldo - monto;
        if(saldoNuevo >= 0){
            saldo -= monto;
            numeroDeRetiros++;

        } else {
            System.out.println("Operacion no valida");
        }
    }
    public void calcularInteresMenual(){
        float tasaMensual = tasaAnual / 12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;

    }
    public void extractoMensual(){
        saldo -= comisionMensual;
        calcularInteresMenual();

    }

    public int getNumeroDeConsignaciones() {
        return numeroDeConsignaciones;
    }

    public int getNumeroDeRetiros() {
        return numeroDeRetiros;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numeroDeConsignaciones=" + numeroDeConsignaciones +
                ", numeroDeRetiros=" + numeroDeRetiros +
                ", tasaAnual=" + tasaAnual +
                ", comisionMensual=" + comisionMensual +
                '}';
    }

}
