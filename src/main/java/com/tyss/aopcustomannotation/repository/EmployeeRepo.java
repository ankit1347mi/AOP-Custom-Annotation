package com.tyss.aopcustomannotation.repository;

import com.tyss.aopcustomannotation.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepo extends MongoRepository<Employee, String> {

    List<Employee> findByQualificationPercentageGreaterThan(double percentage);

    @Query(value = "{$and:[{yearOfPassing:?0},{percentage:?1}]}")
    Employee findEmployeeByYearOfPassingAndPercentage(int yearOfPassing,double percentage);
}
