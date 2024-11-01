import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagementSystem {

    // GUI Components
    private JFrame frame;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField idField, nameField, emailField, courseField, gradeField;
    private ArrayList<Student> students;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem().createAndShowGUI());
    }

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Table Model for displaying student data
        tableModel = new DefaultTableModel(new Object[] { "ID", "Name", "Email", "Courses", "Grades" }, 0);
        studentTable = new JTable(tableModel);

        // Input Fields
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(10);
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(15);
        JLabel courseLabel = new JLabel("Course:");
        courseField = new JTextField(15);
        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(5);

        // Buttons
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new AddStudentListener());

        JButton updateButton = new JButton("Update Student");
        updateButton.addActionListener(new UpdateStudentListener());

        JButton viewButton = new JButton("View Student Details");
        viewButton.addActionListener(new ViewStudentListener());

        JButton enrollButton = new JButton("Enroll in Course");
        enrollButton.addActionListener(new EnrollCourseListener());

        JButton gradeButton = new JButton("Assign Grade");
        gradeButton.addActionListener(new AssignGradeListener());

        // Panel for input and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(courseLabel);
        panel.add(courseField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(viewButton);
        panel.add(enrollButton);
        panel.add(gradeButton);

        // Add components to frame
        frame.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Event handler for adding a student
    private class AddStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();
            String name = nameField.getText();
            String email = emailField.getText();

            if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Student student = new Student(id, name, email);
                students.add(student);
                tableModel.addRow(new Object[] { student.getId(), student.getName(), student.getEmail(), "", "" });
                clearFields();
            }
        }
    }

    // Event handler for updating a student
    private class UpdateStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = idField.getText();
                String name = nameField.getText();
                String email = emailField.getText();

                if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Student student = students.get(selectedRow);
                    student.setId(id);
                    student.setName(name);
                    student.setEmail(email);

                    tableModel.setValueAt(id, selectedRow, 0);
                    tableModel.setValueAt(name, selectedRow, 1);
                    tableModel.setValueAt(email, selectedRow, 2);

                    clearFields();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a student to update", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Event handler for viewing student details
    private class ViewStudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                Student student = students.get(selectedRow);
                idField.setText(student.getId());
                nameField.setText(student.getName());
                emailField.setText(student.getEmail());
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a student to view", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Event handler for enrolling in a course
    private class EnrollCourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                String course = courseField.getText();
                if (course.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a course name", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Student student = students.get(selectedRow);
                    student.enrollCourse(course);

                    tableModel.setValueAt(student.getCourses(), selectedRow, 3);

                    courseField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a student to enroll in a course", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Event handler for assigning a grade
    private class AssignGradeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                String course = courseField.getText();
                String grade = gradeField.getText();

                if (course.isEmpty() || grade.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter both course and grade", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Student student = students.get(selectedRow);
                    student.assignGrade(course, grade);

                    tableModel.setValueAt(student.getGrades(), selectedRow, 4);

                    courseField.setText("");
                    gradeField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a student to assign a grade", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to clear input fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        courseField.setText("");
        gradeField.setText("");
    }

    // Student class
    class Student {
        private String id;
        private String name;
        private String email;
        private ArrayList<String> courses;
        private ArrayList<String> grades;

        public Student(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.courses = new ArrayList<>();
            this.grades = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void enrollCourse(String course) {
            courses.add(course);
        }

        public void assignGrade(String course, String grade) {
            int index = courses.indexOf(course);
            if (index != -1) {
                grades.add(index, grade);
            }
        }

        public String getCourses() {
            return String.join(", ", courses);
        }

        public String getGrades() {
            return String.join(", ", grades);
        }
    }
}
