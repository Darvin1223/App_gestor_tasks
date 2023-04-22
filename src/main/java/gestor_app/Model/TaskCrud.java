package gestor_app.Model;

import gestor_app.Connection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskCrud {
    public static void addNewTask(Task task){
        ConnectionDB connectionDB = new ConnectionDB();

        try(Connection connection = connectionDB.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO Task (nombre_task,descricion_task,estado_task) VALUES (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, task.getTitleOfTask());
            ps.setString(2, task.getDescription());
            ps.setBoolean(3, task.isStatus());
               try{
                   ps.executeUpdate();
               }catch (SQLException exc){
                   System.out.println(exc);
               }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){

        }
    }
}
