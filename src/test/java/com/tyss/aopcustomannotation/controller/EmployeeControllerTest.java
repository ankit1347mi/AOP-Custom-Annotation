package com.tyss.aopcustomannotation.controller;

import com.tyss.aopcustomannotation.dto.EmployeeRequest;
import com.tyss.aopcustomannotation.dto.EmployeeResponse;
import com.tyss.aopcustomannotation.entity.Institute;
import com.tyss.aopcustomannotation.entity.Qualification;
import com.tyss.aopcustomannotation.service.EmployeeService;
import com.tyss.aopcustomannotation.structure.ResponseStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void saveEmployee() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));

        EmployeeRequest employeeRequest = new EmployeeRequest("Ankit", qualifications);
        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);


        when(employeeService.saveEmployee(any(EmployeeRequest.class))).thenReturn(ResponseEntity.ok(new ResponseStructure<>(201, "Success", employeeResponse)));

        ResponseEntity<ResponseStructure<EmployeeResponse>> responseEntity = employeeController.saveEmployee(employeeRequest);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getStatusCodeValue());
        assertEquals("Success", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
        assertEquals(201, responseEntity.getBody().getStatusCode());

    }

    @Test
    void findEmployeeById() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));

        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);
        String employeeId = "101";
        when(employeeService.findEmployeeById(employeeId)).thenReturn(ResponseEntity.ok(new ResponseStructure<EmployeeResponse>(200, "Success", employeeResponse)));

        ResponseEntity<ResponseStructure<EmployeeResponse>> responseEntity = employeeController.findEmployeeById(employeeId);
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Success", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
        System.out.println(responseEntity.getBody().getData());
    }

    @Test
    void findAllEmployee() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));

        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        employeeResponses.add(employeeResponse);

        when(employeeService.findAllEmployee()).thenReturn(ResponseEntity.ok(new ResponseStructure<List<EmployeeResponse>>(200, "Success", employeeResponses)));
        ResponseEntity<ResponseStructure<List<EmployeeResponse>>> responseEntity = employeeController.findAllEmployee();
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Success", responseEntity.getBody().getMessage());
        assertNotNull(responseEntity.getBody().getData());
    }

    @Test
    void findEmployeeByYearOfPassingAndPercentage() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));
        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);

        int yearOfPassing = 2022;
        double percentage = 78.6;
        when(employeeService.findEmployeeByYearOfPassingAndPercentage(yearOfPassing, percentage)).thenReturn(ResponseEntity.ok(new ResponseStructure<EmployeeResponse>(200, "Success", employeeResponse)));
        ResponseEntity<ResponseStructure<EmployeeResponse>> responseEntity = employeeController.findEmployeeByYearOfPassingAndPercentage(yearOfPassing, percentage);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals("Success", responseEntity.getBody().getMessage());

    }

    @Test
    void findEmployeeByPercentageGreaterThan() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));
        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        employeeResponses.add(employeeResponse);

        double percentage = 78.6;
        when(employeeService.findEmployeeByPercentageGreaterThan(percentage)).thenReturn(ResponseEntity.ok(new ResponseStructure<List<EmployeeResponse>>(200, "Success", employeeResponses)));
        ResponseEntity<ResponseStructure<List<EmployeeResponse>>> responseEntity = employeeController.findEmployeeByPercentageGreaterThan(percentage);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals("Success", responseEntity.getBody().getMessage());
        System.out.println();
    }

    @Test
    void findEmployeeByInstituteName() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));
        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        employeeResponses.add(employeeResponse);

        String instituteName = "MITS";
        when(employeeService.findEmployeeByInstituteName(instituteName)).thenReturn(ResponseEntity.ok(new ResponseStructure<List<EmployeeResponse>>(200, "Success", employeeResponses)));
        ResponseEntity<ResponseStructure<List<EmployeeResponse>>> responseEntity = employeeController.findEmployeeByInstituteName(instituteName);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals("Success", responseEntity.getBody().getMessage());
        System.out.println();

    }

    @Test
    void updateInstitute() {
        List<Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Qualification(2022, "Btech", 78.6, new Institute("MITS", "Gwalior")));
        qualifications.add(new Qualification(2019, "Diploma", 75.89, new Institute("GPC", "Satna")));
        EmployeeResponse employeeResponse = new EmployeeResponse("101", "Ankit", qualifications);

        String name = "Ankit";
        String instituteName = "MITS";
        Institute institute = new Institute("VITS", "Satna");

        when(employeeService.updateInstitute(institute, name, instituteName)).thenReturn(ResponseEntity.ok(new ResponseStructure<>(200, "Success", "Updated successfully")));

        ResponseEntity<ResponseStructure<String>> responseEntity = employeeController.updateInstitute(institute, name, instituteName);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody().getData());
        System.out.println(responseEntity.getBody().getData());

    }
}