package com.ratwareid.spring.controller;

import com.ratwareid.spring.dto.EmployeeRequest;
import com.ratwareid.spring.dto.GeneralResponse;
import com.ratwareid.spring.model.CustomerModel;
import com.ratwareid.spring.model.EmployeeModel;
import com.ratwareid.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("api/Employee")
    public GeneralResponse createEmployee(@RequestBody EmployeeRequest request){
        GeneralResponse response = new GeneralResponse();
        try{
            EmployeeModel model = new EmployeeModel();
            model.setEMPCode(request.getEMPCode());
            model.setFullName(request.getFullName());
            model.setMobile(request.getMobile());
            model.setPosition(request.getPosition());

            employeeRepository.save(model);
            response.setResponseCode(100);
            response.setResponseMessage("Berhasil Menyimpan Data");
        }catch (Exception e){
            e.printStackTrace();
            response.setResponseCode(400);
            response.setResponseMessage(e.getLocalizedMessage());
        }
        return response;
    }

    @GetMapping("api/Employee")
    public List<EmployeeRequest> showList(){
        List<EmployeeRequest> list = new ArrayList<>();
        try{
            for (Object x : employeeRepository.findAll()){
                EmployeeModel emp = (EmployeeModel) x;
                EmployeeRequest empreq = new EmployeeRequest();
                empreq.setEmployeeID(emp.getEmployeeID());
                empreq.setEMPCode(emp.getEMPCode());
                empreq.setFullName(emp.getFullName());
                empreq.setMobile(emp.getMobile());
                empreq.setPosition(emp.getPosition());
                list.add(empreq);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @PutMapping(value = "api/Employee/{EmployeeID:[\\d]+}")
    public GeneralResponse updateEmployee(
            @PathVariable("EmployeeID") int empID,@RequestBody EmployeeRequest request){
        GeneralResponse response = new GeneralResponse();

        try{
            EmployeeModel emp = employeeRepository.getOne(empID);
            emp.setPosition(request.getPosition());
            emp.setMobile(request.getMobile());
            emp.setFullName(request.getFullName());
            emp.setEMPCode(request.getEMPCode());

            employeeRepository.save(emp);
            response.setResponseCode(100);
            response.setResponseMessage("Update Successfully");
        }catch (Exception e){
            e.printStackTrace();
            response.setResponseCode(400);
            response.setResponseMessage(e.getLocalizedMessage());
        }
        return response;
    }

    @DeleteMapping(value = "api/Employee/{EmployeeID:[\\d]+}")
    public GeneralResponse deleteEmployee(
            @PathVariable("EmployeeID") int empID){
        GeneralResponse response = new GeneralResponse();

        try{
            EmployeeModel emp = employeeRepository.getOne(empID);
            employeeRepository.delete(emp);
            response.setResponseCode(100);
            response.setResponseMessage("Update Successfully");
        }catch (Exception e){
            e.printStackTrace();
            response.setResponseCode(400);
            response.setResponseMessage(e.getLocalizedMessage());
        }
        return response;
    }
}
