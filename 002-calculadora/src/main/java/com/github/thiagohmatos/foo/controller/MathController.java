package com.github.thiagohmatos.foo.controller;

import com.github.thiagohmatos.foo.service.Operations;
import com.github.thiagohmatos.foo.util.Converter;
import com.github.thiagohmatos.foo.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    Operations operations;
    @Autowired
    Validate validate;
    @Autowired
    Converter converter;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.sum(converter.stringToDouble(numberOne), converter.stringToDouble(numberTwo));
    }

    @RequestMapping(value = "/substraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double substraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.substraction(converter.stringToDouble(numberOne), converter.stringToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.multiplication(converter.stringToDouble(numberOne), converter.stringToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if ((!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) || (validate.isNumeric(numberTwo) && numberTwo.equals("0"))) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.division(converter.stringToDouble(numberOne), converter.stringToDouble(numberTwo));
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!validate.isNumeric(numberOne) || !validate.isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.average(converter.stringToDouble(numberOne), converter.stringToDouble(numberTwo));
    }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double square(@PathVariable("number") String number) throws Exception {
        if (!validate.isNumeric(number)) {
            throw new UnsupportedOperationException("Invalid number informed");
        }
        return operations.square(converter.stringToDouble(number));
    }
}
