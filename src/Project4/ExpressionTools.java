package Project4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Kai on 11/1/2015.
 * @author Kai
 * @date   11/4/2015
 */
public class ExpressionTools {
    private ExpressionTools() {
    }
    //Static class so declare ExpressionTools constructor private.

    /**
     * This method is taken from Joanna Klukowska's lecture notes.
     *
     * @param expression
     * @return
     * @throws PostFixException
     */
    public static int postFixEvaluate(String expression) throws PostFixException, ArithmeticException {
        MyStack<Integer> stack = new MyStack<>();

        int value;
        String operator;

        int operand1;
        int operand2;

        int result = 0;

        Scanner tokenizer = new Scanner(expression);

        while (tokenizer.hasNext()) {
            if (tokenizer.hasNextInt()) {
                // Process operand.
                value = tokenizer.nextInt();

                stack.push(value);
            } else {
                // Process operator.
                operator = tokenizer.next();

                // Obtain second operand from stack.
                if (stack.isEmpty()) {
                    tokenizer.close();
                    throw new PostFixException(
                            "Not enough operands - stack underflow");
                }
                operand2 = stack.peek();
                stack.pop();

                // Obtain first operand from stack.
                if (stack.isEmpty()) {
                    tokenizer.close();
                    throw new PostFixException(
                            "Not enough operands - stack underflow");
                }
                operand1 = stack.peek();
                stack.pop();

                // Perform operation.
                if (operator.equals("/")) {
                    if (operand2 == 0) {
                        throw new ArithmeticException("Divide by Zero");
                    }
                    result = operand1 / operand2;
                } else if (operator.equals("*"))
                    result = operand1 * operand2;
                else if (operator.equals("+"))
                    result = operand1 + operand2;
                else if (operator.equals("-"))
                    result = operand1 - operand2;
                else {
                    tokenizer.close();
                    throw new PostFixException("Illegal symbol: " + operator);
                }

                // Push result of operation onto stack.
                stack.push(result);
            }
        }

        tokenizer.close();

        // Obtain final result from stack.
        if (stack.isEmpty())
            throw new PostFixException("Not enough operands - stack underflow");
        result = stack.peek();
        stack.pop();

        // Stack should now be empty.
        if (!stack.isEmpty())
            throw new PostFixException("Too many operands - operands left over");

        // Return the final.
        return result;
    }

    /**
     * This method converts infix expressions to Postfix operations.
     *
     * @param message String to be evaluated
     * @return Returns a postfix expression.
     */

    public static String infixToPostFix(String message) throws PostFixException {
        MyStack<Character> operatorStack = new MyStack<Character>();
        String postFixResult = "";
        Scanner tokenizer = new Scanner(message);

        while (tokenizer.hasNext()) {
            if (tokenizer.hasNextInt()) {
                postFixResult += " " + tokenizer.nextInt();
            } else {
                String value = tokenizer.next();
                Operator op = new Operator(value.charAt(0));
                char c = value.charAt(0);
                String operators = "*/-+()";

                if (!isOperator(c)) {
                    //If the character is not an operator or a left parentheses.
                    throw new PostFixException("Invalid Operator");
                } else {
                    if (c == ')') {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            postFixResult += " " + operatorStack.pop();
                        }
                        if (!operatorStack.isEmpty()) {
                            operatorStack.pop();
                        }
                    }
                    else {
                        if (!operatorStack.isEmpty() && !isLowerPrecedence(c, operatorStack.peek())) {
                            operatorStack.push(c);
                        }
                        else {
                            while (!operatorStack.isEmpty() && isLowerPrecedence(c, operatorStack.peek())) {
                                Character pop = operatorStack.pop();
                                if (c != '(') {
                                    postFixResult += " " + pop;
                                } else {
                                    c = pop;
                                }

                            }
                            operatorStack.push(c);
                        }
                    }
                }

            }
        }
        while (!operatorStack.isEmpty()) {
            postFixResult += " " + operatorStack.pop();
        }

        return postFixResult;
    }

    /**
     * Method that returns true if c is an operator.
     * @param c
     * @return
     */
    private static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
                || c == '(' || c == ')';
    }

    /**
     * Determines whether or not the character is actually a number.
     * @param c
     * @return true if character is number false, otherwise.
     */
    private boolean isNumber(char c){
        return Character.isDigit(c);
    }

    /**
     * A method to determine precedence of operators.
     * @param c1 Operator 1
     * @param c2 Operator 2
     * @return true if c2 is lower precedence than c1.
     */
    private static boolean isLowerPrecedence(char c1, char c2)
    {
        switch (c1)
        {
            case '+':
            case '-':
                return !(c2 == '+' || c2 == '-');

            case '*':
            case '/':
                return c2 == '^' || c2 == '(';

            case '^':
                return c2 == '(';

            case '(':
                return true;

            default:
                //means that the character must have passed through as something else.
                return false;
        }
    }

}
