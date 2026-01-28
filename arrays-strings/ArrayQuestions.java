public class ArrayQuestions{

    // 1. Update values of given arr
    public static void update(int marks[]) {

        for(int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }

    }

    // 2. linear search int example
    public static int linearSearch(int nums[], int key){
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == key){
                return nums[i];
            }
        }
        return -1;
    }

    // 3. linear search String example
    public static int searchItem(String menu[], String key) {
        for(int i = 0; i < menu.length; i++) {
            if(menu[i] == key) { // or better way: str1.equals(str2)
                return i;
            }
        }

        return -1;
    }

    // 4. fnx to find largest and smallest int in arr
    public static int findLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;    // - INFINITY 
        int smallest = Integer.MAX_VALUE; // + INFINITY
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }

            if(arr[i] < smallest) {
                smallest = arr[i];
            }
            
        }

        System.out.println("Smallest value is: " + smallest);
        return largest; 
    }

    // 5. to find index of key using binary search
    public static int binarySearch(int nums[], int key){
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == key) {
                return mid;
            }

            if(nums[mid] < key) {
                start = mid + 1;
            } else {

                end = mid - 1;
            }
        }

        return -1;
    }


    // 6. Reverse the given array
    public static void returnArr(int nums[]) {
        int first = 0, last = nums.length - 1;

        while(first < last) {
            int temp = nums[last];
            nums[last] = nums[first];
            nums[first] = temp;

            first++;
            last--;
        }

    }

    // 7. to print pairs in array
    public static void printPairs(int numbers[]) {
        int tp = 0;
        for(int i = 0; i < numbers.length; i++) {
            int curr = numbers[i];

            for(int j = i + 1; j < numbers.length; j++) {
                System.out.print("("+ curr + ", " + numbers[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total pairs: " + tp);
    }

    // 8. to print subarrays and highest sum BRUTE FORCE VERSION
    public static void printSubArrays(int numbers[]) {
        int sum = 0, highestSum = Integer.MIN_VALUE;
        int ts = 0;
        for(int i = 0; i < numbers.length; i++) {
            int start = i; // just for understand no need to declare variable
            for(int j = i; j < numbers.length; j++) {
                int end = j; // just for understand no need to declare variable
                for(int k = start; k <= end; k++) {
                    System.out.print(numbers[k]+ " "); // subarray
                    sum = sum + numbers[k];
                }
                
                if(sum > highestSum) {
                    highestSum = sum;
                }

                System.out.print(" -> Sum : " + sum);
                sum = 0;
                
                ts++;
                System.out.println();
            }
            
            System.out.println();
            
        }

        System.out.println("Total subarrys are: " + ts);
        System.out.println("highest sum : " + highestSum);
    }

    // 8. print highest sum using prefix sum VERSION
    public static void maxSubarraySum(int nums[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[nums.length];

        prefix[0] = nums[0];
        // calculate prefix array
        for(int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            int start = i;
            for(int j = i; j < nums.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum : " + maxSum);

    }

    // *VIMP* 8. to print max sum via best apporach KADANE'S Algorithm + 
    // logic to check if all nums are -ve then it should return lowest num from arr ; 
    // time complexity O(n)
    public static void kadane(int numbers[]) {
        int ms = Integer.MIN_VALUE; // max sum
        int cs = 0; // curr sum
        int ls = 0; // lowest sum

        for(int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if(cs < 0) {
                cs = 0;
            }

            ls = Math.min(ls, numbers[i]);
            ms = Math.max(cs, ms);
        }

        if(ms == 0) { 
            ms = ls;
        }
        System.out.println("Max sum : " + ms);
    }

    // 9. Trapped Rainwater #22 in DSA Sheet Medium level que. : time complexity O(n)
    public static int trappedRainwater(int height[]) {
        int n = height.length;
        // calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        // loop 
        for (int i = 0; i < n; i++) {
            // waterLevel = min (leftmax boundary , rightmax boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapped water = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
        
    }

    // 10. Best time to buy and sell stocks 
    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(buyPrice < prices[i]) { // if profit
                int profit = prices[i] - buyPrice; // today's profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }

    // ASSIGNMENT QUESTIONS
    // Q.1 time complexity : O(n^2)
    public static boolean isRepeated(int nums[]) {

        for(int i = 0; i <= nums.length; i++) {
            for(int j = i+1; j <= nums.length - 1; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Q. 2 time complexity must be O(log n)
    public static int findTargetIdx(int nums[], int target){
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = (int) Math.floor((start + end) / 2);

            
            
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                if(nums[start] <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end = mid - 1;
            }
        } 

        return -1;
    }

    
    public static void main(String args[])  {

        // 1. Update values of given arr
        // int marks[] = {85, 96, 57};
        // update(marks);

        // for(int i = 0; i < marks.length; i++) {
        //     System.out.print(marks[i]+ " ");
        // }
        // System.out.println();

        // 2. linear search int example
        // int nums[] = {1,48, 57, 90, 23, 47, 93, 33, 55, 100};
        // int key = 10;

        // int index = linearSearch(nums, key);
        // if(index == -1) {
        //     System.out.println("Not Found!");
        // } else {
        //     System.out.println("The index is at: " + index );
        // }

        // 3. linear search String example
        // String menu[] = {"samosa", "pasta", "noodles", "fried rice", "grilled sandwich", "pani puri", "biryani"};
        // String key = "pani puri";

        // int idx = searchItem(menu, key);

        // if(idx == -1) {
        //     System.out.println("Not Found! Stay Hungry>>>");
        // } else {
        //     System.out.println("Item Found at : " + idx + " : " + key);
        // }

        // 4. fnx to find largest and smallest int in arr
        // int arr[] = {1,3,666,2999,8,7,9, 88};

        // System.out.println("Largest value is: " + findLargest(arr));


        // 5. to find index of key using binary search
        // int nums[] = {2, 4, 6, 8, 10 ,12 ,14, 16, 18, 20};
        // int key = 18;

        // System.out.println("The index is at : " + binarySearch(nums, key));

        // 6. Reverse the given array
        // int nums[] = {0,1,2,3,4,5,6,7,8,9};

        // returnArr(nums);

        // for(int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }

        // 7. to print pairs in array
        // int numbers[] = {2, 4, 6, 8, 10};
        // printPairs(numbers);

        // 8. to print subarrays and their max subarrraysum using BRUTE FORCE ; time complexity O(n3)
        // int numbers[] = {2, 4, 6, 8, 10};
        // printSubArrays(numbers);

        // 8. print max subarrraysum using prefix sum VERSION ; time complexity O(n2)
        // int nums[] = {1, -2, 6, -1, 3};
        // maxSubarraySum(nums);

        // 8. to print max subarrraysum via best apporach KADANE'S Algorithm ; time complexity O(n)
        // int numbers[] = {-2, -3, -4, 1, -2, -56, -3};
        // kadane(numbers);

        // 9. Trapped Rainwater #22 in DSA Sheet Medium level que. : time complexity O(n)
        // int height[] = {4, 2, 0, 6, 3, 2, 5};
        // System.out.println(trappedRainwater(height));

        // 10. Best time to buy and sell stocks : time complexity O(n)
        // int prices[] = {7, 1, 5, 3, 6, 4};
        // System.out.println(buyAndSellStocks(prices));

        // ASSIGNMENT QUESTIONS
        // Q.1 time complexity : O(n2)
        // int nums[] = { 1, 3, 5};
        // System.out.println(isRepeated(nums));

        // Q. 2 time complexity must be O(log n)
        int nums[] = {4,5,6,7,1,2,3};
        int target = 3;
        System.out.println(findTargetIdx(nums, target));
        

    }
}