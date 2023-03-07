package model.Operations;

import model.DoubleMonomial;
import model.DoublePolynomial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Integration {

    public DoublePolynomial calculate(DoublePolynomial a){

        List<DoubleMonomial> polynomialD = new ArrayList<>();

        for(DoubleMonomial m: a.getPolynomialD() ){
            double c =  m.getCoeff()/(1.0*( m.getDegree() + 1 ) );
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            m.setCoeff(Double.parseDouble(numberFormat.format(c)));
            m.setDegree( m.getDegree() + 1);
        }
        return a;
    }
}
