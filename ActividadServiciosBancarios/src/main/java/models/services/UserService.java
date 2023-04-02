package models.services;

import models.entities.User;
import repository.UserRepository;

import java.util.List;
import java.util.Map;

public class UserService  {

    UserRepository userRepository = new UserRepository();

    public UserService() {
    }

    public void guardar(Map datos) {
        String nombre = (String) datos.get("NOMBRE");
        String apellido = (String) datos.get("APELLIDO");
        String cedula = (String) datos.get("CEDULA");
        int id = (int) datos.get("ID");


        User newUser = new User(id,nombre,apellido,cedula);
        userRepository.guardar(newUser);
    }

    public List<?> obtenerTodo(){
        return userRepository.listar();
    }
    public User buscar(String identificador) throws Exception{
        Object user = userRepository.buscar(identificador);
        if (user == null){
            throw new Exception("No se encontro el usuario");
        }
        return (User) user;
    }

    public void actualizar(Map datos){
        String nombre = (String) datos.get("NOMBRE");
        String apellido = (String) datos.get("APELLIDO");
        String cedula = (String) datos.get("CEDULA");
        int id = (int) datos.get("ID");

        User newUser = new User(id,nombre,apellido,cedula);
        userRepository.actualizar(newUser);
    }
    public void eliminar(String identificador) {
        userRepository.eliminar(identificador);
    }

}
