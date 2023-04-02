package repository;


import java.util.List;
import java.util.Map;

public class UserRepository {

   private Bank bank = new Bank();

    public UserRepository() {
    }
    public Object buscar(String identificacion){
        return bank.buscar(identificacion);
    }
    public void guardar(Object objeto){
        bank.guardar(objeto);
    }
    public void actualizar(Object objeto){
        bank.actualizar(objeto);
    }
    public void eliminar(String identificacion){
        bank.eliminar(identificacion);
    }




    public List<?> listar(){
       return bank.listar();
    }
}
