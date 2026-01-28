public class LL {
    // LL -> Linked List
    public static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // O(1) time coz constant operations are performed
        // step 1: create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail =  newNode;
            return;
        }
        // step 2: newNode's next -> head
        newNode.next = head; // link
        // step 3: head -> newNode
        head = newNode;
    }

    public void addLast(int data) { // O(1) time coz constant operations are performed
        // step 1: create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail =  newNode;
            return;
        }
        // step 2: tail's next -> newNode
        tail.next = newNode; // link
        // step 3: tail -> newNode
        tail = newNode;
    }

    public static void print() { // O(n)
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        // i -> idx-1;  temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size  == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // iterative/linear search
    public static int itrSearch(int key) { // O(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key) { // key is found
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found
        return -1;

    }
 
    public static int helper(Node head, int key) { // O(n)
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }

    // recursive search
    public static int recSearch(int key) {
        return helper(head, key);
    }

    // reverse a linked list
    public static void reverse() { // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // find and remove nth node from end of linked list
    public static void removeNthNodeFromEnd(int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if(n == size) {
            head = head.next;
            return;
        } 
        // else if(n > size) {
        //     System.out.println("Not valid n");
        //     return;
        // }

        int i = 1;
        int iToFind = size - n;
        Node prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        } 
        
        prev.next = prev.next.next;

    }

    // helper function
    public static Node findMid(Node head) { // slow fast approach
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow;
    }

    public boolean isPanlindrome() {
        if(head == null || head.next == null) {
            return true; // early return coz either Node is empty or its just 1 so its valid palindrome
        }
        // step 1: find mid
        Node midNode = findMid(head);

        // step 2: reverse right half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // head of right half
        Node left = head; // original head

        // step 3: check left half and right half
        while (right != null) {
            if(right.data != left.data) {
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    } 

    public static boolean isCycle(Node head) { // Floyd's Cycle Finding Algorithm (Slow-Fast Approach)
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast) return true; // It's cycle/loop
        }

        return false; // It's not cycle/loop
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
            
        }

        //remove cycle -> prev.next = null
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        } 

        return slow; // <- mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) { // O(n log n)
        if(head == null || head.next == null) {
            return head;
        }

        //find mid
        Node mid = getMid(head);
        //left & right MergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alt merge - zigzag merge
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }

    public static void main(String args[]) {
        LL ll = new LL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();

        ll.zigZag();
        ll.print();
    }
}