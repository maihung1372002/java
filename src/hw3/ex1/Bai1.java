package hw3.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void input(Scanner sc, List<Fraction> list) {
        System.out.print("number of fraction: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("frac (a/b)" + i + " : ");
            String input = sc.next();
            String[] frac = input.split("/");
            list.add(new Fraction(Integer.parseInt(frac[0]), Integer.parseInt(frac[1])));
        }
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        List<Fraction> collectFrac = new ArrayList<>();
        // Fraction frac1 = new Fraction(3, 5);
        // Fraction frac2 = new Fraction(2, 5);

        // System.out.println("Division: " + frac1.divi(frac2));
        // System.out.println("Addition: " + frac1.add(frac2));
        // System.out.println("Multiplication: " + frac1.multi(frac1));
        // System.out.println("Subtraction: " + frac1.minus(frac2));
        input(sc, collectFrac);
        
        
        Fraction sum = new Fraction(0, 1);
        Fraction minus = new Fraction(0, 1);
        Fraction mutil = new Fraction(0, 1);
        Fraction divi = new Fraction(0, 1);
        for (Fraction fraction : collectFrac) {
            sum = sum.add(fraction);
            minus = minus.minus(fraction);
            mutil = mutil.multi(fraction);
            divi = divi.divi(fraction);
        }
        System.out.print("sum: ");
        System.out.print(sum.toString());
        System.out.println();

        System.out.print("minus: ");
        System.out.print(minus.toString());
        System.out.println();

        System.out.print("mutil: ");
        System.out.print(mutil.toString());
        System.out.println();

        System.out.print("divi: ");
        System.out.print(divi.toString());
        System.out.println();

        System.out.print("get element at index: ");
        int index = sc.nextInt();
        System.out.println();
        System.out.println(collectFrac.get(index));

        sc.close();
    }
}
