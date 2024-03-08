import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Course> courses = new ArrayList<>();
    private int numberOfCourses;

    public Student(String username, String password) {
        super(username, password);
    }

    public int getNumberOfOmomiCourses() {
        int counter = 0;
        for (Course course : courses) {
            if (course.getCourseType() != null) {
                if (course.getCourseType().equals(CourseType.Omomii)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void akhz(Course course) {
        courses.add(course);
        numberOfCourses += course.getVahed();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }
}
