import java.util.Scanner;

public class Bai2 {
    public static int[] inputArray(Scanner sc) {
        System.out.print("length of array");
        int n = sc.nextInt();

        int[] ar = new int[n];

        for (int i = 0; i < ar.length; i++) {
            ar[i] = sc.nextInt();
        }
        return ar;
    }

    public static boolean isPerfect(int n) {   
        int sum = 0;
        int i = 1;  
        while (i <= n/2) {  
            if (n % i == 0) {  
                sum = sum + i;  
                }
            i++;  
        } 
        if (sum == n) {  
            return true;
            } 
        else {
            return false;
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0 ? true : false;
    }

    public static void  printPerfect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPerfect(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }

    }
    
    public static void  printEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isEven(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array: ");
        int[] ar = inputArray(sc);
        sc.close();
        System.out.print("perfect: ");
        printPerfect(ar);
        System.out.println();
        System.out.print("even: ");
        printEven(ar);
    }
}
