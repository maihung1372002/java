package hw3.ex4;

import java.util.ArrayList;

import java.util.List;


public class Test {
    public static void main(String[] args) throws Exception {
        String input = "expression this expression, this method returns a char array.expression";
        WordCount wc = new WordCount(input);
        
        String[] splited = input.split("\\W+");
        List<String>list = new ArrayList<>();
        for (String data : splited) {
            if(!list.contains(data)){
                list.add(data);
            }
        }
        

       for (String string : list) {
           System.out.print("\n"+ string + ":" + wc.count(string));
       }

    }
}
