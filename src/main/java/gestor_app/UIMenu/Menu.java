package gestor_app.UIMenu;

import gestor_app.Model.TaskCrud;
import gestor_app.Model.TaskServices;

import java.util.Scanner;

public class Menu {

    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Add Task \n" + "2. Show all \n" + "3. Update taks \n" + "4. Delete taks \n" + "5. Select a task \n" + "6. Delete all task \n" + "0. Exit \n");
            option = sc.nextInt();
            switch (option){
                case 1:
                    TaskServices.addDataTask();

                    break;
                case 2:
                    TaskServices.showAllDataTaks();
                    break;
                case 3:
                    break;
                case 4:
                    TaskServices.deleteADataTask();
                    break;
                case 5:
                    TaskServices.showADataTask();
                    break;
                case 6:
                    TaskServices.deleteAllDataTask();
                    break;
                default:
                    break;
            }
        }while (option != 0);
    }

    public static void menuTaskUpdate(int id){
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Update all information of this task \n" +
                    "2. Update the title of the task \n" +
                    "3. Update the description of the task \n" +
                    "4. Complete the task \n" + "5. Back to menu \n" + "0. Exit");
            option = sc.nextInt();

            switch (option){
                case 1:
                    TaskServices.updateADataTask(id,option);
                    break;
                case 2:
                    TaskServices.updateADataTask(id,option);
                    break;
                case 3:
                    TaskServices.updateADataTask(id,option);
                    break;
                case 4:
                    TaskServices.updateADataTask(id,option);
                    break;
                case 5:
                    showMenu();
                    break;

            }

        }while (option != 0);
    }


}
