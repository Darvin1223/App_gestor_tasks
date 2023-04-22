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
        TaskCrud.addNewTask(task);
    }

    public static void showAllTaks(){
        TaskCrud.showAllTask();
    }
}
