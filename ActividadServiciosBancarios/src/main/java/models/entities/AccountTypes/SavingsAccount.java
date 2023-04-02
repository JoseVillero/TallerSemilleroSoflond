package models.entities.AccountTypes;

import models.entities.Account;

public class SavingsAccount extends Account {

    public SavingsAccount(int id_usuario, int idCuenta) {
        super(id_usuario, idCuenta);
        setTipoCuenta(AccountType.CUENTA_DE_AHORRO);
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto);
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
    }

    @Override
    public void trasferir(AccountType tipo_cuenta, double monto) {


    }
}
