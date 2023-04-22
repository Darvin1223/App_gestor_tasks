package gestor_app.Model;

import gestor_app.Connection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void showAllTask(){
        ConnectionDB connectionDB = new ConnectionDB();
        ResultSet rs= null;
        try(Connection connection= connectionDB.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "SELECT * FROM Task";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Title: " + rs.getString("nombre_task"));
                    int status = rs.getInt("estado_task");
                    if(status != 0){
                        System.out.println("Status: Completada");
                    }else{
                        System.out.println("Status: Incompleta");
                    }
                }
                System.out.println("\n");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void ahowATask(Task task){

    }

    public static void updateATask(Task task){

    }

    public static void deleteATask(Task task){

    }

    public static void deleteAllTask(Task task){

    }
}
