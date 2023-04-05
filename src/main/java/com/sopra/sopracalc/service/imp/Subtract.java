package com.sopra.sopracalc.service.imp;

import com.sopra.sopracalc.exception.CalcException;
import com.sopra.sopracalc.service.Operation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Subtract implements Operation {
    @Override
    public String operationInit(String elementOne, String elementTwo) {
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            return new DecimalFormat("#.#####",symbols)
                    .format(Double.parseDouble(elementOne) - Double.parseDouble(elementTwo));
        } catch (Exception exception) {
            return CalcException.INPUT_INVALID.getBusinessError() + " " + exception;
        }
    }
}
