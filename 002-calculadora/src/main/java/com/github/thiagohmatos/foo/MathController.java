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

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double substraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double substraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return substraction;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return multiplication;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if ((!isNumeric(numberOne) || !isNumeric(numberTwo)) || (isNumeric(numberTwo) && numberTwo.equals("0"))) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double average = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        return average;
    }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double square(@PathVariable("numberOne") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        final Double square = convertToDouble(number) * convertToDouble(number);
        return square;
    }

    private Double convertToDouble(String numberToConvert) {
        if (numberToConvert == null) return 0D;
        String number = numberToConvert.replaceAll(",", ".");
        if (isNumeric(numberToConvert)) {
            return Double.parseDouble(numberToConvert);
        } else {
            return 0D;
        }
    }

    private boolean isNumeric(String numberToValidate) {
        if (numberToValidate == null) return false;
        String number = numberToValidate.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
