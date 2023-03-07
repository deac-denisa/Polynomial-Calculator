package model;

public class Monomial {
    private int coeff;
    private int degree;

    public Monomial(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
