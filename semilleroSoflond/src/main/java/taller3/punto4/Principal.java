package taller3.punto4;

public class Principal {
    public static void main(String[] args) {
        /*
         * Instanciamos un Banco y le damos un nombre
         */
        Banco banco = new Banco("BancoFake");


        /*
         * Se crea una cuenta de ahorros y corriente recibiendo los nombres de
         * los propietarios como parametros
         */
        Cuenta cuentaA = new CuentaAhorro("Juan Gonzalez");
        Cuenta cuentaB = new CuentaCorriente("Pedro Luna");


        /*
         * Se agregan la cuentas corrientes y de ahorros a la lista de cuentas del banco
         */
        banco.addCuenta(cuentaA);
        banco.addCuenta(cuentaB);

        /*
         * Se muestan las diferentes cuentas que tiene el banco en su lista
         */
        banco.mostrarCuentas();
        System.out.println("\n");

        /*
         * Se realiza downcasting para la variable cuentaA
         */
        CuentaAhorro cuentaA1 = (CuentaAhorro) cuentaA;


        /*
         * Pruebas de Escritorio:
         *
         * Deposito en Cuenta de Ahorro:
         */

        System.out.println("Saldo de la cuenta antes del deposito");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        System.out.println("Cantidad del numero de depositos antes de realizar el deposito");
        System.out.println("Depositos: " + cuentaA1.getNumeroDeDepositos());
        // Se realiza un deposito de 5000
        banco.depositar(cuentaA,5000);
        System.out.println("Numero de depositos");
        System.out.println("Depositos: " + cuentaA1.getNumeroDeDepositos());
        banco.depositar(cuentaA,5000);
        System.out.println("Numero de depositos");
        System.out.println("Depositos: " + cuentaA1.getNumeroDeDepositos());
        banco.depositar(cuentaA,5000);
        System.out.println("Numero de depositos");
        System.out.println("Depositos: " + cuentaA1.getNumeroDeDepositos());
        /*
         * Muestra el saldo luego de los depositos realizados, comprobando que para cada uno de  los dos primeros
         * depositos se fue agregado un saldo extra de 0.5%
         */
        System.out.println("Saldo luego de los tres depositos: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());

        System.out.println("\n");

        /*
         * Pruebas de Escritorio:
         *
         * Retiro en Cuenta de Ahorro:
         */
        System.out.println("Saldo de la cuenta antes del retiro: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        // Retiro del monto ingresado
        banco.retirar(cuentaA,1000);
        System.out.println("Saldo de la cuenta despues del retiro: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        banco.retirar(cuentaA,1000);
        System.out.println("Saldo de la cuenta despues del retiro: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        banco.retirar(cuentaA,1000);
        System.out.println("Saldo de la cuenta despues del retiro: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        banco.retirar(cuentaA,2000);
        /*
        * Luego del tercer retiro los proximos retiros restan un 1% del valor que retiran
         */
        System.out.println("Saldo de la cuenta despues del 4to retiro: ");
        System.out.println("Saldo: " + cuentaA.getSaldo());
        System.out.println("Numero de retiros realizados: ");
        System.out.println(cuentaA.getNumeroDeRetiros());

        /*
        * Prueba de escritorio:
        *
        * Retiro Monto Mayor al saldo
         */
        // Se intenta retirar un monto mayor al saldo de la cuenta, mostrando el mensaje de la excepcion controlada
        banco.retirar(cuentaA,12000);

        System.out.println("\n");

        /*
        * Prueba de escritorio:
        *
        * retiros en cuenta corriente
         */
        banco.depositar(cuentaB,20000);
        System.out.println("Saldo de la cuenta antes del retiro: ");
        System.out.println("Saldo: " + cuentaB.getSaldo());
        // Se hacen 5 Retiros
        banco.retirar(cuentaB,2000);
        banco.retirar(cuentaB,2000);
        banco.retirar(cuentaB,2000);
        banco.retirar(cuentaB,2000);
        banco.retirar(cuentaB,2000);
        System.out.println("Saldo de la cuenta despues de 5 retiros:  ");
        System.out.println("Saldo: " + cuentaB.getSaldo());
        // Se intenta realiza el 6to retiro, mostrando el mensaje de la excepcion controlada
        banco.retirar(cuentaB,2000);

    }
}
