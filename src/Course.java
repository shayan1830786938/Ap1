public class Course {
    private CourseDepartment department;
    private String name_of_course;
    private int class_id;
    private String teacherName;
    private String exam;
    private String class_time;
    private int vahed;

    private CourseType courseType;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int capacity;

    public Course(CourseDepartment department, String name_of_course, int class_id, String teacherName, String exam, String class_time, CourseType courseType, int vahed ,int capacity) {
        this.department = department;
        this.name_of_course = name_of_course;
        this.class_id = class_id;
        this.teacherName = teacherName;
        this.exam = exam;
        this.vahed = vahed;
        this.class_time = class_time;
        this.capacity=capacity;
    }

    public int getVahed() {
        return vahed;
    }

    public void setVahed(int vahed) {
        this.vahed = vahed;
    }

    public CourseDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CourseDepartment department) {
        this.department = department;
    }

    public String getName_of_course() {
        return name_of_course;
    }

    public void setName_of_course(String name_of_course) {
        this.name_of_course = name_of_course;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

}
