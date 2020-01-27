package com.ratwareid.spring.repository;

import com.ratwareid.spring.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
}
