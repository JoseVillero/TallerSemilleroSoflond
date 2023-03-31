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
        String tabla = """
                CREATE TABLE IF NOT EXISTS Cuentas (
                 Id INTEGER PRIMARY KEY AUTOINCREMENT ,
                 NumeroDeCuenta TEXT NOT NULL UNIQUE ,
                 Saldo REAL NOT NULL,
                 Propietario TEXT NOT NULL,
                 NumeroDeRetiros INTEGER NOT NULL);""";
        Statement sentenciaTabla = con.createStatement();
        sentenciaTabla.execute(tabla);
    }



}