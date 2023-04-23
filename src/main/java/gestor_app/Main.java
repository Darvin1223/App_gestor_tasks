package gestor_app;
import javax.swing.JOptionPane;
import gestor_app.Model.User;
import gestor_app.UIMenu.Menu;

public class Main {
    public static void main(String[] args) {
         JOptionPane.showMessageDialog(null,
                "This is a TO-DO app.\n Select an option",
                "Welcome to my app \n" ,
                JOptionPane.PLAIN_MESSAGE);


        System.out.println("Welcome to my app");
        System.out.println("\n");
        System.out.println("This is a TO-DO app");
        System.out.println("Select an option \n");
//        User user = new User("Darvin Rodriguez", "darvin.rod10@gmail.com","Adriana");
        Menu.showMenu();
    }
}