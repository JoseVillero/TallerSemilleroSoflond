package taller3.punto4.repository;

import taller3.punto4.entity.Cuenta;

import java.util.List;

public interface Persistencia {

    void guardar (Cuenta cuenta);
    void eliminar (Cuenta cuenta, int id);
    void actualizar (Cuenta cuenta, String columna, String valor, int id);
    List<Cuenta> listar();


}
