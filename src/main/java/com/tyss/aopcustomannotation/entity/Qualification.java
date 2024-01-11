package com.tyss.aopcustomannotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {

    private int yearOfPassing;
    private String degree;
    private double percentage;
    private Institute institute;

}
