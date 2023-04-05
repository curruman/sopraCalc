package com.sopra.sopracalc.service.imp;

import com.sopra.sopracalc.exception.CalcException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtractTest {

    Subtract subtract = new Subtract();
    private static Stream<Arguments> subtractArguments() {
        return Stream.of(
                Arguments.of("2030", "1950", "80"),
                Arguments.of("0.31416", "0.4142", "-0.10004"),
                Arguments.of("10.55", "9.386", "1.164"),
                Arguments.of("100250888", "850332963", "-750082075"),
                Arguments.of("1955", "-1985", "3940"));
    }

    @ParameterizedTest
    @MethodSource("subtractArguments")
    void operationInit(String paramOne, String paramTwo, String result) {
        assertEquals(result,subtract.operationInit(paramOne,paramTwo));
    }

    @Test
    void operationNotValid() {
        assertEquals(CalcException.INPUT_INVALID.getBusinessError(), subtract
                .operationInit("A","10").substring(0,13));
    }
}