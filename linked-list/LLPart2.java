import java.util.LinkedList;

public class LLPart2 {
    public static void main(String args[]) {
        // define(creating LL using JCF) | object (int, boolean, char...) - No | Classes (Integer, Boolean, Character...) - Yes
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        System.out.println(ll);

        // remove
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
    }

}
