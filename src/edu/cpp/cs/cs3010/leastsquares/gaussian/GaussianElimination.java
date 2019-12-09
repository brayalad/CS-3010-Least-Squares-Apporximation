package edu.cpp.cs.cs3010.leastsquares.gaussian;

import edu.cpp.cs.cs3010.leastsquares.models.Coefficients;
import edu.cpp.cs.cs3010.leastsquares.models.Constants;
import edu.cpp.cs.cs3010.leastsquares.models.GaussianMatrix;

import java.util.List;

public interface GaussianElimination {

    List<Double> gaussianElimination(Coefficients<Double> coefficients, Constants<Double> constants, final List<Integer> ind);

    GaussianMatrix<Double> forwardElimination(Coefficients<Double> coefficients, Constants<Double> constants, List<Integer> ind);

    List<Double> backSubstitution(Coefficients<Double> coefficients, Constants<Double> constants, List<Integer> ind);

}
