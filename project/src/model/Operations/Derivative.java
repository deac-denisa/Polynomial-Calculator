package model.Operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class Derivative  {

    public Polynomial calculate (Polynomial a){
        List<Monomial> resultList = new ArrayList<>();

        for(Monomial m : a.getPolynomial()){
            m.setCoeff(m.getCoeff()*m.getDegree());
            m.setDegree(m.getDegree() - 1 );
        }

        int sizeA = a.getPolynomial().size()-1;
        if(a.getPolynomial().get(sizeA).getDegree() == -1) {
            a.getPolynomial().remove(sizeA);
        }
        return a;
    }

}

