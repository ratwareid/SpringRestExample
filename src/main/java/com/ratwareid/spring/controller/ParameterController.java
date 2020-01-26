package com.ratwareid.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {


    @RequestMapping(value = "/getParameter/{namaParam1}")
    public String getParameter(@PathVariable("namaParam1") String np1){
        //Cara Requestnya : http://localhost:8080/getParameter/namaparameternya
        return "parameternya adalah "+np1;
    }

    @RequestMapping(value = "/getParameter2/{namaParam1}/{namaParam2}")
    public String getParameter(
            @PathVariable("namaParam1") String np1,
            @PathVariable("namaParam2") String np2){
        //Cara Requestnya : http://localhost:8080/getParameter2/parameter1/parameter2
        return "parameter1nya adalah "+np1+" parameter2nya adalah "+np2;
    }

    @RequestMapping(value = "/getParameter3/{paramAngka:[\\d]+}")
    public String getParameter(
            @PathVariable("paramAngka") long paramangkaregex){
        //Cara Requestnya : http://localhost:8080/getParameter3/1232
        return "parameter1nya angka dari regex adalah "+paramangkaregex;
    }

    @RequestMapping(value = "/getReqParam")
    public String getRequestParam(
            @RequestParam("paramAngka") long paramAngka){
        //Cara Requestnya : http://localhost:8080/getReqParam?paramAngka=1
        return "ini request paramAngka balikan "+paramAngka;
    }

    @RequestMapping(value = "/getReqParamDouble")
    public String getRequestParamDouble(
            @RequestParam("parameter1") long paramter1,
            @RequestParam("parameter2") long paramter2){
        //Cara Requestnya : http://localhost:8080/getReqParamDouble?parameter1=1323&parameter2=4
        return "ini request parameter1 "+paramter1+" parameter2 "+paramter2;
    }
}
