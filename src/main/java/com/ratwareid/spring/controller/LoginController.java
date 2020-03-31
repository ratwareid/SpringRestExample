package com.ratwareid.spring.controller;

import com.ratwareid.spring.dto.LogRegRequest;
import com.ratwareid.spring.dto.LoginResponse;
import com.ratwareid.spring.model.UserModel;
import com.ratwareid.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/api/login")
    public LoginResponse loginUser(
            @RequestBody LogRegRequest logindata){
        LoginResponse response = new LoginResponse();

        try{
            UserModel userModel = userRepository.findUserModelByUsernameEqualsAndPasswordEquals(logindata.getUserName(),logindata.getPassword());
            if (userModel == null) {
                throw new Exception("User / Password salah!");
            }
            response.setUserToken(generateRandomToken(String.valueOf(userModel.getUserid())));
            response.setResponseCode(100);
            response.setResponseMessage("Login Successfully");
        }catch (Exception e){
            e.printStackTrace();
            response.setResponseCode(400);
            response.setResponseMessage(e.getLocalizedMessage());
        }
        return response;
    }

    @PostMapping(value = "/api/register")
    public LoginResponse registerUser(
            @RequestBody LogRegRequest data){
        LoginResponse response = new LoginResponse();

        try{
            UserModel userModel = new UserModel(data.getUserName(),data.getPassword(),data.getEmail(),data.getFirstName(),data.getLastName());
            userRepository.save(userModel);
            response.setResponseCode(100);
            response.setResponseMessage("Register Successfully");
        }catch (Exception e){
            e.printStackTrace();
            response.setResponseCode(400);
            response.setResponseMessage(e.getLocalizedMessage());
        }
        return response;
    }
    

    private String generateRandomToken(String userid) throws NoSuchAlgorithmException {
        String salt = "sadwa81hidasd0j2dajkshda20udjjksda";
        String tmsp = String.valueOf(System.currentTimeMillis());

        return sha256(salt.concat(userid).concat(tmsp));
    }

    private String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
