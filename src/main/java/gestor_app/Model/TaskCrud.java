package gestor_app.Model;

import gestor_app.Connection.ConnectionDB;
import gestor_app.UIMenu.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
                    System.out.println("\n");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Title: " + rs.getString("nombre_task"));
                    int status = rs.getInt("estado_task");
                    if(status != 0){
                        System.out.println("Status: Completada");
                    }else{
                        System.out.println("Status: Incompleta");
                    }
                    System.out.println("\n");
                }
                System.out.println("\n");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void showATask(int id){
        ConnectionDB connectionDB = new ConnectionDB();
        ResultSet rs = null;
        int option;
        try(Connection connection = connectionDB.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "SELECT * FROM Task WHERE id = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,id);
                rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Title: " + rs.getString("nombre_task"));
                    System.out.println("Description: " + rs.getString("descricion_task"));
                   int status = rs.getInt("estado_task");
                    System.out.println(status != 0 ? "Status: Complete" : "Status: incomplete");
                }
                System.out.println("\n");

                System.out.println("Do you want to update this task");
                System.out.println("1. Yes \n" + "2. No");
                Scanner sc = new Scanner(System.in);
                option = sc.nextInt();
                if(option == 1){
                    Menu.menuTaskUpdate(id);
                }


            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void updateATask(int id, int opt, Task task){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.get_connection()){
            PreparedStatement ps = null;
            switch (opt){
                case 1:
                    try{
                        String query = "UPDATE Task SET nombre_task = ?, descripcion_task = ?, estado_task = ? WHERE id = ?";
                        boolean status = task.isStatus();
                        ps = connection.prepareStatement(query);
                        ps.setString(1,task.getTitleOfTask());
                        ps.setString(2,task.getDescription());
                        if(status){
                            ps.setInt(3,1);
                        }else{
                            ps.setInt(3,0);
                        }
                        ps.setInt(4,id);
                        try{
                            ps.executeUpdate();
                            System.out.println("Data update");
                        }catch (SQLException exc){
                            System.out.println("Data not update");
                            System.out.println(exc);
                        }
                    }catch (SQLException ex){
                        System.out.println(ex);
                    }
                    break;
                case 2:
                    try{
                        String query = "UPDATE Task SET nombre_task = ?WHERE id = ?";

                        ps = connection.prepareStatement(query);
                        ps.setString(1,task.getTitleOfTask());
                       ps.setInt(2,id);

                        try{
                            ps.executeUpdate();
                            System.out.println("Data update");
                        }catch (SQLException exc){
                            System.out.println("Data not update");
                            System.out.println(exc);
                        }
                    }catch (SQLException ex){
                        System.out.println(ex);
                    }
                    break;
                case 3:
                    try{
                        String query = "UPDATE Task SET descricion_task = ?WHERE id = ?";

                        ps = connection.prepareStatement(query);
                        ps.setString(1,task.getDescription());
                        ps.setInt(2,id);

                        try{
                            ps.executeUpdate();
                            System.out.println("Data update");
                        }catch (SQLException exc){
                            System.out.println("Data not update");
                            System.out.println(exc);
                        }
                    }catch (SQLException ex){
                        System.out.println(ex);
                    }
                    break;
                case 4:
                    try{
                        String query = "UPDATE Task SET estado_task = ?WHERE id = ?";
                        boolean status = task.isStatus();
                        ps = connection.prepareStatement(query);
                        if(status){
                            ps.setInt(1,1);
                        }else{
                            ps.setInt(1,0);
                        }
                        ps.setInt(2,id);
                        try{
                            ps.executeUpdate();
                            System.out.println("Data update");
                        }catch (SQLException exc){
                            System.out.println("Data not update");
                            System.out.println(exc);
                        }
                    }catch (SQLException ex){
                        System.out.println(ex);
                    }
                    break;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteATask(int id){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM Task WHERE id = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                try{
                    ps.executeUpdate();
                    System.out.println("Deleted it!");
                }catch (SQLException exc){
                    System.out.println(exc);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("\n");
    }

    public static void deleteAllTask(){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM Task";
                ps = connection.prepareStatement(query);

                try{
                    ps.executeUpdate();
                    System.out.println("All data deleted!");
                    Menu.showMenu();
                }catch (SQLException exc){
                    System.out.println(exc);
                }
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        System.out.println("\n");
    }
}
