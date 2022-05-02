package dan.rojas.epam.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Employee {
  private String id;
  private String name;
  private String role;
  private BigDecimal salary;

  public Employee(final EmployeeRole employeeRole, final EmployeeSalary employeeSalary) {
    if (Objects.nonNull(employeeRole)) {
      this.id = employeeRole.getId();
      this.name = employeeRole.getName();
      this.role = employeeRole.getRole();
    }
    if (Objects.nonNull(employeeSalary)) {
      this.salary = employeeSalary.getSalary();
    }
  }

}
