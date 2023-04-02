package repository;

import models.entities.Account;
import models.entities.User;

import java.util.List;
import java.util.Map;

public interface Repository {

    public List<?> listar();
    public Object buscar(String identificacion);
    public void guardar(Object objeto);
    public void actualizar(Object objeto);
    public void eliminar(String identificacion);






}
