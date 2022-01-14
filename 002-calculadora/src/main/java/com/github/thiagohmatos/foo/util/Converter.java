package com.github.thiagohmatos.foo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    Validate validate;

    public Double stringToDouble(String numberToConvert) {
        if (numberToConvert == null) return 0D;
        String number = numberToConvert.replaceAll(",", ".");
        if (validate.isNumeric(numberToConvert)) {
            return Double.parseDouble(numberToConvert);
        } else {
            return 0D;
        }
    }
}
