package hw4_20001928_maiviethung.ex1;

import java.util.Stack;

public class Bai1 {
    public static void main(String[] args) {
        String hoten = "MaiVietHung";
        
        Stack<String> s = new Stack<>();
        for (int i = 0; i < hoten.length() ; i++) {
            if(i % 2 == 0){
                System.out.println("add " + String.valueOf(hoten.charAt(i)));
                s.push(String.valueOf(hoten.charAt(i)));
                System.out.println(s.toString());
            }
            if(i % 3 == 0) {
               System.out.println("remove at"+i+" :"+s.peek());
                s.pop();
                System.out.println(s.toString());
            }
        }
    }
}
