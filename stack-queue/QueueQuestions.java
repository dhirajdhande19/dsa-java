import java.util.LinkedList;
import java.util.Queue;

public class QueueQuestions {
    // Q. First non repeting charachter
    public static void Solution(String s) {
        int sCount[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(char c : s.toCharArray()) {
            sCount[c-'a']++;
            q.add(c);
            
            while(!q.isEmpty()) {
                if(sCount[q.peek()-'a'] <= 1) {
                    System.out.println(q.peek());
                    break;
                } else q.remove();
            }
            if(q.isEmpty()) System.out.println(-1);
        }

    }

    // Q. Interleave 2 Halves of a Queue (even length)
    public static Queue<Integer> QueueInterleave(Queue<Integer> q) {
        Queue<Integer> ans = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        for(int i = 0; i < q.size()-1/2; i++) {
            temp.add(q.remove());
        }

        while(!q.isEmpty() && !temp.isEmpty()) {
            ans.add(temp.remove());
            ans.add(q.remove());
        }

        while(!temp.isEmpty()) ans.add(temp.remove());
        while(!q.isEmpty()) ans.add(q.remove());

        return  ans;
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        for(int i = 1; i <= 10; i++) {
            q1.add(i);
        }

        Queue<Integer> ans = QueueInterleave(q1);

        while(!ans.isEmpty()) {
            System.out.print(ans.remove() +" ");
        }
    }
}
