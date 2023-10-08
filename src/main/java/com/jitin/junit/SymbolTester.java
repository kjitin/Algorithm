package com.jitin.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymbolTester {


    private static char[][] TOKENS = { { '{','}'}, {'[' ,']'}, {'(', ')'} };

    public static void main(String[] args) {

        String[] check = {"{{]]", "{}", "[]{}()", "[{}()]"};

        SymbolTester symbolTester = new SymbolTester();

       String[] results = symbolTester.checkBraces(check);

       for (String result: results) {
           System.out.println(result);
       }

    }

    public String[] checkBraces(String[] stringToCheck) {

        String[] results = new String[stringToCheck.length];
        for (int i=0; i< stringToCheck.length ; i++) {
            if (isBalanced(stringToCheck[i])) {
                results[i] = "Closed";
            } else {
                results[i] = "Open";
            }
        }
        return results;
    }

    private boolean isBalanced(String checkString){
        // add to Stack if open symbol
        Stack<Character> characterStack  = new Stack<>();

        for (char c : checkString.toCharArray()) {
            if (isOpen(c)) {
                characterStack.push(c);
            } else if (characterStack.isEmpty() || !matches(characterStack.pop(), c)) {
                return false;
            }
        }
        return characterStack.isEmpty();
    }

    private boolean matches(Character pop, char charAt) {
        for (char[] token : TOKENS) {
            if (pop == token[0]) {
                return charAt == token[1];
            }
        }
        return false;
    }

    private boolean isOpen(char charAt) {

        for (char[] token : TOKENS) {
            if (charAt == token[0]) {
                return true;
            }
        }
        return false;
    }
}
