public class RecursionPart2 {

    // tiling problem
    public static int tilingQue(int n) {
        // base condn
        if(n == 0 || n == 1) return 1;

        // vertical tiles
        int vertical = tilingQue(n - 1);
        // horizontal tiles
        int horizontal = tilingQue(n-2);
        int finalCombos = vertical + horizontal;
        return finalCombos;

        // return tilingQue(n-1) + tilingQue(n-2);
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsParing(int n) {
        if(n == 1 || n == 2) return n;
        return friendsParing(n-1) + (n-1) * friendsParing(n-2);
    }

    public static void binaryString(int n, int ld, String str) {
        //base case
        if(n == 0) {
            System.out.println(str);
            return;
        }

        //work
        binaryString(n-1, 0, str+"0");
        if(ld == 0) {
            binaryString(n-1, 1, str+"1");
        } 
    }

    public static void printOccur(int arr[], int key, int i) {
        // base case
        if(i == arr.length) return;
        if(arr[i] == key) {
            System.out.print(i + " ");
            printOccur(arr, key, i+1);
        } else {
            printOccur(arr, key, i+1);
        }

    }

    public static void convertToString(int num, int i) {
        String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String str = Integer.toString(num);
        //base case 
        if(i == str.length()) return;

        //work
        char currNum = str.charAt(i);
        int n = currNum - '0';
        System.out.print(arr[n] + " ");
        convertToString(num, i+1);
    }

    public static void countStrLen(String str, int i) {
        //base case
        if(i == str.length()) {
            System.out.print(i);
            return;
        }
        //work
        countStrLen(str, i+1);
    }

    public static void uniqueSubStr(String str, String newStr, int i, int ans) {
        // base case
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        //work
        char currChar = str.charAt(i);
        uniqueSubStr(str, newStr+currChar, i+1, ans);
        uniqueSubStr(str, newStr, i+1, ans);
        char start = newStr.charAt(0);
        char end = newStr.charAt(newStr.length() - 1);
        if(start == end) {
            ans++;
        }

    }

    public static void towerOfHanoi(int n, char A, char B, char C) {
        // n -> no. of tiles/bars
        // A -> source, B -> helper, C -> destination
        //base case
        if(n == 0) return;
        //work
        towerOfHanoi(n-1, A, C, B); 
        System.out.println(A + " to " + C);
        towerOfHanoi(n-1, B, A, C);
    }

    public static void main(String args[]) {    
        uniqueSubStr("abcab", "", 0, 0);
    }

}