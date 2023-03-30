package taller3.punto4.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    public Conexion() {
    }
    public Connection getConexion(){
        Connection con = null;
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            con = DriverManager.getConnection("jdbc:sqlite:Banco.db");
            crearTabla(con);
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    private void crearTabla(Connection con) throws SQLException{
        String tabla = "CREATE TABLE IF NOT EXISTS Cuentas (\n" +
                " Id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " NumeroDeCuenta TEXT NOT NULL UNIQUE,\n" +
                " Saldo REAL NOT NULL,\n" +
                " Propietario TEXT NOT NULL,\n" +
                " NumeroDeRetiros INTEGER NOT NULL" +
                ");";
        Statement sentenciaTabla = con.createStatement();
        sentenciaTabla.execute(tabla);
    }



}