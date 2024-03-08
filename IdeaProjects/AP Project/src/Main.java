import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static User loggedInUser = null;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Department> departments = new ArrayList<>();
    static ArrayList<Course> mathCourses = new ArrayList<>();
    static ArrayList<Course> physicCourses = new ArrayList<>();
    static ArrayList<Course> chemisteryCourses = new ArrayList<>();
    static ArrayList<Course> civilCourses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mathCourses.add(new Course(CourseDepartment.MATH, "linear algebra", 1, "akbari", "20 khordad", "1,3/10_12", CourseType.Takhsossi, 4, 100));
        mathCourses.add(new Course(CourseDepartment.MATH, "discrete mathmathics ", 2, "mani", "21 khordad", "1,3/8_10", CourseType.Takhsossi, 3, 100));
        mathCourses.add(new Course(CourseDepartment.MATH, " dif", 3, "ghajar", "22 khordad", "1,3/13_15", CourseType.Takhsossi, 2, 100));
        departments.add(new Department(CourseDepartment.MATH, mathCourses));

        physicCourses.add(new Course(CourseDepartment.PHYSICS, "Physics1 ", 4, "moghimi", "23 khordad", "0,2/10_12", CourseType.Takhsossi, 4, 100));
        physicCourses.add(new Course(CourseDepartment.PHYSICS, "Physics2", 5, "nasrii", "24 khordad", "0,2/8_10", CourseType.Takhsossi, 3, 100));
        physicCourses.add(new Course(CourseDepartment.PHYSICS, " AzPhysics", 6, "nhani", "25 khordad", "0,2/13_15", CourseType.Takhsossi, 2, 100));
        departments.add(new Department(CourseDepartment.PHYSICS, physicCourses));

        chemisteryCourses.add(new Course(CourseDepartment.CHEMISTERY, " Chemistery1", 7, "amiri", "17 khordad", "4,5/10_12", CourseType.Takhsossi, 4, 100));
        chemisteryCourses.add(new Course(CourseDepartment.CHEMISTERY, " Chemistery2", 8, "sadat", "18 khordad", "4,5/8_10", CourseType.Takhsossi, 3, 100));
        chemisteryCourses.add(new Course(CourseDepartment.CHEMISTERY, " AzChemistery", 9, "naini", "19 khordad", "4,5/13_15", CourseType.Takhsossi, 4, 100));
        departments.add(new Department(CourseDepartment.CHEMISTERY, chemisteryCourses));

        civilCourses.add(new Course(CourseDepartment.CIVIL, "Termo1 ", 10, "sadghi", "17 khordad", "1,3/10_12", CourseType.Takhsossi, 3, 100));
        civilCourses.add(new Course(CourseDepartment.CIVIL, "Termo2", 11, "gholami", "20 khordad", "0,2/8_10", CourseType.Takhsossi, 3, 100));
        civilCourses.add(new Course(CourseDepartment.CIVIL, " Ter&Takhteh", 12, "moradi", "23 khordad", "/13_15", CourseType.Takhsossi, 4, 100));
        departments.add(new Department(CourseDepartment.CIVIL, civilCourses));

        users.add(new Admin("ebi", "123"));
        users.add(new Student("a", "a"));

        int roleChoice = 0;

        while (true) {
            System.out.println("Choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            roleChoice = scanner.nextInt();

            switch (roleChoice) {
                case 1:
                    adminOptions();
                    break;
                case 2:
                    studentOptions();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void adminOptions() {
        Scanner scanner = new Scanner(System.in);
        int adminChoice = 0;

        while (true) {
            Admin.showOption();
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            choiceDepartement();
        }
    }

    public static void studentOptions() {
        Scanner scanner = new Scanner(System.in);
        int studentChoice = 0;

        while (true) {
            System.out.println("Student Options:");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Back");

            System.out.print("Enter your choice: ");
            studentChoice = scanner.nextInt();

            switch (studentChoice) {
                case 1:
                    loginAsStudent();
                    break;
                case 2:
                    signUpAsStudent();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loggedInUser = checkValidLogin(username, password);

        if (loggedInUser != null) {
            System.out.println("Logged in as Admin");
            addCourse();
        } else {
            System.out.println("Invalid username or password!");
        }

    }

    public static void loginAsStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loggedInUser = checkValidLogin(username, password);

        if (loggedInUser != null) {
            System.out.println("Logged in as Student");
            choiceDepartement();
        } else {
            System.out.println("Invalid username or password!");
        }

    }

    public static User checkValidLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public static void signUpAsStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Sign Up");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new Student(username, password));

        System.out.println("Student account created successfully!");

    }

    public static void choiceDepartement() {
        Scanner scanner = new Scanner(System.in);
        int choiceDepartement = 0;

        while (true) {
            System.out.println("Student Options:");
            System.out.println("1.MATH ");
            System.out.println("2.PHYSICS ");
            System.out.println("3.CHEMISTERY ");
            System.out.println("4.CIVIL ");
            System.out.println("4.Back ");

            System.out.print("Enter your choice: ");
            choiceDepartement = scanner.nextInt();

            switch (choiceDepartement) {
                case 1:
                    printCourses(mathCourses);
                    chooseCourse(mathCourses);
                    break;
                case 2:
                    printCourses(physicCourses);
                    chooseCourse(physicCourses);
                    break;
                case 3:
                    printCourses(chemisteryCourses);
                    chooseCourse(chemisteryCourses);
                    break;
                case 4:
                    printCourses(civilCourses);
                    chooseCourse(civilCourses);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void printCourses(List<Course> courses) {
        for (Course course : courses) {
            System.out.println(course.getName_of_course() + "| " + course.getClass_id() + "| " + course.getTeacherName() + "| " + course.getExam() + "| " + course.getClass_time());
        }
    }

    public static void chooseCourse(List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("say code:");
            String code = scanner.next();
            if (code.equals("back")) return;
            for (Course course : courses) {
                if (course.getClass_id() == Integer.parseInt(code)) {
                    if (!checkValidCourse(course).equals("")) {
                        System.out.println(checkValidCourse(course));
                        break;
                    } else if (loggedInUser instanceof Student) {
                        Student student = (Student) loggedInUser;
                        student.akhz(course);
                        course.setCapacity(course.getCapacity() - 1);
                        System.out.println("Course added successfully.");
                        break;
                    }
                }
            }
        }
    }

    public static String checkValidCourse(Course course) {
        if (loggedInUser instanceof Student) {
            Student student = (Student) loggedInUser;
            if (student.getNumberOfCourses() + course.getVahed() > 20) {
                return "you've reached your vahed limit";
            } else if (student.getNumberOfOmomiCourses() >= 2) {
                return "you can't take more than 2 omomis";
            } else if (course.getCapacity() - 1 < 0) {
                System.out.println("the course select has no capacity");
            } else {
                for (Course course1 : student.getCourses()) {
                    if (course.equals(course1)) {
                        return "you've already taken this course";
                    }
                }
            }
        } else return "d";
        return "";
    }

    private static void addCourse() {
        while (true) {
            if (mathCourses.size() == 8) {
                System.out.print("add course: ");
                String input = scanner.nextLine();

            }
        }
    }

}
