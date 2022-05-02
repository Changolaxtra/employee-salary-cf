package dan.rojas.epam.proxy;

import dan.rojas.epam.model.EmployeeRole;
import dan.rojas.epam.model.EmployeeSalary;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestEmployeeService {

  private Map<String, BigDecimal> salaries;

  public RestEmployeeService() {
    salaries = new HashMap<>();
    salaries.put("1", BigDecimal.valueOf(505.5));
    salaries.put("2", BigDecimal.valueOf(705.5));
  }

  public List<EmployeeRole> getAllEmployees() {
    return Arrays.asList(new EmployeeRole("1", "Juan", "Dev"),
        new EmployeeRole("2", "Pedro", "Dev"),
        new EmployeeRole("3", "Hugo", "Dev"));
  }

  public EmployeeSalary getEmployeeSalary(String id) {
    return new EmployeeSalary(id, salaries.get(id));
  }

}
