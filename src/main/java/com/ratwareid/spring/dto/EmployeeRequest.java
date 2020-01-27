package com.ratwareid.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeRequest {

    @JsonProperty("EmployeeID")
    private int EmployeeID;
    @JsonProperty("FullName")
    private String FullName;
    @JsonProperty("Position")
    private String Position;
    @JsonProperty("EMPCode")
    private String EMPCode;
    @JsonProperty("Mobile")
    private String Mobile;

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getEMPCode() {
        return EMPCode;
    }

    public void setEMPCode(String EMPCode) {
        this.EMPCode = EMPCode;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
