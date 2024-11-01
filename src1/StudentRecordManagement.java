import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    // Method to add a new student
    public static void addStudent(String name, String id, int age, String grade) {
        Student student = new Student(name, id, age, grade);
        studentList.add(student);
        totalStudents++;
        System.out.println("Student added successfully!");
    }

    // Method to update student information
    public static void updateStudent(String id, String newName, int newAge, String newGrade) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setAge(newAge);
                student.setGrade(newGrade);
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to view student details
    public static void viewStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to display all students
    public static void viewAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Administrator Interface:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. View student details");
            System.out.println("4. View all students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    StudentManagement.addStudent(name, id, age, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter student ID to view: ");
                    String viewId = scanner.nextLine();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    StudentManagement.viewAllStudents();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
