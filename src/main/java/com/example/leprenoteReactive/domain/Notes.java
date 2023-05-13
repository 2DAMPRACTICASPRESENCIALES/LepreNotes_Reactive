package com.example.leprenoteReactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {

    private long id;
    private String title;
    private String subject;
    private String content;
    private String schoolYear;
    private int price;
}
