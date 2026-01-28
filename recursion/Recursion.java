public class Recursion {
    public static void printNum(int n) {
        // Base case
        if(n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printNum(n - 1);
    }

    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n +" ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int facto(int n) {
        if(n == 1) {
            return 1;
        }
        int x = facto(n - 1);
        int val = n * x;
        return val;
    }

    public static int sum(int n) {
        if(n == 1) {
            return 1;
        }
        int x = sum(n - 1);
        int val = n + x;
        return val;
    }

    public static int fib(int n) {
        // base cases
        if(n == 0 || n == 1) return n;
        return fib(n-1) + fib(n-2);
    }

    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length - 1) return true;
        if(arr[i] > arr[i+1]) return false;
        return isSorted(arr, i+1);
    }

    //first occurence (print idx)
    public static int firstOccur(int arr[], int key, int i) {
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return firstOccur(arr, key, i+1);
    }

    // print last occurence
    public static int lastOccur(int arr[], int key, int i) {
        if(i == arr.length) return -1;
        int isFound = lastOccur(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) return i;
        return isFound;
    }

    public static int power(int x, int n) {
        if(n == 0) return 1;
        return x * power(x, n-1);
    }

    public static int pow(int a, int n) {
        if(n == 0) return 1;
        int getPowHalf = pow(a, n/2);
        int halfPow = getPowHalf * getPowHalf;
        if(n % 2 != 0) {
            halfPow = a * halfPow;
        }

        return halfPow;
    }

    public static void main(String args[]) {
        System.out.println(pow(2, 5));
    }
}