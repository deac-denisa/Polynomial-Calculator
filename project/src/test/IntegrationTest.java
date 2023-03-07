import model.Operations.Integration;
import model.Operations.StringToPolynomial;
import model.DoublePolynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IntegrationTest {
    @Test
    public void integrateTest(){
        StringToPolynomial st = new StringToPolynomial();
        Integration integrateOp = new Integration();

        DoublePolynomial p1 =  st.stringToPolynomialD("2x^2 -5x +1");

        String result = "0.67x^3 -2.5x^2 +x";
        assertEquals(result, integrateOp.calculate(p1).toString());

    }
}
