package com.ratwareid.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerModel {

    @Id
    @GeneratedValue
    private int id;
    private String name,email,gender;

    @OneToMany(targetEntity = ProductModel.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "id")
    private List<ProductModel> product;
}
