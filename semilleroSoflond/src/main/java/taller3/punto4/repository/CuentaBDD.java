package taller3.punto4.repository;

import taller3.punto4.entity.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaBDD implements Repositorio {
    private Conexion conexion;
    private Connection con;

    public CuentaBDD() {
        this.conexion = new Conexion();
        this.con = conexion.getConexion();
    }

    @Override
    public void guardar(Cuenta cuenta) {
        try {
            String sql = "INSERT INTO Cuentas (NumeroDeCuenta, Saldo, Propietario, NumeroDeRetiros)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, cuenta.getNumeroDeCuenta());
            sentencia.setString(2, String.valueOf(cuenta.getSaldo()));
            sentencia.setString(3, cuenta.getPropietario());
            sentencia.setString(4, String.valueOf(cuenta.getNumeroDeRetiros()));
            sentencia.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getErrorCode() + " " + e.getMessage());
        }
    }

    @Override
    public void buscar(int id) {
        try {
            String sql = "SELECT * FROM Cuentas WHERE Id = " + id;
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            System.out.println(busqueda(rs));
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override
    public void buscar(Cuenta cuenta){
        buscar(cuenta.getNumeroDeCuenta());
    }

    @Override
    public void buscar(String numeroDeCuenta) {
        try {
            String sql = "SELECT * FROM Cuentas WHERE NumeroDeCuenta = " + numeroDeCuenta;
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            System.out.println(busqueda(rs));
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public boolean eliminar(int Id) {
        boolean borrado = false;
        try {
            String sql = "DELETE FROM Cuentas WHERE Id = " + Id;
            Statement sentencia = con.createStatement();
            sentencia.execute(sql);
            borrado = true;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return borrado;
    }

    @Override
    public boolean actualizar(String propietario) {
        boolean actualizado = false;
        try {
            String sql = "UPDATE Cuentas SET propietario = " + propietario + " WHERE Id = " + 1 ; //TODO = realizar metodo de busqueda que retorne el id
            Statement sentencia = con.createStatement();
            sentencia.execute(sql);
            actualizado = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizado;
    }

    @Override
    public List<String> listar() {
        List<String> lista = null;
        try {
            String sql = "SELECT * FROM Cuentas;";
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            lista = busqueda(resultado);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    private List<String> busqueda(ResultSet resultado) throws SQLException {
        List<String> lista = new ArrayList<>();
            if (resultado != null) {
                while (resultado.next()) {
                    String cuenta = "";
                    cuenta = "Id: " + resultado.getInt("Id") +
                            " || Numero de Cuenta: " + resultado.getString("NumeroDeCuenta") +
                            " || Saldo: " + resultado.getDouble("Saldo") + " || Propietario: " +
                            resultado.getString("Propietario") + " || Numero de retiros: " +
                            resultado.getInt("NumeroDeRetiros");
                    lista.add(cuenta);
                }
            }
            return lista;
    }
}
