package com.sopra.sopracalc.controller;

import com.sopra.sopracalc.exception.CalcException;
import com.sopra.sopracalc.service.imp.Subtract;
import com.sopra.sopracalc.service.imp.Sum;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sopracalc")
public class CalcController {

    private final Sum sum = new Sum();
    private final Subtract sub = new Subtract();

    @GetMapping(value = "operation/{operation}/{elementOne}/{elementTwo}", produces = MediaType
            .APPLICATION_JSON_VALUE)
    public String calc(@PathVariable("operation") String operation, @PathVariable("elementOne") String elementOne,
                       @PathVariable("elementTwo") String elementTwo) {

        switch (operation) {
            case "sum": return sum.operationInit(elementOne,elementTwo);
            case "sub": return sub.operationInit(elementOne,elementTwo);
            default: return CalcException.OPERATION_NOT_FOUND.getBusinessError();
        }
    }
}
