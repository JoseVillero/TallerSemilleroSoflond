package taller3.punto4.entity;

public abstract class Cuenta {
    private String numeroDeCuenta;
    private  double saldo;
    private String propietario;
    private int numeroDeRetiros;

    public Cuenta(String propietario) {
        this.propietario = propietario;
        /**
         * Numero de Cuenta, con la primera inicial del propietario y el numero hash.
         */
        numeroDeCuenta = propietario.substring(0,1).toUpperCase() + this.hashCode();
        /**
         * Numero de cuenta instanciado en 0
         */
        saldo = 0;
        numeroDeRetiros = 0;
    }
    public void depositar(double monto){
        saldo += monto;
    }
    public void retirar(double monto){
        try{
            if(validarMonto(monto)){
                saldo -= monto;
            }
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    private boolean validarMonto(double monto){
        if(monto > saldo){
            throw new IllegalArgumentException("El monto a retirar debe ser menor al saldo de la cuenta");
        }
        return true;
    }
    public double getSaldo() {
        return saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public int getNumeroDeRetiros() {
        return numeroDeRetiros;
    }
    public void addNumeroDeRetiros() {
        numeroDeRetiros++;
    }
    @Override
    public String toString() {
        return "{" +
                "numeroDeCuenta='" + numeroDeCuenta + '\'' +
                ", saldo=" + saldo +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
