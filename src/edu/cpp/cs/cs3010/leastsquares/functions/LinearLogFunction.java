package edu.cpp.cs.cs3010.leastsquares.functions;

public final class LinearLogFunction implements Function {
    @Override
    public double eval(double x) {
        return x * Math.log(x);
    }

    @Override
    public String getDescription() {
        return "Linear Log Function: x log x";
    }
}
