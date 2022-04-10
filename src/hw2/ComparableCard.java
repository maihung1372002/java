package hw2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableCard {
    public static void main(String[] args) {
        Card aceDiamond = new Card(0, 3);
        Card aceClub = new Card(0, 1);
        Card aceHeart = new Card(0, 2);
        Card KHeart = new Card(12, 2);
        List<Card> listCard = new ArrayList<>();

        listCard.add(aceDiamond);
        listCard.add(aceClub);
        listCard.add(aceHeart);
        listCard.add(KHeart);

        Collections.sort(listCard, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                // TODO Auto-generated method stub
                if (o1.getSuit() > o2.getSuit()) {
                    return 1;
                } else if (o1.getSuit() < o2.getSuit()) {
                    return -1;
                } else {
                    return 0;
                    // if (o1.getRank() > o2.getRank()) {
                    //     return 1;
                    // } else if (o1.getRank() < o2.getRank()) {
                    //     return -1;
                    // } else {
                    //     return 0;
                    // }
                }
            }
        });

        for (Card card : listCard) {
            System.out.println(card.toString());
        }
    }
}
