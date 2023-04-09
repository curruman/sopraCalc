package com.sopra.sopracalc.service.imp;

import com.sopra.sopracalc.exception.CalcException;
import com.sopra.sopracalc.service.Operation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import io.corp.calculator.TracerImpl;

public class Sum implements Operation {


    @Override
    public String operationInit(String elementOne, String elementTwo) {
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            String result = new DecimalFormat("#.#####",symbols)
                    .format(Double.parseDouble(elementOne) + Double.parseDouble(elementTwo));
            TracerImpl tracer = new TracerImpl();
            tracer.trace(result);
            return result;
        } catch (NumberFormatException exception) {
            return CalcException.INPUT_INVALID.getBusinessError() + " " + exception;
        }
    }
}
