package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoublePolynomial {
    private List<DoubleMonomial> polynomialD = new ArrayList<>();

    public DoublePolynomial(List<DoubleMonomial> polynomialD) {
        this.polynomialD = polynomialD;
    }

    public List<DoubleMonomial> getPolynomialD() {
        return polynomialD;
    }

    public void setPolynomialD(List<DoubleMonomial> polynomialD) {
        this.polynomialD = polynomialD;
    }

    //sort polynomial by degree
    public void sortByDegree() {
        Collections.sort(polynomialD, new Comparator<DoubleMonomial>(){

            @Override
            public int compare(DoubleMonomial o1, DoubleMonomial o2) {
                if(o1.getDegree() > o2.getDegree()){
                    return -1;
                }
                else if( o1.getDegree() == o2.getDegree()){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
    }

    @Override
    public String toString() {

        String p = "";
        for(DoubleMonomial m: this.polynomialD) {

            if (polynomialD.indexOf(m) != 0 && m.getCoeff() > 0) {
                p = p.concat(" +");
            }
            if( polynomialD.indexOf(m) != 0 && m.getCoeff() < 0){
                p=p.concat(" ");
            }
            if(m.getCoeff() != 0){
                if(m.getDegree()==0){
                    p=p.concat(String.valueOf(m.getCoeff()));
                }else if(m.getDegree()==1){
                    if(m.getCoeff()==1){
                        p=p.concat("x");
                    }else {
                        p = p.concat(m.getCoeff() + "x");
                    }
                }else if(m.getDegree()>1){
                    if(m.getCoeff() == 1){
                        p=p.concat(("x^"+m.getDegree()));
                    }else if(m.getCoeff() == -1) {
                        p=p.concat("-x^"+m.getDegree());
                    }else{
                        p = p.concat((m.getCoeff() + "x^" + m.getDegree()));
                    }
                }
            }
        }
        return p;
    }
}
