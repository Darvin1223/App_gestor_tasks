package gestor_app.Model;

import gestor_app.UIMenu.Menu;

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
        Scanner sc = new Scanner(System.in);
        Task task = new Task();

            String title;
            String description;
            int status;


        switch (opt){
            case 1:
                System.out.println("New title name");
                title = sc.nextLine();
                System.out.println("\n");
                System.out.println("New description");
                description = sc.nextLine();
                System.out.println("\n");
                System.out.println("Change the status");
                System.out.println("1. Completed \n" + "2. Incomplete");
                status = sc.nextInt();
                task.setTitleOfTask(title);
                task.setDescription(description);
                if(status == 1){
                    task.setStatus(true);
                }else{
                    task.setStatus(false);
                }
                TaskCrud.updateATask(id,opt,task);
                break;
            case 2:
                System.out.println("New title name");
                title = sc.nextLine();
                task.setTitleOfTask(title);
                TaskCrud.updateATask(id,opt,task);
                break;
            case 3:
                System.out.println("New description");
                description = sc.nextLine();
                task.setDescription(description);
                TaskCrud.updateATask(id,opt,task);
                break;
            case 4:
                System.out.println("Change the status");
                System.out.println("1. Completed \n" + "2. Incomplete");
                status = sc.nextInt();
                if(status == 1){
                    task.setStatus(true);
                }else{
                    task.setStatus(false);
                }
                TaskCrud.updateATask(id,opt,task);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opt);
        }

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

    public static void deleteAllDataTask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("All data will be deleted");

        int opt;
        do{
            System.out.println("Are you sure?");
            System.out.println("1. Yes \n" + "2. No \n" + "3. Back \n" + "0. Exit \n");
            opt = sc.nextInt();

            switch (opt){
                case 1:
                    TaskCrud.deleteAllTask();
                    break;
                case 2:
                    System.out.println("Ok!!");
                    Menu.showMenu();
                    break;
                case 3:
                    Menu.showMenu();
                    break;
                default:
                    opt = 0;
                    break;
            }
        }while (opt != 0);

    }

}


