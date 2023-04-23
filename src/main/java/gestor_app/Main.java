package gestor_app;

import gestor_app.Model.User;
import gestor_app.UIMenu.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my app");
        System.out.println("\n");
        System.out.println("This is a TO-DO app");
        System.out.println("Select an option \n");
//        User user = new User("Darvin Rodriguez", "darvin.rod10@gmail.com","Adriana");
        Menu.showMenu();
    }
}