package hw2;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private int limitTop;
    private int length;
    private List<Integer> nums;

    public RandomNumber(int length, int limitTop) {
        this.length = length;
        this.limitTop = limitTop;
        nums = new ArrayList<>();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLimitTop(int limitTop) {
        this.limitTop = limitTop;
    }

    public int random() {
        
        int number = (int) Math.floor(Math.random()*(limitTop + 1));
        while (nums.contains(number)) {
            number = (int) Math.floor(Math.random()*(limitTop + 1));
        }
        nums.add(number);
        

        return number;
    }

    public List<Integer> randomArr() {
        for (int i = 0; i < length; i++) {
            int number = (int) Math.floor(Math.random()*(limitTop + 1));
            while (nums.contains(number)) {
                number = (int) Math.floor(Math.random()*(limitTop + 1));
            }
            nums.add(number);
        }

        return nums;
    }
}
