package dan.rojas.epam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class EmployeeSalary {
  private String id;
  private BigDecimal salary;
}
