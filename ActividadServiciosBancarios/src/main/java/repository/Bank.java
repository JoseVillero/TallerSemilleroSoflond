package repository;

import models.entities.Account;
import models.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Bank implements Repository{

    private ConnectionDataBase dataBase = new ConnectionDataBase();
    private Connection connection = dataBase.getConexion();

    public Bank() {
    }


    public List<?> listar() {

        List<User> users = new ArrayList<>();

        try {
            String sql = "SELECT * FROM USUARIOS";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    User user = null;
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String cedula = resultSet.getString("cedula");
                    user = new User(id, nombre, apellido, cedula);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Object buscar(String identificacion){
        try {
            String sentenciaSQL = "SELECT * FROM USUARIOS WHERE CEDULA = ?";
            PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);
            sentencia.setString(1, identificacion);
            ResultSet resultadoConsulta = sentencia.executeQuery();
            if (resultadoConsulta != null && resultadoConsulta.next()) {
                User user = null;
                int id = resultadoConsulta.getInt("ID");
                String nombre = resultadoConsulta.getString("NOMBRE");
                String apellido = resultadoConsulta.getString("APELLIDO");
                String cedula = resultadoConsulta.getString("CEDULA");
                user = new User(id,nombre,apellido,cedula);
                return user;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }
    public void guardar(Object objeto) {
        try  {
            User user = (User) objeto;
            String sentenciaSql = "INSERT INTO USUARIOS (ID, NOMBRE, APELLIDO, CEDULA) " +
                    " VALUES('" + user.getId() + "', '" + user.getNombre()
                    + "', " + user.getApellido() + ", '" + user.getCedula() + "');";
            Statement sentencia = connection.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }

    }
    public void eliminar(String identificacion) {
        try {
            String sentenciaSql = "DELETE FROM USUARIOS WHERE ID = '" + identificacion + "';";
            Statement sentencia = connection.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }
    public void actualizar(Object objeto) {
        try {
            User user = (User) objeto;
            String sentenciaSql = "UPDATE USUARIOS SET NOMBRE = '"
                    + user.getNombre() + "', APELLIDO = " + user.getApellido() + ", CEDULA = '"
                    + user.getCedula()+ "' WHERE ID = '" + user.getId() + "';";
            Statement sentencia = connection.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

}
