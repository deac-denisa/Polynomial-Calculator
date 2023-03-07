package model.Operations;

import model.DoubleMonomial;
import model.DoublePolynomial;
import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class StringToPolynomial {

    public Polynomial stringToPolynomial(String a){
        int i=0, coeff=0, degree=0;
        String[] s = a.split("[\s]");          ///split by spaces and +
        List<Monomial> mList = new ArrayList<>();

        while(i < s.length) {

            if (s[i].length()<=2 && s[i].charAt(0) !='-' ) {
                if(s[i].equals("+x") || s[i].equals("x")){           // elem has coef 1 degree 1 =>x
                    coeff=1;
                    degree=1;
                }
                else {
                    if(s[i].charAt(0)=='+'){                                 //elem has degree 0;
                        coeff = Integer.parseInt(s[i].substring(1));
                        degree = 0;
                    }else{
                        coeff = Integer.parseInt(String.valueOf(s[i].charAt(0)));
                        degree=1;
                    }
                }
            }
            else {
                if (s[i].charAt(0)== '-' ) {            //like -x => nr[]0] = -
                    if( s[i].charAt(1) == 'x') {
                        coeff = -1;
                        if (s[i].length() == 2) {
                            degree = 1;
                        } else {
                            String[] nr = s[i].split("[x^]");
                            degree = Integer.parseInt(nr[2]);       // -x^2
                        }
                    }
                    else {
                        if (s[i].length() == 2) {
                            coeff = Integer.parseInt(s[i]);
                            degree = 0;
                        } else if(s[i].length() == 3){
                            String[] nr = s[i].split("[x^]");
                            coeff = Integer.parseInt(nr[0]);
                            degree=1;
                        } else {
                            String[] nr = s[i].split("[x^]");
                            coeff = Integer.parseInt(nr[0]);
                            degree = Integer.parseInt(nr[2]);
                        }
                    }
                } else if ( (s[i].charAt(0)== '+'&& s[i].charAt(1)=='x') ) {                    // x^2
                    coeff = 1;
                    degree = Integer.parseInt(String.valueOf(s[i].charAt(3)));

                }else if(s[i].charAt(0)== 'x' ){
                    coeff = 1;
                    degree = Integer.parseInt(String.valueOf(s[i].charAt(2)));
                }
                else {
                    String[] nr = s[i].split("[x^]");
                    coeff = Integer.parseInt(nr[0]);
                    if(nr.length==1){
                        degree=1;
                    }else
                        degree = Integer.parseInt(nr[2]);
                }
            }
            mList.add(new Monomial(coeff, degree));
            i++;
        }
        Polynomial p = new Polynomial(mList);
        return p;
    }



    public DoublePolynomial stringToPolynomialD(String a){
        int i=0, coeff=0, degree=0;
        String[] s = a.split("[\s]");          ///split by spaces and +
        List<DoubleMonomial> mList = new ArrayList<>();

        while(i < s.length) {

            if (s[i].length()<=2 && s[i].charAt(0) !='-' ) {
                if(s[i].equals("+x") || s[i].equals("x")){           // elem has coef 1 degree 1 =>x
                    coeff=1;
                    degree=1;
                }
                else {
                    if(s[i].charAt(0)=='+'){                                 //elem has degree 0;
                        coeff = Integer.parseInt(s[i].substring(1));
                        degree = 0;
                    }else{
                        coeff = Integer.parseInt(String.valueOf(s[i].charAt(0)));
                        degree=1;
                    }
                }
            }
            else {
                if (s[i].charAt(0)== '-' ) {            //like -x => nr[]0] = -
                    if( s[i].charAt(1) == 'x') {
                        coeff = -1;
                        if (s[i].length() == 2) {
                            degree = 1;
                        } else {
                            String[] nr = s[i].split("[x^]");
                            degree = Integer.parseInt(nr[2]);       // -x^2
                        }
                    }
                    else {
                        if (s[i].length() == 2) {
                            coeff = Integer.parseInt(s[i]);
                            degree = 0;
                        } else if(s[i].length() == 3) {
                            String[] nr = s[i].split("[x^]");
                            coeff = Integer.parseInt(nr[0]);
                            degree = 1;
                        } else {
                            String[] nr = s[i].split("[x^]");
                            coeff = Integer.parseInt(nr[0]);
                            degree = Integer.parseInt(nr[2]);
                        }
                    }
                } else if ( (s[i].charAt(0)== '+'&& s[i].charAt(1)=='x') ) {                    // x^2
                    coeff = 1;
                    degree = Integer.parseInt(String.valueOf(s[i].charAt(3)));

                }else if(s[i].charAt(0)== 'x' ){
                    coeff = 1;
                    degree = Integer.parseInt(String.valueOf(s[i].charAt(2)));
                }
                else {
                    String[] nr = s[i].split("[x^]");
                    coeff = Integer.parseInt(nr[0]);
                    if(nr.length==1){
                        degree=1;
                    }else
                        degree = Integer.parseInt(nr[2]);
                }
            }
            mList.add(new DoubleMonomial(coeff, degree));
            i++;
        }
        DoublePolynomial p = new DoublePolynomial(mList);
        return p;
    }

}
