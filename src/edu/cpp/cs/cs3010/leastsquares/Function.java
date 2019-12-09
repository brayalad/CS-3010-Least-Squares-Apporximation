/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public interface Function {

    double eval(double x);

    String getDescription();

}
