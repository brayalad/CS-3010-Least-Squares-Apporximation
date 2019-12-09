package edu.cpp.cs.cs3010.leastsquares.functions;

public final class CosFunction implements Function {
    @Override
    public double eval(double x) {
        return Math.cos(x);
    }

    @Override
    public String getDescription() {
        return "Cosine Function: cos x";
    }
}
