package gestor_app.UIMenu;

import gestor_app.Model.TaskServices;

import java.util.Scanner;

public class Menu {

    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Add Task \n" + "2. Show all \n" + "3. Update taks \n" + "4. Delete taks \n" + "0. Exit \n");
            option = sc.nextInt();
            switch (option){
                case 1:
                    TaskServices.addDataTask();
                    break;
                case 2:
                    TaskServices.showAllTaks();
                    break;
                default:
                    break;
            }
        }while (option != 0);
    }


}
