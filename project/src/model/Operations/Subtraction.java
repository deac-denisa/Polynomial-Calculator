package model.Operations;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class Subtraction{

    public Polynomial calculate(Polynomial a, Polynomial b) {
        Polynomial result ;
        List<Monomial> resultList = new ArrayList<>();
        Monomial m;
        int i=0, j=0;

        while(i < a.getPolynomial().size() && j <  b.getPolynomial().size()){
            Monomial a1 = a.getPolynomial().get(i);
            Monomial b1 = b.getPolynomial().get(j);

            if(a1.getDegree() == b1.getDegree()){
                int c = a1.getCoeff() - b1.getCoeff();
                m = new Monomial(c, a1.getDegree());
                resultList.add(m);
                i++;
                j++;
            }
            else if( a1.getDegree() > b1.getDegree() ){
                m = new Monomial( a1.getCoeff(), a1.getDegree());
                resultList.add(m);
                i++;
            }
            else if(  a1.getDegree() < b1.getDegree() ){
                m = new Monomial(-b1.getCoeff(), b1.getDegree());
                resultList.add(m);
                j++;
            }
        }
        //add the rest
        while(i <  a.getPolynomial().size() ) {
            Monomial a1 = a.getPolynomial().get(i);
            m = new Monomial(a1.getCoeff(), a1.getDegree());
            resultList.add(m);
            i++;
        }
        while( j <  b.getPolynomial().size() ){
            Monomial b1 = b.getPolynomial().get(j);
            m = new Monomial(-b1.getCoeff(), b1.getDegree());
            resultList.add(m);
            j++;
        }

        result = new Polynomial(resultList);

        return result;

    }
}
