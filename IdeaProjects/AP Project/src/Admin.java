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

    public static void choiceDepartement() {
        Scanner scanner = new Scanner(System.in);
        int choiceDepartement = 0;

        while (true) {
            System.out.println("Admin Options:");
            System.out.println("1.MATH ");
            System.out.println("2.PHYSICS ");
            System.out.println("3.CHEMISTERY ");
            System.out.println("4.CIVIL ");
            System.out.println("4.Back ");

            System.out.print("Enter your choice: ");
            choiceDepartement = scanner.nextInt();

            switch (choiceDepartement) {
                case 1:
                    Main.printCourses(Main.mathCourses);

                    break;
                case 2:
                    Main.printCourses(Main.physicCourses);

                    break;
                case 3:
                    Main.printCourses(Main.chemisteryCourses);

                    break;
                case 4:
                    Main.printCourses(Main.civilCourses);

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }


}

