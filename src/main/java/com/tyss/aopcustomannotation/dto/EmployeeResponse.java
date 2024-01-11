package com.tyss.aopcustomannotation.dto;

import com.tyss.aopcustomannotation.entity.Qualification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private String id;
    private String name;
    private List<Qualification>  qualification;
}
