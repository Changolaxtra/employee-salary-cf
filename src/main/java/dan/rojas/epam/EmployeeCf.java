package dan.rojas.epam;


import dan.rojas.epam.model.Employee;
import dan.rojas.epam.proxy.RestEmployeeService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
public class EmployeeCf {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    final RestEmployeeService restEmployeeService = new RestEmployeeService();

    final CompletableFuture<List<Employee>> employeeCompletableFuture =
        CompletableFuture.supplyAsync(restEmployeeService::getAllEmployees)
            .thenCompose(employeeRoles ->
                CompletableFuture.supplyAsync(() ->
                    Optional.ofNullable(employeeRoles)
                        .orElse(new ArrayList<>())
                        .stream()
                        .map(employeeRole -> new Employee(employeeRole,
                            restEmployeeService.getEmployeeSalary(employeeRole.getId())))
                        .collect(Collectors.toList())));

    Optional.ofNullable(employeeCompletableFuture.get())
        .orElse(new ArrayList<>())
        .forEach(employee -> log.info("{}" , employee));

  }


}
