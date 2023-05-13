package com.example.leprenoteReactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {

    private long id;
    private String description;
    private String postDate;
    private int rating;
    private boolean isReported = false;

}
