package models.entities;

import models.entities.AccountTypes.AccountType;

public class User implements Transferable{
    private int id;
    private String nombre, apellido, cedula;

    public User(int id, String nombre, String apellido, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }

    @Override
    public void depositar(double monto) {

    }

    @Override
    public void retirar(double monto) {

    }

    @Override
    public void trasferir(AccountType tipo_cuenta, double monto) {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }
}
