public class PracticeQuestions{

    public static int count(int arr[][], int key) {
        int count = 0;
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(key == arr[i][j]) count++;
            }
        }

        return count;
    }

    public static int getSum(int nums[][]) {
        int sum = 0;
            for(int j = 0; j < nums[0].length; j++) {
                sum += nums[1][j];
            }

        return sum;
    }

    public static void transpose(int arr[][]) {
        int newArr[][] = new int[arr[0].length][arr.length]; 
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }

        //print matrix
        for(int i = 0; i < newArr.length; i++) {
            for(int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int arr[][]) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // int arr[][] =  { {4,7,8},{8,8,7}, {7,7,1} };
        // int key = 7;
        // int count = count(arr, key);
        // System.out.println("The count of " + key + " is : " + count);

        // int nums[][] = { {1,4,9},{11,4,3},{2,2,3} };
        // int secondSum = getSum(nums);
        // System.out.println("The sum of 2nd row is : " + secondSum);

        // int arr[] [] = {{1,2,3}, {4,5,6}};
        // transpose(arr);
    }
}