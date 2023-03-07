import model.Operations.Division;
import model.Operations.StringToPolynomial;
import model.Polynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DivisionTest {
    @Test
    public void divideTest(){

        StringToPolynomial st = new StringToPolynomial();
        Division divOp= new Division();

        Polynomial p1 =  st.stringToPolynomial("x^3 -2x^2 +6x -5");
        Polynomial p2 = st.stringToPolynomial("x^2 -1");
        String quotient = "x -2";
        String reminder = "7x -7";
        assertEquals(quotient, divOp.calculate(p1,p2).get(0).toString());
        assertEquals(reminder, divOp.calculate(p1,p2).get(1).toString());

    }
}
