package practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.demo.exception.ResourceNotFoundException;
import practice.demo.model.Employee;
import practice.demo.repo.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @CrossOrigin
    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee Employee) {
        return employeeRepository.save(Employee);
    }

    // http://localhost:8080/api/v1/employees?sort=id,desc&size=10&page=0
    @CrossOrigin
    @GetMapping("/employees")
    public Page<Employee> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees;

    }

    @CrossOrigin
    @GetMapping("/employees/{department}")
    public Page<Employee> getEmployeeByDepartment(@PathVariable(value = "department") String department,Pageable pageable)
            throws ResourceNotFoundException {
        Page<Employee> employees = employeeRepository.findByDepartment(department,pageable);
        if (!employees.hasContent()){
            throw  new ResourceNotFoundException("No employee found for department " + department);

        }

        return employees;
    }

    @CrossOrigin
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @CrossOrigin
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));


        employee.setEmpName(employeeDetails.getEmpName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setRole(employeeDetails.getRole());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }


}
