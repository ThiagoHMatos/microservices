package com.github.thiagohmatos.foo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    private Double convertToDouble(String numberToConvert) {
        if(numberToConvert == null ) return 0D;
        String number = numberToConvert.replaceAll(",", ".");
        if (isNumeric(numberToConvert)) {
            return Double.parseDouble(numberToConvert);
        } else {
            return 0D;
        }
    }

    private boolean isNumeric(String numberToValidate) {
        if(numberToValidate == null) return false;
        String number = numberToValidate.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
