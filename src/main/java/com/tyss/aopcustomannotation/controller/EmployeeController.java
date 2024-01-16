package com.tyss.aopcustomannotation.controller;

import com.tyss.aopcustomannotation.dto.EmployeeRequest;
import com.tyss.aopcustomannotation.dto.EmployeeResponse;
import com.tyss.aopcustomannotation.entity.Institute;
import com.tyss.aopcustomannotation.service.EmployeeService;
import com.tyss.aopcustomannotation.structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{yearOfPassing}/{percentage}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeByYearOfPassingAndPercentage(@PathVariable int yearOfPassing, @PathVariable double percentage) {
        return employeeService.findEmployeeByYearOfPassingAndPercentage(yearOfPassing, percentage);
    }

    @GetMapping("/percentage/{percentage}")
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByPercentageGreaterThan(@PathVariable double percentage) {
        return employeeService.findEmployeeByPercentageGreaterThan(percentage);
    }

    @GetMapping("/institute-name")
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByInstituteName(@RequestParam String instituteName) {
        return employeeService.findEmployeeByInstituteName(instituteName);
    }

    @PatchMapping("/{name}/{instituteName}")
    public ResponseEntity<ResponseStructure<String>> updateInstitute(@RequestBody Institute institute, @PathVariable String name, @PathVariable String instituteName) {
        return employeeService.updateInstitute(institute, name, instituteName);
    }
}
