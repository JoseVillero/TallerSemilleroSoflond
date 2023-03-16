package punto2;

public class CuentaAhorro extends Cuenta{
    private boolean estaActiva;

    public CuentaAhorro(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        estaActiva = !(saldo < 10000);
    }
    @Override
    public void retirar(float monto){
        if(estaActiva){
            super.retirar(monto);
        }
    }
    @Override
    public void consignar(float monto){
        if(estaActiva){
            super.consignar(monto);
        }
    }
    @Override
    public void extractoMensual(){
        if(getNumeroDeRetiros() > 4){
            float comisionMensual =  getComisionMensual() + ((getNumeroDeRetiros() - 4) * 1000);
            setComisionMensual(comisionMensual);
        }
        super.extractoMensual();
        if(getSaldo() < 10000){
            estaActiva = false;
        }
    }



}
