package edu.cpp.cs.cs3010.leastsquares;

import static java.util.Map.entry;

import edu.cpp.cs.cs3010.leastsquares.functions.ConstantFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.CosFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.CubedFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.DoubleCosFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.DoubleSinFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.Function;
import edu.cpp.cs.cs3010.leastsquares.functions.LinearFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.LinearLogFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.LogFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.SinFunction;
import edu.cpp.cs.cs3010.leastsquares.functions.SquaredFunction;
import edu.cpp.cs.cs3010.leastsquares.gaussian.GaussianElimination;
import edu.cpp.cs.cs3010.leastsquares.gaussian.NaiveGaussianElimination;
import edu.cpp.cs.cs3010.leastsquares.models.Point;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LSDriver {
    private static final String EXERCISE_STRING_FORMAT = "Exercise %s Results: %s";

    private static final Function CONSTANT_FUNCTION = new ConstantFunction();
    private static final Function LINEAR_FUNCTION = new LinearFunction();
    private static final Function SQUARED_FUNCTION = new SquaredFunction();
    private static final Function CUBED_FUNCTION = new CubedFunction();
    private static final Function LOG_FUNCTION = new LogFunction();
    private static final Function LINEAR_LOG_FUNCTION = new LinearLogFunction();
    private static final Function SIN_FUNCTION = new SinFunction();
    private static final Function COS_FUNCTION = new CosFunction();
    private static final Function DOUBLE_SIN_FUNCTION = new DoubleSinFunction();
    private static final Function DOUBLE_COS_FUNCTION = new DoubleCosFunction();

    private static final FunctionBasis EXERCISE_2A = new FunctionBasis(CONSTANT_FUNCTION, SQUARED_FUNCTION);
    private static final FunctionBasis EXERCISE_2B = new FunctionBasis(CONSTANT_FUNCTION, LOG_FUNCTION, LINEAR_FUNCTION, LINEAR_LOG_FUNCTION);
    private static final FunctionBasis EXERCISE_2C = new FunctionBasis(CONSTANT_FUNCTION, SIN_FUNCTION, COS_FUNCTION, DOUBLE_SIN_FUNCTION, DOUBLE_COS_FUNCTION);
    private static final FunctionBasis EXERCISE_2D = new FunctionBasis(CONSTANT_FUNCTION, LINEAR_FUNCTION, SQUARED_FUNCTION, CUBED_FUNCTION);

    private static final Map<String, FunctionBasis> EXERCISES = Map.ofEntries(
            entry("2A", EXERCISE_2A),
            entry("2B", EXERCISE_2B),
            entry("2C", EXERCISE_2C),
            entry("2D", EXERCISE_2D)
    );

    private static final Set<Point> DATA_SET = Set.of(
            new Point(0, 2.1),
            new Point(1, 0.13),
            new Point(2, 3.14),
            new Point(3, 5),
            new Point(4, 7),
            new Point(5, 9.5),
            new Point(6, 4.15)
    );

    private static final List<Double> EVALUATE_AT = List.of(0.5, 1.618, 2.35, 3.5, 4.2);

    public static void main(final String ...args){

    final GaussianElimination gaussianElimination = new NaiveGaussianElimination();
    final LeastSquaresAlgorithm leastSquaresAlgorithm = new LeastSquaresAlgorithm(gaussianElimination);
    final LeastSquaresEngine leastSquares = new LeastSquaresEngine(leastSquaresAlgorithm);

    for(final String exercise : EXERCISES.keySet()){
        System.out.println(String.format(EXERCISE_STRING_FORMAT, exercise, leastSquares.evaluate(EXERCISES.get(exercise), DATA_SET, EVALUATE_AT)));
    }
    }
}
