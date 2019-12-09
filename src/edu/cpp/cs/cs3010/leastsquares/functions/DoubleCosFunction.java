package edu.cpp.cs.cs3010.leastsquares.functions;

public final class DoubleCosFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.cos(2 * x);
    }

    @Override
    public String getDescription() {
        return "Double Cosine Function: cos 2x";
    }
}
