package edu.cpp.cs.cs3010.leastsquares;

import edu.cpp.cs.cs3010.leastsquares.models.Point;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeastSquaresEngine {
    private final LeastSquaresAlgorithm leastSquares;

    public LeastSquaresEngine(final LeastSquaresAlgorithm leastSquares){
        this.leastSquares = leastSquares;
    }


    public List<Double> evaluate(final FunctionBasis basis, final Set<Point> dataSet, final List<Double> evaluateAt){
        return evaluateAt.stream().map(x -> leastSquares.evaluateApproxFunction(x, basis, dataSet)).collect(Collectors.toList());
    }

}
