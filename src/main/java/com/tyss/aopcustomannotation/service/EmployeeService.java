package com.tyss.aopcustomannotation.service;

import com.tyss.aopcustomannotation.dto.EmployeeRequest;
import com.tyss.aopcustomannotation.dto.EmployeeResponse;
import com.tyss.aopcustomannotation.entity.Employee;
import com.tyss.aopcustomannotation.entity.Institute;
import com.tyss.aopcustomannotation.structure.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest);

    ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(String id);

    ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployee();

    ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeByYearOfPassingAndPercentage(int yearOfPassing, double percentage);

    ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByPercentageGreaterThan(double percentage);

    ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByInstituteName(String instituteName);

    ResponseEntity<ResponseStructure<String>> updateInstitute(Institute institute, String name, String instituteName);

}
