import java.util.Scanner;

public class Bai5 {
    
public static void printAr(String[] ar) {
    for (int i = 0; i < ar.length; i++) {
        System.out.print(ar[i]+" ");
    }
}



public static int indexOf(String[] data, String ope) {
    for (int i = 0; i < data.length; i++) {
        if(data[i].equals(ope)) {
            return i;
        }
    }
    return -1;
}
 
public static String[] arrRemove(String[] ar, int index) {
    for (int i = 0; i < ar.length - 1; i++) {
        if (i >= index) {
            ar[i] = ar[i + 1];
            ar[i + 1] = "NaN";
        } 
    }
    return ar;
}

public static void calc(String[] ar, String[] ope, String symbol) {
    int index = indexOf(ope,symbol);
    while (index != -1) {
        switch (symbol) {
            case "/":
                ar[index] = String.valueOf(
                    Double.parseDouble(ar[index])
                    /
                    Double.parseDouble(ar[index + 1])
                );
                break;
            case "*":
                ar[index] = String.valueOf(
                    Double.parseDouble(ar[index])
                    *
                    Double.parseDouble(ar[index + 1])
                );
                break;
            case "-":
                ar[index] = String.valueOf(
                    Double.parseDouble(ar[index])
                    -
                    Double.parseDouble(ar[index + 1])
                );
                break;
            case "+":
                ar[index] = String.valueOf(
                    Double.parseDouble(ar[index])
                    +
                    Double.parseDouble(ar[index + 1])
                );
                break;
            default:
                System.out.println("calc went wrong");
                break;
        }
        // ar[index] = String.valueOf(
        //             Double.parseDouble(ar[index])
        //             /
        //             Double.parseDouble(ar[index + 1])
        //         );
        arrRemove(ar, index + 1);
        arrRemove(ope, index);
        index = indexOf(ope, symbol);
    }

}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your ope (1+2-3*4/5) limit 10 ope:");
        String input = sc.next();
        sc.close();
        String [] data = input.split("\\+|\\-|\\*|\\/|\\=");
        String [] ope = input.split("[0-9]");
        arrRemove(ope, 0);
        double result = 0;

        calc(data, ope, "/");
        calc(data, ope, "*");
        calc(data, ope, "-");
        calc(data, ope, "+");
        // ArrayList<String> number = new ArrayList<>();
        // ArrayList<String> opera = new ArrayList<>();

        // for (String s : data) {
        //     number.add(s);
        // }
        // for (String s : ope) {
        //     opera.add(s);
        // }
        
        // int indexDivide = indexOf(ope,"/");
        // while (indexDivide != -1) {
        //     data[indexDivide] = String.valueOf(
        //                 Double.parseDouble(data[indexDivide])
        //                 /
        //                 Double.parseDouble(data[indexDivide + 1])
        //             );
        //     arrRemove(data, indexDivide + 1);
        //     arrRemove(ope, indexDivide);
        //     indexDivide = indexOf(ope, "/");
        // }
        // while (indexDivide != -1) {
        //     number.set(indexDivide,String.valueOf(
        //         Double.parseDouble(number.get(indexDivide))
        //         /
        //         Double.parseDouble(number.get(indexDivide + 1))
        //     ));
        //     opera.remove(indexDivide);
        //     for(String a : opera) {
        //         System.out.println(a);
        //     }
        //     number.remove(indexDivide + 1);
        //     indexDivide = indexOf(opera,"/",data.length);
        //     System.out.println(indexDivide);
        // }

        // for (String num : number) {
        //     System.out.println(num);
        //     result+= Double.parseDouble(num);
        // }
        System.out.print("result: " + data[0]);
    }
}
