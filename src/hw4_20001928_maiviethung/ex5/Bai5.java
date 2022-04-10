package hw4_20001928_maiviethung.ex5;

import hw4_20001928_maiviethung.ex2.LinkedListStack;
import hw4_20001928_maiviethung.ex3.ArrayQueue;

public class Bai5 {
    public static boolean isPalindrome(String str) {
        // clean string
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");
        String[] splited= str.split("");
        
        LinkedListStack<String> stack = new LinkedListStack<>();
        ArrayQueue<String> queue = new ArrayQueue<>();

        for (String i : splited) {
            stack.push(i);
            queue.enqueue(i);
        }

        String stackStr = "";
        String queueStr = "";
        for (String string : queue) {
            queueStr = queueStr + string;
        }
        for (String string : stack) {
            stackStr = stackStr + string;
        }
        return stackStr.equals(queueStr);
    }
    
    public static void main(String[] args) {
        String str = "some men interpret nine memos. ";
        
        System.out.print(isPalindrome(str));
    }
}
