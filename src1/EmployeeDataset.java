import java.util.ArrayList;
import java.util.List;

public class EmployeeDataset {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 34, "HR", 65000));
        employees.add(new Employee("Bob", 28, "IT", 75000));
        employees.add(new Employee("Charlie", 31, "Finance", 70000));
        employees.add(new Employee("Diana", 29, "Marketing", 55000));
        employees.add(new Employee("Edward", 45, "IT", 80000));
        return employees;
    }
}
