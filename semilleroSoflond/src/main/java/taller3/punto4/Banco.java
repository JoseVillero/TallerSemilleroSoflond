package taller3.punto4;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombreDelBanco;
    private List<Cuenta> cuentas;

    public Banco(String nombreDelBanco){
        this.nombreDelBanco = nombreDelBanco;
        this.cuentas = new ArrayList<>();
    }
    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    public void mostrarCuentas(){
        for (Cuenta cuenta: cuentas){
            System.out.println(cuenta.toString());
        }
    }
    public void depositar(Cuenta cuenta, double monto){
        cuenta.depositar(monto);
    }
    public void retirar(Cuenta cuenta , double monto){
        cuenta.retirar(monto);
    }




}
