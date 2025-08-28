package com.my.jpaTest.dto;

import lombok.Data;

@Data
public class Test {
    private  Long id;
    private  String name;
    private  String email;

    public void email() {
        System.out.println("난 @Data");
    }
}
