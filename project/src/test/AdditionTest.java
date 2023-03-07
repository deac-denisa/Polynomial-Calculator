import model.Operations.Addition;
import model.Operations.StringToPolynomial;
import model.Polynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AdditionTest {
    @Test
    public void addTest(){

        Addition addOp = new Addition();
        StringToPolynomial st = new StringToPolynomial();

        //case with all positive values
        Polynomial p1 =  st.stringToPolynomial("2x^2 +5x +1");
        Polynomial p2 = st.stringToPolynomial("x^2 +7");
        String result = "3x^2 +5x +8";
        assertEquals(result, addOp.calculate(p1,p2).toString());

        //case with negative values and different coefficients
        p1 = st.stringToPolynomial("-x^4 +2x^2 -1");
        p2 = st.stringToPolynomial(("-8x^2 -1"));
        result = "-x^4 -6x^2 -2";
        assertEquals(result, addOp.calculate(p1,p2).toString());



    }
}
