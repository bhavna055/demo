package practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.demo.exception.ResourceNotFoundException;
import practice.demo.model.employee;
import practice.demo.repo.EmployeeRepository;

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
    public employee createEmployee(@RequestBody employee Employee) {
        return employeeRepository.save(Employee);
    }

//    @GetMapping("/employees/{department}")
//    public ResponseEntity<employee> getEmployeeById(@PathVariable(value = "department") String departmentt)
//            throws ResourceNotFoundException {
//        employee employee = employeeRepository.findByDepartment(departmentt)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + departmentt));
//        return ResponseEntity.ok().body(employee);
//    }
    @CrossOrigin
    @GetMapping("/employees")
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/employees/{department}")
    public ResponseEntity<List<employee>> getEmployeeByDepartment(@PathVariable(value = "department") String department)
            throws ResourceNotFoundException {
        List<employee> employees = employeeRepository.findByDepartment(department);
        if (employees.isEmpty()){
            System.out.println("in");
            throw  new ResourceNotFoundException("No employee found for department " + department);

        }

        return ResponseEntity.ok().body(employees);
    }
    @CrossOrigin
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @CrossOrigin
    @PutMapping("/employees/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                  @RequestBody employee employeeDetails) throws ResourceNotFoundException {
        employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));


        employee.setEmpName(employeeDetails.getEmpName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setRole(employeeDetails.getRole());
        final employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }


}
