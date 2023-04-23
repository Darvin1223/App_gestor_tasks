package gestor_app.Model;

import java.util.Scanner;

public class TaskServices {
    public static void addDataTask(){

        Scanner sc = new Scanner(System.in);
        String title;
        String description;
        boolean status = false;
        System.out.println("Add the task'name");
        title = sc.nextLine();
        System.out.println("\n");
        System.out.println("Add the description about the task");
        description = sc.nextLine();
        Task task = new Task();
        task.setTitleOfTask(title);
        task.setDescription(description);
        task.setStatus(status);
        System.out.println("\n");
        TaskCrud.addNewTask(task);

    }
    public static void updateADataTask(int id, int opt){
        
        TaskCrud.updateATask(id,opt);
    }

    public static void showAllDataTaks(){
        TaskCrud.showAllTask();
    }

    public static void showADataTask(){
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Select a task");
        id = sc.nextInt();
        TaskCrud.showATask(id);
        System.out.println("\n");
    }

    public static void deleteADataTask(){
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("Select a task that you want delete:");
        id = sc.nextInt();
        TaskCrud.deleteATask(id);

    }

}


