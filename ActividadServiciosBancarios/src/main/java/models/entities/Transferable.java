package models.entities;

import models.entities.AccountTypes.AccountType;

public interface Transferable {

    void depositar(double monto);
    void retirar(double monto);
    void trasferir(AccountType tipo_cuenta, double monto);
}
