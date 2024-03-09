import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {


    public Admin(String username, String password) {
        super(username, password);
    }

    public static void showOption() {
        System.out.println("Admin Options:");
        System.out.println("1. Login");
        System.out.println("2. Back");

    }



}

