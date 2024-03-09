public class Takhassosi extends Course {

    public Takhassosi(CourseDepartment department, String name_of_course, int class_id, String teacherName, String exam, String class_time, CourseType courseType, int vahed, int capacity) {
        super(department, name_of_course, class_id, teacherName, exam, class_time, courseType, vahed, capacity);
        setCourseType(CourseType.Takhsossi);
    }
}
