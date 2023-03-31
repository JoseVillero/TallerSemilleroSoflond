package taller3.punto4;

import taller3.punto4.entity.Cuenta;
import taller3.punto4.repository.CuentaBDD;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombreDelBanco;
    private List<Cuenta> cuentas;
    private CuentaBDD baseDeDatos;

    public Banco(String nombreDelBanco){
        this.nombreDelBanco = nombreDelBanco;
        this.cuentas = new ArrayList<>();
        this.baseDeDatos = new CuentaBDD();
    }
    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        baseDeDatos.guardar(cuenta);

    }
    public void buscarEnBaseDeDatos(int idCuenta){
        baseDeDatos.buscar(idCuenta);
    }
    public void buscarEnBaseDeDatos(String numeroDeCuenta){
        baseDeDatos.buscar(numeroDeCuenta);
    }
    public void buscarEnBaseDeDatos(Cuenta cuenta){
        baseDeDatos.buscar(cuenta);
    }
    public void eliminarCuenta(Cuenta cuenta, int Id){
        if(baseDeDatos.eliminar(Id)){
          cuentas.remove(buscarEnLocal(cuenta));
        }
    }
    public void mostrarCuentasEnLocal(){
        for (Cuenta cuenta: cuentas){
            System.out.println(cuenta.toString());
        }
    }
    public void mostrarCuentaEnBaseDeDatos(){
        for (String cuenta: baseDeDatos.listar()){
            System.out.println(cuenta);
        }
    }
    public void actualizarCuenta(Cuenta cuenta, String propietario){
        baseDeDatos.actualizar(propietario);
        Cuenta cuentaAactualizar = buscarEnLocal(cuenta);
        cuentaAactualizar.setPropietario(propietario);
    }
    public void depositar(Cuenta cuenta, double monto){
        cuenta.depositar(monto);
    }
    public void retirar(Cuenta cuenta , double monto){
        cuenta.retirar(monto);
    }
    private Cuenta buscarEnLocal(Cuenta cuenta){
        Cuenta cuentaEncontrada = null;
        int i = 0;
       while(cuenta != cuentaEncontrada && i < cuentas.size()){
           cuentaEncontrada = cuentas.get(i);
           i++;
       }
       return cuentaEncontrada;
    }




}
