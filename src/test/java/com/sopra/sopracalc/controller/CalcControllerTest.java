package com.sopra.sopracalc.controller;

import com.sopra.sopracalc.exception.CalcException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalcControllerTest {

    private String elementOne = "50";
    private String elementTwo = "50";
    @Mock
    private CalcController calc;

    @BeforeEach
    void init() {
        calc = mock(CalcController.class);
    }

    @Test
    void calcSumTest() {
        when(calc.calc("sum",elementOne,elementTwo)).thenReturn("100");
        assertEquals("100",calc.calc("sum","50","50"));

    }

    @Test
    void calSubTest() {
        when(calc.calc("sub",elementOne,elementTwo)).thenReturn("0");
        assertEquals("0",calc.calc("sub","50","50"));
    }

    @Test
    void calDefaultTest() {
        when(calc.calc("div",elementOne,elementTwo)).thenReturn(CalcException
                .OPERATION_NOT_FOUND.getBusinessError());
        assertEquals(CalcException.OPERATION_NOT_FOUND.getBusinessError(),calc
                .calc("div","50","50"));
    }
}