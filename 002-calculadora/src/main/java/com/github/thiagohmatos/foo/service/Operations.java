package com.github.thiagohmatos.foo.service;

import org.springframework.stereotype.Service;

@Service
public class Operations {

    public Double sum(Double numberOne, Double numberTwo) {
        final Double result = numberOne + numberTwo;
        return result;
    }

    public Double substraction(Double numberOne, Double numberTwo) {
        final Double result = numberOne - numberTwo;
        return result;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        final Double result = numberOne * numberTwo;
        return result;
    }

    public Double division(Double numberOne, Double numberTwo) {
        final Double result = numberOne / numberTwo;
        return result;
    }

    public Double average(Double numberOne, Double numberTwo) {
        final Double result = (numberOne + numberTwo) / 2;
        return result;
    }

    public Double square(Double number) {
        final Double result = Math.sqrt(number);
        return result;
    }

}
