package Project4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Kai on 11/1/2015.
 * @author Kai
 * @date   11/4/2015
 */
public class ExpressionTools {
    private ExpressionTools(){}
    //Static class so declare ExpressionTools constructor private.

    /**
     * This method is taken from Joanna Klukowska's lecture notes.
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
                    if (operand2 == 0){
                        throw new ArithmeticException("Divide by Zero");
                    }
                    result = operand1 / operand2;
                }
                else if (operator.equals("*"))
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

    public static String infixToPostFix(String message){
        MyStack<Character> operatorStack = new MyStack<Character>();
        String postFixResult = "";
        Scanner tokenizer = new Scanner(message);

        while(tokenizer.hasNext()){

        }

        return null;


    }

}
