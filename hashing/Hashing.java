import java.util.*;
public class Hashing {

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        if(map.get(0) == k) {
            return 1;
        }

        for(int i = 1; i < n; i++) {
            map.put(i, map.get(i-1)+nums[i]);
            if(map.get(i) == k){
                return i+2;
            }
        }

        return 0;
    }

    

    public static void main(String args[]) {
        int nums[] = new int[]{1, 1, 2};
        System.out.println(subarraySum(nums, 2));
        
    }
}