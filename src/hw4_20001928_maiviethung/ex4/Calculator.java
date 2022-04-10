package hw4_20001928_maiviethung.ex4;

import java.util.Arrays;

import hw4_20001928_maiviethung.ex2.LinkedListStack;

public class Calculator {

    private LinkedListStack<Character> operatorStack;
    private LinkedListStack<Double> valueStack;

    public Calculator() {
        operatorStack = new LinkedListStack<Character>();
        valueStack = new LinkedListStack<Double>();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    private void processOperator(char t) {
        double a, b;

        b = valueStack.top();
        valueStack.pop();

        a = valueStack.top();
        valueStack.pop();
        double r = 0;
        if (t == '+') {
            r = a + b;
        } else if (t == '-') {
            r = a - b;
        } else if (t == '*') {
            r = a * b;
        } else if (t == '/') {
            r = a / b;
        }
        valueStack.push(r);
    }

    private static boolean isValid(String str) {
        LinkedListStack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            }

            if (str.charAt(i) == ')') {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println("the expression is in valid");
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public void processInput(String input) {
        if (!isValid(input)) return;
        
        // The tokens that make up the input
        input = input.replaceAll("\s", "");
        String[] tokens = input.split("");

        System.out.println(Arrays.toString(tokens));
        for (int i = 0; i < tokens.length; i++) {
            char token = tokens[i].charAt(0);
            // System.out.println(token);
            if (token >= '0' && token <= '9') {
                double value = Double.parseDouble(String.valueOf(token));
                valueStack.push(value);
            } else if (isOperator(token)) {
                if (operatorStack.isEmpty() || getPrecedence(token) > getPrecedence(operatorStack.top())) {
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.isEmpty() && getPrecedence(token) <= getPrecedence(operatorStack.top())) {
                        char toProcess = operatorStack.top();
                        operatorStack.pop();
                        processOperator(toProcess);
                    }
                    operatorStack.push(token);
                }
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (!operatorStack.isEmpty() && isOperator(operatorStack.top())) {
                    char toProcess = operatorStack.top();
                    operatorStack.pop();
                    processOperator(toProcess);
                }
                if (!operatorStack.isEmpty() && operatorStack.top() == '(') {
                    operatorStack.pop();
                } 
            }

        }
        
        while (!operatorStack.isEmpty() && isOperator(operatorStack.top())) {
            char toProcess = operatorStack.top();
            operatorStack.pop();
            processOperator(toProcess);
        }
        
        double result = valueStack.top();
        valueStack.pop();
        System.out.println("The result is " + result);
        
    

    }
    

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        calc.processInput("1 + (2 + 3) * 8 * 5 - 3");
    }
}
