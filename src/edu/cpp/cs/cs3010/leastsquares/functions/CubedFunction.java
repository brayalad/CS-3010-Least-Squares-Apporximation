package edu.cpp.cs.cs3010.leastsquares.functions;

public final class CubedFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.pow(x, 3);
    }

    @Override
    public String getDescription() {
        return "Cubed Function: x^3";
    }
}
