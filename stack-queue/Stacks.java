import java.util.*;

public class Stacks {
    // Stack implementation using arraylist
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();
    //     // function 1: isEmpty() 
    //     static boolean isEmpty() {
    //         return list.size() == 0;
    //     }
    //     // function 2: push
    //     public static void push(int data) {
    //         list.add(data);
    //     }
    //     // function 3: pop
    //     public static int pop() {
    //         // if stack is empty
    //         if(isEmpty()) return -1;
    
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }
    //     // function 4: peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         return list.get(list.size()-1);
    //     }
    // }

    // Stack implementation using LinkedList
    // static class Node {
    //     int data;
    //     Node next;
    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack {
    //     static Node head = null;
    //     // function 1: isEmpty()
    //     public static boolean isEmpty() {
    //         return head == null;
    //     }
    //     // function 2: push
    //     public static void push(int data) {
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }
    //     // function 3: pop
    //     public static int pop() {
    //         if(isEmpty()) return -1;
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }
    //     // function 4: peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         return head.data;
    //     }
    // }

    // Using and implementing Stack using JCF (Java Collection Framework)
    
    // Stock span problem - Medium
    public static void stocksSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    // Duplicate Parentheses -> Medium O(n)
    // (When valid parentheses exits) like (()()()) something like this
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') {
                int count = 0; 
                while(s.pop() != '(') {
                    count++;
                }
                if(count < 1) return true; // duplicate exists
            } else {
                s.push(ch);
            }
        }

        return false;
    }   

    public static void main(String args[]) {
        // Stack s = new Stack();
        // Stack<Integer> s = new Stack<>(); // -> JCF implementation
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);

        // while(!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

    }
}
