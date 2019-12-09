package edu.cpp.cs.cs3010.leastsquares.functions;

public final class DoubleSinFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.sin(2 * x);
    }

    @Override
    public String getDescription() {
        return "Double Sine Function: sin 2x";
    }
}
