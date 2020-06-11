package Easy;

import java.util.Deque;
import java.util.LinkedList;

public class CustomizedDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        System.out.println(deque); //[a, b, c]

        String str = deque.peekFirst();
        System.out.println(str); //a
        System.out.println(deque);//[a, b, c]

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
            /*
                a
                b
                c
             */
        }
        System.out.println(deque); //[]
    }
}


