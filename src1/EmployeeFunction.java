import java.util.function.Function;

public class EmployeeFunction {
    public static Function<Employee, String> getNameAndDepartment() {
        return employee -> employee.getName() + " - " + employee.getDepartment();
    }
}
