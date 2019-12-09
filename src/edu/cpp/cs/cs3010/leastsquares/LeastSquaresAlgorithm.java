package edu.cpp.cs.cs3010.leastsquares;

import static edu.cpp.cs.cs3010.leastsquares.util.MathUtils.sum;
import static edu.cpp.cs.cs3010.leastsquares.util.MathUtils.sumOfFunctions;

import edu.cpp.cs.cs3010.leastsquares.functions.Function;
import edu.cpp.cs.cs3010.leastsquares.gaussian.GaussianElimination;
import edu.cpp.cs.cs3010.leastsquares.models.Coefficients;
import edu.cpp.cs.cs3010.leastsquares.models.Constants;
import edu.cpp.cs.cs3010.leastsquares.models.GaussianMatrix;
import edu.cpp.cs.cs3010.leastsquares.models.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeastSquaresAlgorithm {
   final GaussianElimination gaussianElimination;

   public LeastSquaresAlgorithm(final GaussianElimination gaussianElimination){
       this.gaussianElimination = gaussianElimination;
   }

    public double evaluateApproxFunction(final double x, final FunctionBasis basis, final Point[] dataSet){
       return evaluateApproxFunction(x, basis, Arrays.asList(dataSet));
    }

    public double evaluateApproxFunction(final double x, final FunctionBasis basis, final Collection<Point> dataSet){
       return evaluateApproxFunction(x, basis, Set.copyOf(dataSet));
    }

   public double evaluateApproxFunction(final double x, final FunctionBasis basis, final Set<Point> dataSet){
        final List<Double> lsCoefficients = generateLSCoefficients(basis, dataSet);

        final int n = basis.getBasisSize();
        if(lsCoefficients.size() != n)
            throw new RuntimeException("Basis and LS Coefficients are not same size.");

        double result = 0.0;
        for(int i = 0; i < n; ++i){
            result += (lsCoefficients.get(i) * basis.evaluateFunction(i, x));
        }

       return result;
   }

   public List<Double> generateLSCoefficients(final FunctionBasis basis, final Point[] dataSet){
       return generateLSCoefficients(basis, Arrays.asList(dataSet));
   }

   public List<Double> generateLSCoefficients(final FunctionBasis basis, final Collection<Point> dataSet){
       return generateLSCoefficients(basis, Set.copyOf(dataSet));
   }

   public List<Double> generateLSCoefficients(final FunctionBasis basis, final Set<Point> dataSet){
        final GaussianMatrix<Double> matrix = generateMatrix(basis, dataSet);

       return gaussianElimination.gaussianElimination(matrix.getCoefficients(), matrix.getConstants(), matrix.getInd());
   }

   private GaussianMatrix<Double> generateMatrix(final FunctionBasis basis, final Set<Point> dataSet){
       final Coefficients<Double> coefficients = generateSumCoefficients(basis, dataSet.stream().map(Point::getX).collect(Collectors.toList()));
       final Constants<Double> constants = generateConstantsList(basis, dataSet);

       return new GaussianMatrix<>(basis.getBasisSize(), coefficients, constants);
   }

   private Coefficients<Double> generateSumCoefficients(final FunctionBasis basis, final Collection<Double> xPoints){
       final int size = basis.getBasisSize();

       final double[][] matrix = new double[size][size];
       for(int i = 0; i < size; ++i){
           for(int j = 0; j < size; ++j){
               matrix[i][j] = sumOfFunctions(xPoints, basis.getFunction(i), basis.getFunction(j));
           }
       }

       final List<List<Double>> coefficients = new ArrayList<>(size);
       for(int i = 0; i < size; ++i){
           final List<Double> row = new ArrayList<>(size);
           for(int j = 0; j < size; ++j){
               row.add(matrix[i][j]);
           }
           coefficients.add(row);
       }

       return new Coefficients<>(coefficients);
   }

   private Constants<Double> generateConstantsList(final FunctionBasis basis, final Set<Point> ds){
       return new Constants<>(basis.getBasis().stream().map(f -> sum(ds.stream().map(p -> (p.getY() * f.eval(p.getX()))).collect(Collectors.toList()))).collect(Collectors.toList()));
   }

}
