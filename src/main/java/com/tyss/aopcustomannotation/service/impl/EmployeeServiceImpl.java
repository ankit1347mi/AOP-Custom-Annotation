package com.tyss.aopcustomannotation.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.tyss.aopcustomannotation.aspect.Logging;
import com.tyss.aopcustomannotation.dao.EmployeeDao;
import com.tyss.aopcustomannotation.dao.impl.EmployeeDaoImpl;
import com.tyss.aopcustomannotation.dto.EmployeeRequest;
import com.tyss.aopcustomannotation.dto.EmployeeResponse;
import com.tyss.aopcustomannotation.entity.Employee;
import com.tyss.aopcustomannotation.entity.Institute;
import com.tyss.aopcustomannotation.service.EmployeeService;
import com.tyss.aopcustomannotation.structure.ResponseStructure;
import com.tyss.aopcustomannotation.structure.ServiceMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnClass(EmployeeDaoImpl.class)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    private ModelMapper modelMapper;

    private ServiceMessage serviceMessage;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao, ModelMapper modelMapper, ServiceMessage serviceMessage) {
        this.employeeDao = employeeDao;
        this.modelMapper = modelMapper;
        this.serviceMessage = serviceMessage;
    }


    @Logging
    @Override
    public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        Employee employee1 = employeeDao.saveEmployee(employee);
        EmployeeResponse employeeResponse = modelMapper.map(employee1, EmployeeResponse.class);
        ResponseStructure<EmployeeResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponse);
        return new ResponseEntity<>(structure, HttpStatus.CREATED);

    }

    @Logging
    @Override
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(String id) {
        Employee employee = employeeDao.findEmployeeById(id);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        ResponseStructure<EmployeeResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponse);
        return new ResponseEntity<>(structure, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployee() {
        List<Employee> allEmployee = employeeDao.findAllEmployee();
        List<EmployeeResponse> employeeResponses = allEmployee.stream().map(employee -> modelMapper.map(employee, EmployeeResponse.class)).toList();
        ResponseStructure<List<EmployeeResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponses);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    @Logging
    @Override
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeByYearOfPassingAndPercentage(int yearOfPassing, double percentage) {
        Employee employee = employeeDao.findEmployeeByYearOfPassingAndPercentage(yearOfPassing, percentage);
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        ResponseStructure<EmployeeResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponse);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    @Logging
    @Override
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByPercentageGreaterThan(double percentage) {
        List<Employee> employees = employeeDao.findEmployeeByPercentageGreaterThan(percentage);
        List<EmployeeResponse> employeeResponses = employees.stream().map(employee -> modelMapper.map(employee, EmployeeResponse.class)).toList();
        ResponseStructure<List<EmployeeResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponses);
        return new ResponseEntity<>(structure, HttpStatus.OK);

    }

    @Logging
    @Override
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findEmployeeByInstituteName(String instituteName) {
        List<Employee> employees = employeeDao.findEmployeeByInstituteName(instituteName);
        List<EmployeeResponse> employeeResponses = employees.stream().map(employee -> modelMapper.map(employee, EmployeeResponse.class)).toList();
        ResponseStructure<List<EmployeeResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(serviceMessage.getMessage());
        structure.setData(employeeResponses);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    @Logging
    @Override
    public ResponseEntity<ResponseStructure<String>> updateInstitute(Institute institute, String name, String instituteName) {
        UpdateResult updateResult = employeeDao.updateInstitute(institute, name, instituteName);
        if (updateResult.getModifiedCount() > 0) {
            ResponseStructure<String> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage(serviceMessage.getMessage());
            structure.setData(serviceMessage.getUpdateMessage());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        }
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        structure.setMessage(serviceMessage.getFailed());
        structure.setData(serviceMessage.getFailed() + " to Update");
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }


}
