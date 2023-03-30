package taller3.punto4;

public class CuentaCorriente extends Cuenta{

    private static final int MAX_RETIRO = 5;

    public CuentaCorriente(String propietario) {
        super(propietario);
    }

    @Override
    public void retirar(double monto) {
        try{
            if (validarNumeroDeRetiros()){
                super.retirar(monto);
                addNumeroDeRetiros();
            }
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
    private boolean validarNumeroDeRetiros(){
        if (getNumeroDeRetiros() >= MAX_RETIRO) {
            throw new IllegalArgumentException("Ha excedido el numero de retiros permitidos: 5 ");
        }
        return true;
    }
    @Override
    public String toString() {
        return "Tipo de Cuenta: " + this.getClass().getSimpleName() + " " + super.toString();

    }

}
