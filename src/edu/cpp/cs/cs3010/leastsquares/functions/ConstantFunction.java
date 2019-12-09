package edu.cpp.cs.cs3010.leastsquares.functions;

public final class ConstantFunction implements Function {
    @Override
    public double eval(double x) {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Constant Function: 1";
    }
}
