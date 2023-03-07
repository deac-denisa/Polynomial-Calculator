package model;

public class DoubleMonomial {

    private double coeff;
    private int degree;

    public DoubleMonomial(double coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
