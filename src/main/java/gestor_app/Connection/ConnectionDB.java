package gestor_app.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection get_connection(){

        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestor_tareas","darvin","");

        }catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println(e);
        }

        return conection;
    };

}
