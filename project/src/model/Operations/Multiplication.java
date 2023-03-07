package model.Operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class Multiplication{

    public Polynomial calculate(Polynomial a, Polynomial b) {

        List<Monomial> resultList = new ArrayList<>();

        for(Monomial a1: a.getPolynomial()){
            for(Monomial b1: b.getPolynomial()){
                int coeffM = a1.getCoeff()* b1.getCoeff();
                int degM = a1.getDegree() + b1.getDegree();
                resultList.add(new Monomial(coeffM, degM));
            }
        }

        Polynomial resultM= new Polynomial(resultList);
        resultM.sortByDegree();

        //add elem with the same degree
        int rCoef = 0,i = 0, prevDeg = -1;
        List<Monomial> sorted = new ArrayList<>();
        for(Monomial m: resultM.getPolynomial()){
            if(prevDeg == -1){
                rCoef = m.getCoeff();
                prevDeg = m.getDegree();
            }
            else if(prevDeg == m.getDegree()){
                rCoef= rCoef+ m.getCoeff();
            }
            else if (prevDeg != m.getDegree()){
                sorted.add(new Monomial(rCoef, prevDeg));
                prevDeg = m.getDegree();
                rCoef=m.getCoeff();
            }
        }
        sorted.add(new Monomial(rCoef, prevDeg));

        resultM.setPolynomial(sorted);

        return resultM;
    }


}
