package com.sopra.sopracalc.service.imp;

import com.sopra.sopracalc.exception.CalcException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    private Sum sum = new Sum();
    private static Stream<Arguments> validArguments() {
        return Stream.of(
                Arguments.of("1950", "2030", "3980"),
                Arguments.of("0.31416", "0.4142", "0.72836"),
                Arguments.of("10.55", "9.386", "19.936"),
                Arguments.of("120250888", "850332963", "970583851"),
                Arguments.of("300", "-200", "100"));
    }

    @ParameterizedTest
    @MethodSource("validArguments")
    void operationInit(String paramOne, String paramTwo, String result) {
        assertEquals(result,sum.operationInit(paramOne,paramTwo));
    }

    private static Stream<Arguments> notValid() {
        return Stream.of(
                Arguments.of("25i", "2030"),
                Arguments.of("0.31416", "A"),
                Arguments.of("B", "45Z"));
    }

    @ParameterizedTest
    @MethodSource("notValid")
    void operationNotValid(String paramOne, String paramTwo) {
        assertEquals(CalcException.INPUT_INVALID.getBusinessError(),sum.operationInit(paramOne,paramTwo)
                .substring(0,13));
    }

}