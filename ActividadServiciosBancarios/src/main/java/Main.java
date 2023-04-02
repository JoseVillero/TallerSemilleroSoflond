

import controllers.UserController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import repository.ConnectionDataBase;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try{

            Server server = new Server(8080);

            ServletHandler handler = new ServletHandler();
            handler.addServletWithMapping(UserController.class, "/*");


            server.setHandler(handler);

            server.start();
            server.join();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
