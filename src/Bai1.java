import java.util.Arrays;
import java.util.Scanner;

public class Bai1 {
    public static void name(int start) {
        System.out.print(start);
    }
    public static void main(String[] args) {
        String input = "The string split() method breaks a given string around matches of the given regular expression. After splitting against the given regular expression, this method returns a char array.";
        // // input = input.replace("/n", " ");
        // // input = input.replaceAll("\\w+", "");

        String[] words = input.split("\\W+");

        // System.out.print(input);
        System.out.print(Arrays.toString(words));
       
    }
}
