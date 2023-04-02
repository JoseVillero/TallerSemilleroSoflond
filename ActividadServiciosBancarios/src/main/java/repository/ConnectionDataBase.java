package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDataBase {

    public ConnectionDataBase(){

    }
    public Connection getConexion(){
        Connection con = null;
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            con = DriverManager.getConnection("jdbc:sqlite:Banco.db");
            createTables(con);
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    private void createTables(Connection connection) throws SQLException{
        String tableUsuarios = """
                CREATE TABLE IF NOT EXISTS USUARIOS(
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                NOMBRE TEXT NOT NULL,
                APELLIDO TEXT NOT NULL,
                CEDULA TEXT NOT NULL UNIQUE
                );
                """;

        String tableCuentas = """
                CREATE TABLE IF NOT EXISTS CUENTAS(
                 ID INTEGER PRIMARY KEY AUTOINCREMENT,
                 NUMERO_CUENTA TEXT NOT NULL UNIQUE,
                 SALDO REAL NOT NULL,
                 TIPO_CUENTA TEXT NOT NULL,
                 ID_USUARIO INTEGER NOT NULL,
                FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID)
                );""";
        String tableTransacciones = """
                         CREATE TABLE IF NOT EXISTS TRANSACCIONES(
                         ID INTEGER PRIMARY KEY AUTOINCREMENT,
                         FECHA TEXT NOT NULL,
                         HORA TEXT NOT NULL,
                         TIPO_TRANSACCION TEXT NOT NULL,
                         MONTO REAL NOT NULL,
                         ID_CUENTA INTEGER NOT NULL,
                         TIPO_CUENTA_DESTINO TEXT,
                         FOREIGN KEY(ID_CUENTA) REFERENCES CUENTAS(ID)
                        );""";

        Statement statementTable = connection.createStatement();
        statementTable.execute(tableUsuarios);
        statementTable.execute(tableCuentas);
        statementTable.execute(tableTransacciones);
    }

}
