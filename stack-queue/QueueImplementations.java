
public class QueueImplementations {

    /* 
        Following are the mutliple ways to implement Queue
    */

    // 1. Queue implementation using arrays limited size
    // static class Queue {
    //     static int arr[];
    //     static int size;
    //     static int rear;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //     }

    //     // isEmpty();
    //     public static boolean isEmpty() {
    //         return rear == -1;
    //     }

    //     // add()
    //     public static void add(int data) {
    //         if(rear == size-1) {
    //             System.out.println("The Queue is Full");
    //             return;
    //         }
            
    //         arr[++rear] = data;
    //     }

    //     // remove()
    //     public static int remove() {
    //         if(isEmpty()) return -1;

    //         int front = arr[0]; 
    //         for(int i = 0; i < rear; i++) {
    //             arr[i] = arr[i+1];
    //         }
    //         rear--;
    //         return front;
    //     }

    //     // peek()
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         return arr[0];
    //     }

    // }

    // 2. Queue implementation using arrays (circular Queue)
    // static class Queue {
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = front = -1;
    //     }

    //     // isEmpty()
    //     public static boolean isEmpty() {
    //         return rear == -1 && front == -1; 
    //     }

    //     // isFull() 
    //     public static boolean isFull() {
    //         return (rear+1) % size == front;
    //     }

    //     // add
    //     public static void add(int data) {
    //         if(isFull()) {
    //             System.out.println("Queue is Full.");
    //             return;
    //         }
    //         // 1st ele
    //         if(front == -1) front = 0;
    //         rear = (rear+1)%size;
    //         arr[rear] = data;
    //     }

    //     // remove
    //     public static int remove() {
    //         if(isEmpty()) return -1;

    //         int result = arr[front];
    //         // for last ele
    //         if(rear == front) {
    //             rear = front = -1;
    //         } else front = (front+1)%size;
    //         return result;
    //     }

    //     // peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;

    //         return arr[front];
    //     }
    // }

    // 3. Implementing Queue using Linked List
    // supplement LL class
    // public static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // // main Queue class
    // public static class Queue {
    //     static Node head = null;
    //     static Node tail = null;

    //     // isEmpty()
    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     // add()
    //     public static void add(int data) {
    //         Node newNode = new Node(data);
    //         // if ll is empty
    //         if(head == null) {
    //             head = tail = newNode;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     // remove() 
    //     public static int remove() {
    //         if(isEmpty()) return -1;

    //         int front = head.data;
    //         if(head == tail) {
    //             head = tail = null;
    //         } else head = head.next;

    //         return front;
    //     }

    //     // peek()
    //     public static int peek() {
    //         if(isEmpty()) return -1;

    //         return head.data;
    //     }

    // }

    // Queue using JCF :
        //    Queue<Integer> q = new LinkedList<>(); 
        // coz Queue is interface in java so we can't directly make its object instances (since its not class)
        // so we use LL or we can also use ArrayDeque

    // 4. Queues using 2 stacks push(add) O(n) & pop(remove) and peek O(1)
    // public static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     // isEmpty()
    //     public static boolean isEmpty() {
    //         return s1.isEmpty();
    //     }

    //     // add() 
    //     public static void add(int data) {
    //         if(isEmpty()) {
    //             s1.push(data);
    //             return;
    //         }
    //         while(!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }

    //     // peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         return s1.peek();
    //     }

    //     // remove 
    //     public static int remove() {
    //         if(isEmpty()) return -1;
    //         return s1.pop();
    //     }
    // }

    // 5. Queues using 2 stacks push(add) O(1) & pop(remove) and peek O(n)
    // public static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     // isEmpty()
    //     public static boolean isEmpty() {
    //         return s1.isEmpty();
    //     }

    //     // add()
    //     public static void add(int data) {
    //         s1.push(data);
    //     }

    //     // peek()
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         while(s1.size() != 1) {
    //             s2.push(s1.pop());
    //         }
    //         int peekedVal = s1.peek();
    //         while(!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //         return peekedVal;
    //     }

    //     // remove()
    //     public static int remove() {
    //         if(isEmpty()) return -1;
    //         while(s1.size() != 1) {
    //             s2.push(s1.pop());
    //         }
    //         int removedVal = s1.pop();
    //         while(!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //         return removedVal;
    //     }
    // }

    // 6. stacks using 2 Queues push(add) O(n) & pop(remove) and peek O(1)
    // public static class Stack {
    //     static Queue<Integer> q1 = new LinkedList<>(); // main Queue
    //     static Queue<Integer> q2 = new LinkedList<>(); 

    //     // isEmpty()
    //     public static boolean isEmpty() {
    //         return q1.isEmpty();
    //     }

    //     // push(add) -> O(n)
    //     public static void push(int data) {
    //         if(isEmpty()) {
    //             q1.add(data);
    //             return;
    //         } 
    //         while(!q1.isEmpty()) {
    //             q2.add(q1.remove());
    //         }
    //         q1.add(data);
    //         while(!q2.isEmpty()) {
    //             q1.add(q2.remove());
    //         }
    //     }

    //     // pop(remove)
    //     public static int pop() {
    //         if(isEmpty()) return -1;
    //         return q1.remove();
    //     }

    //     // peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         return q1.peek();
    //     }
    // }
  
    // 7. stacks using 2 Queues push(add) O(1) & pop(remove) and peek O(n)
    // public static class Stack {
    //     static Queue<Integer> q1 = new LinkedList<>();
    //     static Queue<Integer> q2 = new LinkedList<>();

    //     // isEmpty() 
    //     public static boolean isEmpty() {
    //         return q1.isEmpty();
    //     }

    //     // push(add) -> O(1)
    //     public static void push(int data) {
    //         q1.add(data);
    //     }

    //     // pop(remove) 
    //     public static int pop() {
    //         if(isEmpty()) return -1;
    //         while(q1.size() != 1) {
    //             q2.add(q1.remove());
    //         }
    //         int removedVal = q1.remove();
    //         while(!q2.isEmpty()) {
    //             q1.add(q2.remove());
    //         }
    //         return removedVal;
    //     }

    //     // peek
    //     public static int peek() {
    //         if(isEmpty()) return -1;
    //         while(q1.size() != 1) {
    //             q2.add(q1.remove());
    //         }
    //         int peekedVal = q1.remove();
    //         while(!q2.isEmpty()) {
    //             q1.add(q2.remove());
    //         }
    //         q1.add(peekedVal);
    //         return peekedVal;
    //     }
    // }


    public static void main(String args[]) {

    }
}