package com.tyss.aopcustomannotation.dao;

import com.mongodb.client.result.UpdateResult;
import com.tyss.aopcustomannotation.entity.Employee;
import com.tyss.aopcustomannotation.entity.Institute;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeDao {

    Employee saveEmployee(Employee employee);

    Employee findEmployeeById(String id);

    List<Employee> findAllEmployee();

    Employee findEmployeeByYearOfPassingAndPercentage(int yop, double percentage);

    List<Employee> findEmployeeByPercentageGreaterThan(double percentage);

    List<Employee> findEmployeeByInstituteName(String instituteName);

    UpdateResult updateInstitute(Institute institute, String name, String instituteName);

}
