package model;

import java.util.*;

public class Polynomial {
    private List<Monomial> polynomial = new ArrayList<>();

    public Polynomial(List<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public List<Monomial> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(List<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    //sort polynomial by degree
    public void sortByDegree() {
        Collections.sort(polynomial, new Comparator<Monomial>(){
            @Override
            public int compare(Monomial o1, Monomial o2) {
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
        for(Monomial m: this.polynomial) {

            if (polynomial.indexOf(m) != 0 && m.getCoeff() > 0) {
                p = p.concat(" +");
            }
            if( polynomial.indexOf(m) != 0 && m.getCoeff() < 0){
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
