package com.tyss.aopcustomannotation.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseStructure<T> {
    private int statusCode;

    private String message;

    private T data;
}
