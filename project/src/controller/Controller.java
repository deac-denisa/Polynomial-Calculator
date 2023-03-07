package controller;

import model.DoublePolynomial;
import model.Operations.*;
import model.Polynomial;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {

    private final View view;
    private static String selectedOp;
    private static Polynomial p1;
    private static Polynomial p2;
    private static DoublePolynomial dp1;
    private static DoublePolynomial dp2;

    public Controller(View view1) {

        this.view = view1;
        view.addOkListener(new OkListener());
        view.addSelectOperationListener(new OperationSelectedListener());
        view.addComputeListener(new ComputeListener());
        view.addExitListener(new ExitListener());
    }

    private class OperationSelectedListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getOperation()) {
                selectedOp = String.valueOf(view.getOperation().getSelectedItem());
            }
            //System.out.println(selectedOp);
        }
    }

    private class OkListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            StringToPolynomial st = new StringToPolynomial();

            if (e.getSource() == view.getOk()) {
                if(checkPolynomial(view.getPolynomial1(),1)==0 && checkPolynomial(view.getPolynomial2(),2)==0) {
                    p1 = st.stringToPolynomial(view.getPolynomial1());
                    p1.sortByDegree();
                    p2 = st.stringToPolynomial(view.getPolynomial2());
                    p2.sortByDegree();
                    dp1 = st.stringToPolynomialD((view.getPolynomial1()));
                    dp1.sortByDegree();
                    dp2 = st.stringToPolynomialD((view.getPolynomial2()));
                    dp2.sortByDegree();
                }
            }
        }
    }

    private class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getExit()) {
                view.dispose();
            }
        }
    }


    private class ComputeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == view.getCompute()) {
                p1 = st.stringToPolynomial(view.getPolynomial1());

                if (selectedOp.equals("Add")) {
                    Addition add = new Addition();
                    Polynomial result = add.calculate(p1, p2);
                    view.setResult(result.toString());
                } else if (selectedOp.equals("Subtract")) {
                    Subtraction subtract = new Subtraction();
                    Polynomial result = subtract.calculate(p1, p2);
                    view.setResult((result.toString()));
                } else if (selectedOp.equals("Multiply")) {
                    Multiplication multiply = new Multiplication();
                    Polynomial result = multiply.calculate(p1, p2);
                    view.setResult(result.toString());
                } else if (selectedOp.equals("Divide")) {
                    Division divide = new Division();
                    Polynomial resultQ = (divide.calculate(p1, p2)).get((0));
                    Polynomial resultR = (divide.calculate(p1, p2)).get((1));
                    view.setResult("quotient: " + resultQ.toString() + "\n" + "reminder: " + resultR.toString());
                } else if (selectedOp.equals("Integrate")) {
                    Integration integrate = new Integration();
                    DoublePolynomial result = integrate.calculate(dp1);
                    view.setResult(result.toString() + " +C");
                } else if (selectedOp.equals("Derivate")) {
                    Derivative derivate = new Derivative();
                    Polynomial result = derivate.calculate(p1);
                    view.setResult(result.toString());
                }
            }
        }
    }

    public static int checkPolynomial(String s, int nr_pol) {

        s = s.replaceAll("\\s+", "");

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(s);
        Polynomial polynomial;

    //    Pattern pattern1 = Pattern.compile(("[+-]?[0-9]*([Xx])?\\^?[0-9]*"));
        Matcher matcher1;
        while (matcher.find()) {
          //  matcher1 = pattern1.matcher(matcher.group(1));
            String str = matcher.group(1);
           System.out.println(str);

           String[] spl = str.split("[x^]");    //spl[]=coef, spl[1]=degree;


    /*        if (!matcher1.matches()) {
                JOptionPane.showMessageDialog(null, "Polynomial" + nr_pol+" is INVALID! Please try again.", "Invalid polynomial", JOptionPane.ERROR_MESSAGE);
                    return 1;
            }

     */
        }


        return 0;
    }


}
