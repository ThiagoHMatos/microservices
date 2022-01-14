package com.github.thiagohmatos.foo.util;

import org.springframework.stereotype.Component;

@Component
public class Validate {

    public boolean isNumeric(String numberToValidate) {
        if (numberToValidate == null) return false;
        String number = numberToValidate.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
