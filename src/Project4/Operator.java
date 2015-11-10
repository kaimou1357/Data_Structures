package Project4;

/**
 * Created by Kai on 11/9/2015.
 * @author Kai
 * @date    11/9/2015
 */
public class Operator {
    char data;
    int precedence;
    public Operator(char operator){
        data = operator;
        if(operator == '(' || operator == ')'){
            precedence = 3;
        }
        else if(operator == '*'  || operator == '/'){
            precedence = 2;
        }
        else if(operator == '+' || operator == '-'){
            precedence = 1;
        }
    }

    public int getPrecedence(){
        return precedence;
    }

    public Character getData(){
        return data;
    }

    public void setData(Character c){ data = c;}



}
