import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStream {
    public static List<String> getEmployeeNamesAndDepartments(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeFunction.getNameAndDepartment())
                .collect(Collectors.toList());
    }
}
