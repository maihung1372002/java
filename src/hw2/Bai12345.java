package hw2;

public class Bai12345 {
    public static void main(String[] args) {
        Integer [] ar = { 12,23,12,432,12,35};
        Integer [] ar1 = { 12,23,12,432,12,35};
        Integer [] ar2 = { 12,23,12,432,12,35};
        Integer [] ar3 = { 12,23,12,432,12,35};
        Integer [] ar4 = { 12,23,12,432,12,35};
        Sort<Integer> bubble = new BubbleSort<Integer>(ar);
        Sort<Integer> insert = new InsertionSort(ar1);
        Sort<Integer> select = new SelectionSort(ar2);
        Sort<Integer> quick = new QuickSort<Integer>(ar3);
        Sort<Integer> merge = new MergeSort<Integer>(ar4);


        System.out.print("bubble:");
        bubble.sort();
        bubble.print();
        System.out.println();
        System.out.println(bubble.getCompare());
        System.out.println(bubble.getReplace());

        System.out.print("select:");
        select.sort();
        select.print();
        System.out.println();
        System.out.println(select.getCompare());
        System.out.println(select.getReplace());

        System.out.print("insert:");
        insert.sort();
        insert.print();
        System.out.println();
        System.out.println(insert.getCompare());
        System.out.println(insert.getReplace());

        System.out.print("quick:");
        quick.sort();
        quick.print();
        System.out.println();
        System.out.print("merge:");
        merge.sort();
        merge.print();
        System.out.println();
    }
}
