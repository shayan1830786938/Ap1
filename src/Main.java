import java.util.*;

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
        int adminChoice;

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
        }
    }

    public static void studentOptions() {
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

        System.out.println("Admin Login");
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        loggedInUser = checkValidLogin(username, password);

        if (loggedInUser instanceof Admin && loggedInUser != null) {
            System.out.println("Logged in as Admin");
            choiceDepartement2();
        } else {
            System.out.println("Invalid username or password!");
        }

    }

    public static void loginAsStudent() {
        System.out.println("Student Login");
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

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

        System.out.println("Student Sign Up");
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        users.add(new Student(username, password));

        System.out.println("Student account created successfully!");

    }

    public static void choiceDepartement2() {
        int choiceDepartement = 0;

        while (true) {
            System.out.println("Admin Options:");
            System.out.println("1.MATH ");
            System.out.println("2.PHYSICS ");
            System.out.println("3.CHEMISTERY ");
            System.out.println("4.CIVIL ");
            System.out.println("5.Back ");

            System.out.print("Enter your choice: ");
            choiceDepartement = scanner.nextInt();

            switch (choiceDepartement) {
                case 1:
                    chooseChoice(mathCourses);
                    break;
                case 3:
                    chooseChoice(chemisteryCourses);
                    break;
                case 2:
                    chooseChoice(physicCourses);
                    break;
                case 4:
                    chooseChoice(civilCourses);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }


    public static void choiceDepartement() {
        int choiceDepartement = 0;

        while (true) {
            System.out.println("1.MATH ");
            System.out.println("2.PHYSICS ");
            System.out.println("3.CHEMISTERY ");
            System.out.println("4.CIVIL ");
            System.out.println("5.Back ");

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
        System.out.println("1- add course");
        System.out.println("2- remove course");
        System.out.println("1- ");
        System.out.println("1-add course");

        while (true) {
            if (mathCourses.size() == 8) {
                System.out.print("add course: ");
                String input = scanner.nextLine();

            }
        }
    }


    public static void chooseChoice(List<Course> courses) {

        while (true) {
            System.out.println("1.add course ");
            System.out.println("2.remove course ");
            System.out.println("3.increase course capacity ");
            System.out.println("4.remove student ");
            System.out.println("5.add student ");
            System.out.println("6.back ");

            System.out.print("Enter your choice: ");
            String choiceDepartement = scanner.next();
            switch (choiceDepartement) {
                case "1":
                    addCourseAdmin(courses);
                    break;
                case "2":
                    removeCourse(courses);
                    break;
                case "3":
                    increaseCapacity(courses);
                    break;
                case "4":
                    removeStudentToCourse(courses);
                    break;
                case "5":
                    addStudentToCourse(courses);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void addCourseAdmin(List<Course> courses) {
        a:
        while (true) {
            System.out.println("enter these information in one line and seperate them by -");
            System.out.println("department name-course name-id-teacher name-exam time-class time- vahed-capacity");
            String[] course = scanner.next().split("-");
            String choice;
            if (course[0].equals("back")) return;
            for (Course c : courses) {
                if (c.getClass_id() == Integer.parseInt(course[2])) {
                    System.out.println("a course with this id already exists, please try again");
                    continue a;
                }
            }
            if (CourseDepartment.getEnumByValue(course[0]) == null) {
                System.out.println("wrong input for department");
                continue;
            }
            while (true) {
                System.out.println("1-takhasosi 2-omomi");
                System.out.println("enter choice");
                choice = scanner.next();
                if (choice.equals("back")) continue a;
                if (!(choice.equals("1") || choice.equals("2"))) {
                    System.out.println("invalid input");
                } else break;
            }
            Course newCourse = new Course(
                    CourseDepartment.getEnumByValue(course[0]), course[1], Integer.parseInt(course[2]), course[3], course[4],
                    course[5], CourseType.getEnumByValue(choice), Integer.parseInt(course[6]), Integer.parseInt(course[7])
            );
            courses.add(newCourse);
            System.out.println("course added successfully.");
        }
    }

    public static void removeCourse(List<Course> courses) {
        printCourses(courses);
        while (true) {
            System.out.println("enter the code of the course you wanna remove");
            String code = scanner.next();
            if (code.equals("back")) return;
            if (getCourseById(courses, Integer.parseInt(code)) == null) {
                System.out.println("a course with this id doesn't exists try again.");
                continue;
            }
            courses.remove(getCourseById(courses, Integer.parseInt(code)));
            System.out.println("course removed successfully");
        }
    }

    public static Course getCourseById(List<Course> courses, int id) {
        for (Course course : courses) {
            if (course.getClass_id() == id)
                return course;
        }
        return null;
    }

    public static void increaseCapacity(List<Course> courses) {
        printCourses(courses);
        while (true) {
            System.out.println("enter the id of the course u wanna increase the capacity");
            String code = scanner.next();
            if (code.equals("back")) return;
            Course course = getCourseById(courses, Integer.parseInt(code));
            if (course == null) {
                System.out.println("a course with this id doesn't exists try again.");
                continue;
            }
            while (true) {
                System.out.println("current capacity:" + course.getCapacity());
                System.out.println("enter the number you want it to increase");
                int cap;
                try {
                    cap = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("the input should be a number try again.");
                    continue;
                }
                course.setCapacity(course.getCapacity() + cap);
                System.out.println("the capacity increased successfully");
                break;
            }
        }
    }

    public static Student getStudentById(String id) {
        for (User user : users) {
            if (user instanceof Student && user.getUsername().equals(id))
                return (Student) user;

        }
        return null;
    }

    public static void addStudentToCourse(List<Course> courses) {
        while (true) {
            System.out.println("Enter the code of course you want to add a student to");
            String code = scanner.next();
            if (code.equals("back")) return;
            Course course = getCourseById(courses, Integer.parseInt(code));
            if (course == null) {
                System.out.println("a course with this id doesn't exists try again.");
                continue;
            }
            while (true) {
                System.out.println("enter the id of the student");
                String cap;
                cap = scanner.next();
                if (cap.equals("back")) break;
                Student student = getStudentById(cap);
                if (student == null) {
                    System.out.println("no student exists with this id");
                    continue;
                }
                student.getCourses().add(course);
                System.out.println("course added to the student successfully");
                break;
            }
        }
    }

    public static void removeStudentToCourse(List<Course> courses) {
        while (true) {
            System.out.println("Enter the code of course you want to remove a student from");
            String code = scanner.next();
            if (code.equals("back")) return;
            Course course = getCourseById(courses, Integer.parseInt(code));
            if (course == null) {
                System.out.println("a course with this id doesn't exists try again.");
                continue;
            }
            while (true) {
                System.out.println("enter the id of the student");
                String cap;
                cap = scanner.next();
                if (cap.equals("back")) break;
                Student student = getStudentById(cap);
                if (student == null) {
                    System.out.println("no student exists with this id");
                    continue;
                }
                student.getCourses().remove(course);
                System.out.println("course added to the student successfully");
                break;
            }
        }
    }

}
