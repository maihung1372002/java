package hw2;

import java.util.ArrayList;
import java.util.List;

public class Bai7 {
    
    public static void main(String[] args) {
        
        RandomNumber rd = new RandomNumber(52, 51);
        List<Integer> position = rd.randomArr();
        List<Card> listCard = new ArrayList<>();
        int numberCard = 0;

        for (Integer index : position) {
            Card newCard = new Card(index%13, index/13);
            System.out.print(index%13+" "+ index/13 +"    ");
            listCard.add(newCard);
            numberCard++;
        }
       
        System.out.println(numberCard);
        for (Card card : listCard) {
            System.out.print(card.toString() + "  ");
        }
    }
}
