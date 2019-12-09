package edu.cpp.cs.cs3010.leastsquares.functions;

public final class LinearFunction implements Function {
    @Override
    public double eval(double x) {
        return x;
    }

    @Override
    public String getDescription() {
        return "Linear Function: x";
    }
}
