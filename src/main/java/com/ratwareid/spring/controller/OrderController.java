package com.ratwareid.spring.controller;

import com.ratwareid.spring.dto.OrderRequest;
import com.ratwareid.spring.model.CustomerModel;
import com.ratwareid.spring.repository.CustomerRepository;
import com.ratwareid.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public CustomerModel placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<CustomerModel> findAllOrders(){
        return customerRepository.findAll();
    }

}
