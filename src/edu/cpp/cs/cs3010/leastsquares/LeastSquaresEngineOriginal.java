/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares;

import edu.cpp.cs.cs3010.leastsquares.models.Point;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class LeastSquaresEngineOriginal {

    private FunctionBasisOriginal fb;

    private Point[] dataSet;

    private double[] coeff;

    private boolean dirty = true;

    public void setFunctionBasis(FunctionBasisOriginal fb) {
        dirty = true;
        this.fb = fb;
    }

    public FunctionBasisOriginal getFunctionBasis() {
        return fb;
    }

    public void setDataSet(Point[] ds) {
        dirty = true;
        dataSet = ds;
    }

    /*@ public normal_behavior
      @   requires dataSet != null && fb != null;
      @   modifies \nothing;
      @   ensures \result.size() == fb.size();
      @*/
    public double[] generateLSCoeff() {
        if (!dirty) {
            return coeff;
        }

        // TODO: Implementation of Least Squares algorithm goes here.

        dirty = false;
        return null;
    }

    public double evaluateApproxFunction(double x) {
        if (dirty) generateLSCoeff();

        double result = 0.0;

        for (int i = 0; i < fb.getBasisSize(); ++i) {
            result += coeff[i] * fb.evaluateFunction(i, x);
        }

        return result;
    }

}
