// Calc.java


package hw4;

import java.util.Scanner;
import java.util.Stack;

/** A program for an RPN calculator that uses a stack. */
public final class Calc {

    // Hush checkstyle
    private Calc() {}

    /**
     * The main function.
     * @param args Not used.
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String curr = s.next();
        Stack<Integer> myStack;
        myStack = new Stack<>();

        while (!"!".equals(curr)) {
            decide(myStack, curr);
            if (!s.hasNext()) {
                break;
            } else {
                curr = s.next();
            }
        }
    }

    private static void decide(Stack<Integer> myStack, String curr) {
        switch (curr) {
            case "?":
                System.out.println(myStack.toString());
                break;
            case ".":
                displayNum(myStack);
                break;
            case "+":
            case "-":
            case "/":
            case "*":
            case "%":
                operation(curr, myStack);
                break;
            default:
                try {
                    int currInt = Integer.parseInt(curr);
                    myStack.push(currInt);
                } catch (IllegalArgumentException e) {
                    System.err.println("ERROR: bad token");
                }
                break;
        }
    }

    private static void displayNum(Stack<Integer> myStack) {
        if (myStack.empty()) {
            System.err.println("ERROR: No item to display.");
        } else {
            System.out.println(myStack.peek());
        }
    }

    private static void operation(String op, Stack<Integer> myStack) {
        if (myStack.empty()) {
            System.err.println("ERROR: Not enough arguments.");
        } else {
            Integer num2 = myStack.pop();
            if (myStack.empty()) {
                System.err.println("ERROR: Not enough arguments.");
                myStack.push(num2);
            } else {
                Integer num1 = myStack.pop();
                int finalNum;
                switch (op) {
                    case "+":
                        finalNum = num1 + num2;
                        myStack.push(finalNum);
                        break;
                    case "-":
                        finalNum = num1 - num2;
                        myStack.push(finalNum);
                        break;
                    case "*":
                        finalNum = num1 * num2;
                        myStack.push(finalNum);
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.err.println("ERROR: Cannot divide by 0.");
                            myStack.push(num1);
                            myStack.push(num2);
                            break;
                        }
                        finalNum = num1 / num2;
                        myStack.push(finalNum);
                        break;
                    case "%":
                        if (num2 == 0) {
                            System.err.println("ERROR: Cannot divide by 0.");
                            myStack.push(num1);
                            myStack.push(num2);
                            break;
                        }
                        finalNum = num1 % num2;
                        myStack.push(finalNum);
                        break;
                    default:
                        System.err.println("ERROR: Not a valid operation.");
                        break;
                }
            }
        }
    }
}
