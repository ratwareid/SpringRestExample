package com.example.demo.controller;

import com.example.demo.model.TestModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "getString")
    public String getString(){
        return "Hello ... anda mendapatkan string!";
    }

    @RequestMapping(value = "getTestModel")
    public TestModel getTestModel(){

        TestModel model = new TestModel();
        model.setId(100);
        model.setNama("Test Nama");
        return model;
    }

    @PostMapping(value = "postTestModel")
    public TestModel postTestModel(){

        TestModel model = new TestModel();
        model.setId(100);
        model.setNama("Test Nama Postman");
        return model;
    }
}
