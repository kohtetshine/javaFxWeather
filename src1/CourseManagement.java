import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Map<Student, Map<Course, Integer>> studentGrades = new HashMap<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    public static void addStudent(String name, String id) {
        Student newStudent = new Student(name, id);
        students.add(newStudent);
    }

    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
        studentGrades.putIfAbsent(student, new HashMap<>());
    }

    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
        if (studentGrades.containsKey(student)) {
            studentGrades.get(student).put(course, grade);
        }
    }

    public static double calculateOverallGrade(Student student) {
        Map<Course, Integer> grades = studentGrades.get(student);
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        int count = 0;
        for (int grade : grades.values()) {
            if (grade != 0) {
                total += grade;
                count++;
            }
        }

        return count > 0 ? total / count : 0.0;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static List<Student> getStudents() {
        return students;
    }
}
