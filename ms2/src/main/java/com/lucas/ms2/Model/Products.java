package com.lucas.ms2.Model;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products that = (Products) o;
        return Objects.equals(name, that.name);
    }
}