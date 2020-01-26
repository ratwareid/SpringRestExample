package com.ratwareid.spring.repository;

import com.ratwareid.spring.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {
}
