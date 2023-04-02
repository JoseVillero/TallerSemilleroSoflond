package models.entities;

import models.entities.AccountTypes.AccountType;
import models.services.TransactionsTypes;

import java.sql.Date;
import java.sql.Time;

public class Transaction {

    private int id;
    private String fecha;
    private String hora;
    private TransactionsTypes transactionType;
    private int id_cuenta;
    private AccountType tipo_cuenta_destino;

    public Transaction(int id, String fecha, String hora, TransactionsTypes transactionType, int id_cuenta, AccountType tipo_cuenta_destino) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.transactionType = transactionType;
        this.id_cuenta = id_cuenta;
        this.tipo_cuenta_destino = tipo_cuenta_destino;
    }
}
