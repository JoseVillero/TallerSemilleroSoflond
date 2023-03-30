package taller3.punto4.repository;

import taller3.punto4.entity.Cuenta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CuentaDAO implements Persistencia {
    private Conexion conexion;
    private Connection con;

    public CuentaDAO() {
        this.conexion = new Conexion();
        this.con = conexion.getConexion();
    }

    @Override
    public void guardar(Cuenta cuenta) {
        try {
            String sql = "INSERT INTO Cuentas (NumeroDeCuenta, Saldo, Propietario, NumeroDeRetiros)" +
                    " VALUES ('" + cuenta.getNumeroDeCuenta() + "', '" + cuenta.getSaldo() + "', '" +
                    cuenta.getPropietario() + "', '" + cuenta.getNumeroDeRetiros() + "');";
            Statement sentencia = con.createStatement();
            sentencia.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cuenta cuenta, int id) {
        try{
        String sql = "DELETE FROM Cuentas WHERE Id = " + id;
        Statement sentencia = con.createStatement();
        sentencia.execute(sql);
    } catch(SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    @Override
    public void actualizar(Cuenta cuenta, String columna, String valor, int id) {
        try{
            String sql = "UPDATE Cuentas SET " + columna + "= " + valor +  " WHERE Id = " + id;
            Statement sentencia = con.createStatement();
            sentencia.execute(sql);
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Override
    public List<Cuenta> listar() {
        return null;
    }
}
