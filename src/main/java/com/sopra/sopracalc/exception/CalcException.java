package com.sopra.sopracalc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CalcException {

    OPERATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Operation not Found"),
    INPUT_INVALID(HttpStatus.CONFLICT, "Input Invalid");

    private final HttpStatus httpStatus;
    private final String businessError;

}
