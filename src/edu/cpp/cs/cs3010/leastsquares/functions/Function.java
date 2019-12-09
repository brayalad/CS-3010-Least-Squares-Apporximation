/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares.functions;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface Function extends java.util.function.Function<Double, Double> {

    @Override
    default Double apply(Double aDouble) {
        return eval(aDouble);
    }

    default double eval(Double x){
        return eval(x.doubleValue());
    }

    double eval(double x);

    String getDescription();

}
