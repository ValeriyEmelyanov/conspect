package algorithms.solution;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BracketsValidation {
    private static final Map<Character, Character> BRACKETS = new HashMap<>();
    static {
        BRACKETS.put(')', '(');
        BRACKETS.put('}', '{');
        BRACKETS.put(']', '[');
    }

    private static boolean isValidBrackets(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (BRACKETS.containsValue(c)) {
                stack.push(c);
            } else if (BRACKETS.containsKey(c) &&
                    (stack.isEmpty() || stack.pop() != BRACKETS.get(c))
            ) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidBrackets(""));
        System.out.println(isValidBrackets("({[]})"));
        System.out.println(isValidBrackets("({[]}())"));
        System.out.println(isValidBrackets("({}()[()])"));
        System.out.println(isValidBrackets("({}([)()])"));
        System.out.println(isValidBrackets("({}()()])"));
        System.out.println(isValidBrackets("({}()())]"));
    }
}
