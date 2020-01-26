package com.example.demo.controller;

import com.example.demo.model.ResponseModel;
import com.example.demo.model.TestParamModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestBodyController {

    @RequestMapping(value = "/requestBody1")
    @ResponseBody
    public TestParamModel getRequestBody1(
            @RequestBody TestParamModel modeltest){
        //Cara Requestnya Pake Postman:
        //URL : localhost:8080/requestBody1
        //Method Bisa GET bisa POST karena pakai RequestMapping
        //Kirim Body nya bentuk JSON
        return modeltest;
    }

    @PostMapping(value = "/postBody1")
    @ResponseBody
    public ResponseModel postBody1(
            @RequestBody TestParamModel modeltest){
        //Cara Requestnya Pake Postman:
        //URL : localhost:8080/postBody1
        //Method POST
        //Kirim Body nya bentuk JSON
        ResponseModel response = new ResponseModel();
        if (modeltest.getNama().equalsIgnoreCase("admin")){
            response.setResponseCode(100);
            response.setResponseMessage("Berhasil Terhubung ke Server!");
        }else{
            response.setResponseCode(400);
            response.setResponseMessage("Akses tidak dapat diproses!");
        }
        return response;
    }
}
