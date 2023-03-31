package taller3.punto4.repository;

import taller3.punto4.entity.Cuenta;

import java.util.List;

public interface Repositorio {

    void guardar (Cuenta cuenta);
    void buscar (int id);
    void buscar (Cuenta cuenta);
    void buscar (String numeroDeCuenta);
    boolean eliminar (int Id);
    boolean actualizar (String propietario);
    List<String> listar();


}
