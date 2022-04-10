import java.util.Scanner;

public class Bai4 {
    // class  sphere{


    // }
    public static int[] initSphere(Scanner sc) {
        int[] re = new int[4];
        for (int i = 0; i < re.length; i++) {
            re[i] = sc.nextInt();
        }
        return re;
    }

    public static double area(int[] sphere){
        return 4 * Math.PI * sphere[0] * sphere[0];
    }

    public static double vol(int[] sphere){
        return 4 / 3 * Math.PI * sphere[0] * sphere[0] * sphere[0];
    }

    public static boolean isUnion(int[] s1, int[] s2) {
        double distance = 
            Math.sqrt(
                (s1[1] - s2[1]) * (s1[1] - s2[1]) +
                (s1[2] - s2[2]) * (s1[2] - s2[2]) +
                (s1[3] - s2[3]) * (s1[3] - s2[3])
            );

        // if(distance > s1[0] + s2[0] ){
        //     return -1;
        // } else if (distance == s1[0] + )
        return distance >= s1[0] + s2[0] ? false : true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter sphere1 (r  x  y  z) ex : 1 2 3 4");
        int[] sphere1 = initSphere(sc);
        System.out.println("enter sphere2:");
        int[] sphere2 = initSphere(sc);
        System.out.println("[sphere 1: area " + area(sphere1) + " vol " + vol(sphere1) + " ]");
        System.out.println("[sphere 2: area " + area(sphere2) + " vol " + vol(sphere2) + " ]");
        System.out.println("1 and 2 is union:");
        System.out.print(isUnion(sphere1, sphere2));

        sc.close();
    }
}
