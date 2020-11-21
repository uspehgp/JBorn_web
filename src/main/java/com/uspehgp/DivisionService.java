package com.uspehgp;

public class DivisionService {
    public double divide(double a, double b){
        if(b==0.0){
            throw new IllegalArgumentException();
        }
        return a/b;
    }
}
