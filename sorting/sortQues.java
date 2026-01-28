public class sortQues {

    public static void mergeSort(String arr[], int si, int ei) {
        if(si >= ei) return;

        //work
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        sort(arr, si, mid, ei);
    }

    public static void sort(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        int x = 0;

        while(i <= mid && j <= ei) {   
            if(arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        //left
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        //right
        while(j <= ei) {
            temp[k++] = arr[j++]; 
        }

        //temp to original
        for(k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
        
    }


    public static void print(String arr[], int ei) {
        for(int i = 0; i < ei; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int majorityEle(int arr[], int i, int ans) {
        if(i > arr.length/2) {
            return ans;
        }
        
        if(ans == arr[i]) {
            majorityEle(arr, i++, arr[i]);
        }
        if(ans == arr[i+1]){
           majorityEle(arr, i++, arr[i]);
        }
        majorityEle(arr, i++, ans);

        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 2};
        System.out.println(majorityEle(arr, 0, 0));
    }
}