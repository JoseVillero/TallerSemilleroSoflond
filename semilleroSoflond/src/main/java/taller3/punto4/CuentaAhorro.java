package taller3.punto4;

public class CuentaAhorro extends Cuenta{

    private int numeroDeDepositos;
    private static final int PROMO_RETIRO = 3;
    private static final int PROMO_DEPOSITO = 2;
    private static final double PORC_VALOR_RETIRO = 0.01;
    private static final double PORC_VALOR_DEPOSITO = 0.005;
    public CuentaAhorro(String propietario) {
        super(propietario);
        numeroDeDepositos = 0;
    }
    public int getNumeroDeDepositos() {
        return numeroDeDepositos;
    }
    @Override
    public void depositar(double monto) {
        if (numeroDeDepositos < PROMO_DEPOSITO) {
            double adicion = monto * PORC_VALOR_DEPOSITO;
            monto += adicion;
        }
        super.depositar(monto);
        numeroDeDepositos++;
    }
    @Override
    public void retirar(double monto) {
        if (getNumeroDeRetiros() >= PROMO_RETIRO) {
            double comision = monto * PORC_VALOR_RETIRO;
            monto += comision;
        }
        super.retirar(monto);
        addNumeroDeRetiros();
    }
    @Override
    public String toString() {
        return "Tipo de Cuenta: " + this.getClass().getSimpleName() + " " + super.toString();

    }
}
