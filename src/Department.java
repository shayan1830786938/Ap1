import java.util.List;

public class Department {
    private CourseDepartment name;
    private List<Course> courses;

    public Department(CourseDepartment name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public CourseDepartment getName() {
        return name;
    }

    public void setName(CourseDepartment name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
