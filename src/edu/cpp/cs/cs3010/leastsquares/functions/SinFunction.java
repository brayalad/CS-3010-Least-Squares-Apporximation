package edu.cpp.cs.cs3010.leastsquares.functions;

public final class SinFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.sin(x);
    }

    @Override
    public String getDescription() {
        return "Sine Function: sin x";
    }
}
