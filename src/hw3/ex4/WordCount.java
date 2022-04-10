package hw3.ex4;

public class WordCount {
    private String[] words;

    public WordCount(String input) {
        this.words = input.split("\\W+");
    }

    public int indexOf(String word ) {
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
    public int indexOf(String word, int start) {
        for (int i = start; i < words.length; i++) {
            if(words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
    public int indexOf(String word, int start, int end ) {
        for (int i = start; i < end; i++) {
            if(words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public int count(String word) {
        int count = 0;
        int index = indexOf(word);
        while(index != -1) {
            count++;
            index = indexOf(word, index + 1);
        }
        
        return count;
    }
}
