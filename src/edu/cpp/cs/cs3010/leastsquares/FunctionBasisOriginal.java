/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares;

import edu.cpp.cs.cs3010.leastsquares.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class FunctionBasisOriginal {

    private List<Function> basis = new ArrayList<Function>();

    public void insertFunction(Function f) {
        basis.add(f);
    }

    public void removeFunction(int index) {
        basis.remove(index);
    }

    public int getBasisSize() {
        return basis.size();
    }

    public String getFunctionDescription(int index) {
        return basis.get(index).getDescription();
    }

    public double evaluateFunction(int index, double x) {
        return basis.get(index).eval(x);
    }

}
