import model.Operations.StringToPolynomial;
import model.Operations.Subtraction;
import model.Polynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SubtractionTest {

    @Test

    public void subtractTest(){
        Subtraction subtractOp = new Subtraction();
        StringToPolynomial st = new StringToPolynomial();

        //case with all positive values
        Polynomial p1 =  st.stringToPolynomial("2x^2 +5x +1");
        Polynomial p2 = st.stringToPolynomial("x^2 +7");
        String result = "x^2 +5x -6";
        assertEquals(result, subtractOp.calculate(p1,p2).toString());

        //case with negative values and different coefficients
        p1 = st.stringToPolynomial("x^2 +2x -1");
        p2 = st.stringToPolynomial(("8x^2 -1"));
        result = "-7x^2 +2x";
        assertEquals(result, subtractOp.calculate(p1,p2).toString());
    }
}
