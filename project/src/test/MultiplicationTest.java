import model.Operations.Multiplication;
import model.Operations.StringToPolynomial;
import model.Polynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MultiplicationTest {

    @Test

    public void multiplyTest(){

        StringToPolynomial st = new StringToPolynomial();
        Multiplication mulOp= new Multiplication();

        //case with all positive values
        Polynomial p1 =  st.stringToPolynomial("2x^2 +5x +1");
        Polynomial p2 = st.stringToPolynomial("x^2 +7");
        String result = "2x^4 +5x^3 +15x^2 +35x +7";
        assertEquals(result, mulOp.calculate(p1,p2).toString());

        //case with negative values and different coefficients
        p1 = st.stringToPolynomial("-x^2 +2x -1");
        p2 = st.stringToPolynomial(("8x -1"));
        result = "-8x^3 +17x^2 -10x +1";
        assertEquals(result, mulOp.calculate(p1,p2).toString());
    }
}
