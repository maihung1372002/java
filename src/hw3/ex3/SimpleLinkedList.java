package hw3.ex3;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        if (top == null) {
            Node newNode = new Node(data, null);
            top = newNode;
            bot = newNode;
        } else {
            top = new Node(data, top);
        }
        n++;
    }

    public void addBot(T data) {
        if (top == null) {
            this.add(data);
        } else if (bot == null) {
            bot = new Node(data, null);
            top.next = bot;
        } else {
            Node newBot = new Node(data, null);
            bot.next = newBot;
            bot = newBot;
        }
        n++;
    }

    public T get(int i) {
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }

        return node.data;
    }
    
    public void set(int i, T data) {
        Node node = top;
        Node nodeNew ;
        for (int j = 0; j < i - 1; j++) {
            node = node.next;
            nodeNew = new Node(data, node.next.next);
            node.next = nodeNew;
        }
    }
  
    public boolean isContain(T data) {
        if(top == null) return false;
        Node tmp = top;
        for (int i = 0; i < n; i++) {
            if (tmp.data == data) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
    // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        T res = top.data;
        top = top.next;
        n--;
        return res;
    }

    public T removeBot() {
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        Node tmp = top;
        T res ;
        for (int i = 0; i < n - 1; i++) {
            tmp = tmp.next; 
        }
        res = tmp.data; 
        tmp = null;          
        n--;
        return res;
    }

    public void remove(T data) {
        while(this.isContain(data)) {
            removeFirst(data);
        }
    }

    public void removeFirst(T data) {
        if (top == null && bot == null) return;
        if (top.data == data) {
            this.removeTop();
        } else if (bot.data == data) {
            this.removeBot();
        } else {
            Node node = top;
            for (int i = 0; i < n - 2 ; i++) {
                if (node.next.data == data) {
                    node.next = node.next.next;
                }
                node = node.next;
            }
            n--;
        }
    } 
    
    public String toString() {
        String res = "[";
        for (int i = 0; i < n; i++) {
            res = res +" "+ this.get(i);
        }
        return res + "]";
    }
    
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("khanh");
        list.add("hung");
        list.add("hung");
        list.add("hoan");
        list.add("tu");
        list.add("toan");
        System.out.println(list.toString());

        System.out.println("add bot: linh");
        list.addBot("linh");
        System.out.println(list.toString());

        System.out.println("set pos 2: heee");
        list.set(2, "heee");
        System.out.println(list.toString());


        System.out.println("remove top");
        list.removeTop();
        System.out.println(list.toString());

        System.out.println("remove bot");
        list.removeBot();
        System.out.println(list.toString());

        System.out.println("remove all: hung");
        list.remove("hung");
        System.out.println(list.toString());
        
    }

}
