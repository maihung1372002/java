package hw2;

public class Card {
    private final static String[] RANK = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "J","Q","K" };
    private final static String[] SUIT = {"spades", "clubs", "hearts", "diamonds"};
    private int rank;
    private int suit;

    public Card() {
        rank = 0;
        suit = 0;
    }
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }
    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return RANK[rank] + SUIT[suit];
    }
}
