package com.lucas.ms2.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private String name;
    private String description;
    private Double price;

    public String JsonProducts(){
        return "{ \"name\": \"" + name 
        + "\", \"description\": \"" + description 
        + "\", \"price\": " + price + " }";
    }
}