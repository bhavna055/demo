package practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.demo.exception.ResourceNotFoundException;
import practice.demo.model.employee;
import practice.demo.repo.EmployeeRepository;

import java.util.List;

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
    @GetMapping("/employees")
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{department}")
    public employee getEmployeeByDepartment(@PathVariable(value = "department") String departmentt)
            throws ResourceNotFoundException {
        employee employee = employeeRepository.findByDepartment(departmentt)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + departmentt));
        return employee;


    }





}
