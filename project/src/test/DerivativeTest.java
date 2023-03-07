import model.Operations.Derivative;
import model.Operations.StringToPolynomial;
import model.Polynomial;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DerivativeTest {
    @Test
    public void derivateTest(){
        StringToPolynomial st = new StringToPolynomial();
        Derivative derivateOp = new Derivative();

        //case with all positive values
        Polynomial p1 =  st.stringToPolynomial("x^2 -5x +1");
        String result = "2x -5";
        assertEquals(result, derivateOp.calculate(p1).toString());


    }
}
