/**
 * This file pedagogical material for the course
 * CS 3010: Numerical Methods
 * taught at California State Polytechnic University - Pomona, and
 * cannot be used without express written consent from the author.
 *
 * Copyright (c) 2019 - Edwin Rodr&iacute;guez.
 */
package edu.cpp.cs.cs3010.leastsquares.models;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){ return x; }

    public double getY(){ return y; }

}
