import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {
    public static List<Employee> filterByAge(List<Employee> employees, int ageThreshold) {
        return employees.stream()
                .filter(employee -> employee.getAge() > ageThreshold)
                .collect(Collectors.toList());
    }
}
