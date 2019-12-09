package edu.cpp.cs.cs3010.leastsquares.models;

import edu.cpp.cs.cs3010.leastsquares.functions.Function;

import java.util.List;

public final class FunctionBasis {
    private final List<Function> basis;

    public FunctionBasis(final Function ...functions){
        this(List.of(functions));
    }

     public FunctionBasis(final List<Function> functions){
        this.basis = List.copyOf(functions);
    }

    public Function getFunction(final int index){ return basis.get(index); }

    public List<Function> getBasis(){ return basis; }

    public int getBasisSize(){ return basis.size(); }

    public String getFunctionDescription(final int index){ return basis.get(index).getDescription(); }

    public double evaluateFunction(final int index, final double x){ return basis.get(index).eval(x); }

}
