public class BitManipulation {
    // get ith bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }


   
    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    //count set bits in a number -> return no of times 1 appears in that numbers binary form
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if((n & 1) != 0) { // check out LSB
                count++;
            }

            n = n>>1;
        }

        return count;
    }

    //fast exponentiation
    public static int fastExpo(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if((n & 1) != 0) { // check LSB
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }

        return ans;
    }
    public static void main(String args[]) {
        // Print even and odd
        // int n = 3;
        // if((n & 1) == 0) {
        //     System.out.println("It's Even");
        // }  else {
        //     System.out.println("It's Odd");
        // }

        System.out.println(fastExpo(5, 2));
   }
}