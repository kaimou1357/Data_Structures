package Project4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by Kai on 11/9/2015.
 */
public class CalculatorTest {

    @Test(expected=ArithmeticException.class)
    public void testDivideByZero() throws PostFixException{
        String equation = "2 / 0";
        ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
    }
    @Test(expected = PostFixException.class)
    public void testIllegalCharacters() throws PostFixException{
        String equation = "2 / a";
        ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
    }
    @Test
    public void testOperatorPrecedence() throws PostFixException{
        String equation = "2 * 2 - 1";
        int expected = 3;
        int result = ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
        Assert.assertEquals(expected, result);
    }
    @Test
    public void testEquationWithParentheses() throws PostFixException{
        String equation = "( 5 + 2 ) * ( 3 * 5 )";
        int expected = 105;
        int result = ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
        Assert.assertEquals(expected, result);
    }
    @Test (expected = PostFixException.class)
    public void testMissingParentheses()throws PostFixException{
        String equation = "( 2 + 2 + 3 ";
        ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
    }
    @Test (expected = PostFixException.class)
    public void testMisMatchedParentheses()throws PostFixException{
        String equation = " ( 3 + 4 ) ) - 5 (";
        ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
    }
    @Test
    public void testMoreThanOneDigit() throws PostFixException{
        String equation = "12 + 34 - 2";
        int expected = 44;
        int result = ExpressionTools.postFixEvaluate(ExpressionTools.infixToPostFix(equation));
        Assert.assertEquals(expected, result);
    }
}
