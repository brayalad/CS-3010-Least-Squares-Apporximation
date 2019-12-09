/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares;

import java.util.Arrays;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class LSDriverExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double[] testPoints = {0.42, 1.25, 2.11};

        double[] linearRegResults = linearRegressionTest(testPoints);

        System.out.println(Arrays.toString(linearRegResults));
    }

    private static double[] linearRegressionTest(double evalPoints[]) {
        double[] results = new double[evalPoints.length];

        FunctionBasis fb = new FunctionBasis();

        fb.insertFunction(
                new Function() {
                    @Override
                    public double eval(double x) {
                        return 1;
                    }

                    @Override
                    public String getDescription() {
                        return "Constant Function: 1";
                    }
                });

        fb.insertFunction(
                new Function() {
                    @Override
                    public double eval(double x) {
                        return x;
                    }

                    @Override
                    public String getDescription() {
                        return "Linear Function: x";
                    }
                });

        Point[] dataSet = {new Point(0.0,3.0), new Point(1.0,3.14), new Point(2.0,1.618)};

        LeastSquaresEngine lse = new LeastSquaresEngine();
        lse.setDataSet(dataSet);
        lse.setFunctionBasis(fb);

        lse.generateLSCoeff();

        for (int i = 0; i < evalPoints.length; ++i) {
            results[i] = lse.evaluateApproxFunction(evalPoints[i]);
        }

        return results;
    }

}
