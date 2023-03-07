package model.Operations;

import model.Monomial;
import model.Polynomial;


import java.util.ArrayList;
import java.util.List;

public class Division {

    public List<Polynomial> calculate(Polynomial a, Polynomial b) {

        Polynomial remainder = new Polynomial(a.getPolynomial());
        List<Monomial> q= new ArrayList<>();
        Polynomial quotient = new Polynomial(q) ;

        while(remainder.getPolynomial().get(0).getDegree() >= b.getPolynomial().get(0).getDegree()){

            int qDeg =  remainder.getPolynomial().get(0).getDegree()-b.getPolynomial().get(0).getDegree();
            int qCoef = remainder.getPolynomial().get(0).getCoeff()/b.getPolynomial().get(0).getCoeff();

            Monomial qm= new Monomial(qCoef,qDeg );
            q.add(qm);                                       //add monomial to quotient
            quotient.setPolynomial(q);

            List<Monomial> qaux= new ArrayList<>();
            qaux.add(qm);                                   //make a polynomial only with the current monomial
            Polynomial mulAux = new Polynomial( qaux);

            Multiplication multiplication = new Multiplication();
            Subtraction subtraction = new Subtraction();
            List<Monomial> remList = subtraction.calculate(remainder, multiplication.calculate(b,mulAux) ).getPolynomial() ;
            remList.remove(0);
            remainder.setPolynomial(remList);

          }

       List<Polynomial> result = new ArrayList<>();
        result.add(quotient);
        result.add(remainder);

        return result;
    }
}
