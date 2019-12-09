package edu.cpp.cs.cs3010.leastsquares.functions;

public final class LogFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.log(x);
    }

    @Override
    public String getDescription() {
        return "Log Function: log x";
    }
}
