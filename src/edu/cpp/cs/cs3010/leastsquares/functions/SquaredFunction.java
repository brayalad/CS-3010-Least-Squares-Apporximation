package edu.cpp.cs.cs3010.leastsquares.functions;

public final class SquaredFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.pow(x, 2);
    }

    @Override
    public String getDescription() {
        return "Squared Function: x^2";
    }
}
