package models.entities;

import models.entities.AccountTypes.AccountType;

public abstract class Account implements Transferable{
    private int id;
    private String numero_cuenta;
    private double saldo;
    private AccountType tipoCuenta;
    private int id_usuario;

    public Account(int id_usuario, int idCuenta){
        this.id = idCuenta;
        this.id_usuario = id_usuario;
        this.tipoCuenta = tipoCuenta;
        /**
         * numero de cuenta harcodeado concatenado al numero de usuario;
         */
        numero_cuenta = "AF133489ID" + id_usuario;
        /**
         * Numero de cuenta instanciado en 0
         */
        saldo = 0;

    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
    }

    @Override
    public void retirar(double monto) {
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


    @Override
    public void trasferir(AccountType tipo_cuenta, double monto) {


    }

    public AccountType getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(AccountType tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getId() {
        return id;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", numero_cuenta='" + numero_cuenta + '\'' +
                ", saldo=" + saldo +
                ", tipoCuenta=" + tipoCuenta +
                ", id_usuario=" + id_usuario +
                '}';
    }

}
