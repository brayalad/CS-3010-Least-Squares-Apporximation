package edu.cpp.cs.cs3010.leastsquares.functions;

public interface Function extends java.util.function.Function<Double, Double> {

    @Override
    default Double apply(Double aDouble) {
        return eval(aDouble);
    }

    default double eval(Double x){
        return eval(x.doubleValue());
    }

    double eval(double x);

    String getDescription();

}
