package punto2;

public class CuentaCorriente extends Cuenta{

    float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual, float sobregiro) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void consignar(float monto) {
        float saldoNuevo = getSaldo() - monto;
        if(saldoNuevo < 0){
            sobregiro -= saldoNuevo;
            setSaldo(0);
        } else {
            super.retirar(monto);
        }
    }

    @Override
    public void retirar(float monto) {
        float resto = sobregiro - monto;
        if(sobregiro > 0){
            if(resto > 0){
                sobregiro = 0;
                setSaldo(resto);
            } else {
                sobregiro = -resto;
                setSaldo(0);
            }
        } else {
            super.consignar(monto);
        }
    }
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }
}
