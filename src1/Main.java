import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create and store dataset
        List<Employee> employees = EmployeeDataset.getEmployees();

        // Step 2 and 3: Use Function interface and Streams to get concatenated strings
        List<String> employeeNamesAndDepartments = EmployeeStream.getEmployeeNamesAndDepartments(employees);
        System.out.println("Employee Names and Departments:");
        employeeNamesAndDepartments.forEach(System.out::println);

        // Step 4: Calculate the average salary
        double averageSalary = EmployeeAverageSalary.calculateAverageSalary(employees);
        System.out.println("\nAverage Salary: " + averageSalary);

        // Step 5: Filter employees by age
        List<Employee> filteredEmployees = EmployeeFilter.filterByAge(employees, 30);
        System.out.println("\nFiltered Employees (Age > 30):");
        filteredEmployees
                .forEach(emp -> System.out.println(emp.getName() + " - " + emp.getAge() + " - " + emp.getDepartment()));
    }
}
