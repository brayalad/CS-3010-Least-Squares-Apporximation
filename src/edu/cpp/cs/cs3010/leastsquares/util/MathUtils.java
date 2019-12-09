package edu.cpp.cs.cs3010.leastsquares.util;

import edu.cpp.cs.cs3010.leastsquares.functions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MathUtils {

    private MathUtils(){}

    public static double mean(final double[] data){
        return mean(arrayToCollection(data));
    }

    public static double mean(final Collection<Double> data){
        return (sum(data) / data.size());
    }

    public static double sum(final double[] data){
        return sum(arrayToCollection(data));
    }

    public static double sum(final Collection<Double> data){
        return data.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double sumOfSquares(final double[] data){
        return sumOfSquares(arrayToCollection(data));
    }

    public static double sumOfSquares(final Collection<Double> data){
        return sum(data.stream().map(x -> x * x).collect(Collectors.toList()));
    }

    public static List<Double> applyFunctions(final Collection<Double> data, final Function f1, final Function f2){
        return data.stream().map(x -> (f1.eval(x) * f2.eval(x))).collect(Collectors.toList());
    }

    public static double sumOfFunctions(final Collection<Double> data, final Function f1, final Function f2){
        return sum(applyFunctions(data, f1, f2));
    }






    private static Collection<Double> arrayToCollection(double[] data){
        return Arrays.stream(data).boxed().collect(Collectors.toList());
    }




}
