import java.util.Scanner;

public class Bai3 {

    public static int[] convert(String number) {
        String[] pre = number.split("/");
        int[] re = new int[2];
        for (int i = 0; i < re.length; i++) {
            re[i] = Integer.parseInt(pre[i]);
        }
        if(re[1] == 0) {
            
        }
        return re;
    }


    public static int GCD(int a, int b) {
        int gcd = 1;
        for(int i = 1; i <= a && i <= b; i++)
        {
            if(a%i==0 && b%i==0)
                gcd = i;
        }
        return gcd;
    }


    public static String sum(int[] a, int[] b) {
        int top = a[0] * b[1] + a[1] * b[0];
        int bot = a[1] * b[1];
        int gcd = GCD(top, bot);
        top /= gcd;
        bot /= gcd;
        return  top == bot ? "1" :  top + "/" + bot;
    }
    
    
    public static String multi(int[] a, int[] b) {
    
        int top = a[0] * b[0];
        int bot = a[1] * b[1];
        int gcd = GCD(top, bot);
        top /= gcd;
        bot /= gcd;
        return top == bot ? "1" : top + "/" + bot;
    }
    
    public static String divide(int[] a, int[] b) {
        int top = a[0] * b[1];
        int bot = a[1] * b[0];
        int gcd = GCD(top, bot);
        top /= gcd;
        bot /= gcd;
        return top == bot ? "1" : top + "/" + bot;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter first: ");
        String input1 = sc.next();
        System.out.println("");
        System.out.print("enter second: ");
        String input2 = sc.next();
        sc.close();
        int[] num1 = convert(input1);
        int[] num2 = convert(input2);
        System.out.println(sum(num1, num2));
        System.out.println(multi(num1, num2));
        System.out.println(divide(num1, num2));
        System.out.println(2*Integer.parseInt("-1"));

    }
}
