package com.tyss.aopcustomannotation.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.tyss.aopcustomannotation.dao.EmployeeDao;
import com.tyss.aopcustomannotation.exception.NoSuchEmployeeFoundException;
import com.tyss.aopcustomannotation.entity.Employee;
import com.tyss.aopcustomannotation.entity.Institute;
import com.tyss.aopcustomannotation.repository.EmployeeRepo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EmployeeRepo employeeRepo;

    private MongoTemplate mongoTemplate;

    public EmployeeDaoImpl(EmployeeRepo employeeRepo, MongoTemplate mongoTemplate) {
        this.employeeRepo = employeeRepo;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee findEmployeeById(String id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchEmployeeFoundException();
    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.isEmpty()) {
            throw new NoSuchEmployeeFoundException();
        }
        return employees;
    }

    @Override
    public Employee findEmployeeByYearOfPassingAndPercentage(int yearOfPassing, double percentage) {
        Employee employee = employeeRepo.findEmployeeByYearOfPassingAndPercentage(yearOfPassing, percentage);
        if (employee != null) {
            return employee;
        }
        throw new NoSuchEmployeeFoundException();
    }

    @Override
    public List<Employee> findEmployeeByPercentageGreaterThan(double percentage) {
        List<Employee> employees = employeeRepo.findByQualificationPercentageGreaterThan(percentage);
        if (employees.isEmpty()) {
            throw new NoSuchEmployeeFoundException();
        }
        return employees;
    }

    @Override
    public List<Employee> findEmployeeByInstituteName(String instituteName) {
        Query query = new Query(Criteria.where("qualification.institute.name").is(instituteName));
        List<Employee> employees = mongoTemplate.find(query, Employee.class);
        if (employees.isEmpty()) {
            throw new NoSuchEmployeeFoundException();
        }
        return employees;
    }

    @Override
    public UpdateResult updateInstitute(Institute institute, String name, String instituteName) {
        Query query = new Query(Criteria.where("name").is(name).and("qualification.institute.name").is(instituteName));
        Update update = new Update().set("qualification.$.institute", institute);
        return mongoTemplate.updateMulti(query, update, Employee.class);

    }


}
