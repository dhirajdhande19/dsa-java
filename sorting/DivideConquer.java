public class DivideConquer {

    public static void print(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) return;

        // work
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid); // left
        mergeSort(arr, mid+1, ei); // right
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si; // iterator for left part
        int j = mid+1; // iterator for right part
        int k = 0; // iterator for temp arr
        
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left part 
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        // right part
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) return;
        // work
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for(int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i; 
    }

    public static int search(int arr[], int tar, int si, int ei) {
        //base case
        if(si > ei) return -1;

        int mid = si + (ei-si)/2;
        if(arr[mid] == tar) return mid;

        //check line 1
        if(arr[si] <= arr[mid]) {
            //case a: left
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            } else {
                //case b: right
                return search(arr, tar, mid+1, ei);
            }
        } else {
            // case c : right
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            } else {
                //case e: left
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static int iterator(int arr[], int tar, int si, int ei) {
        for(int i = si; i < ei; i++) {
            if(arr[i] == tar) return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        String newStr = str.toLowerCase();
        System.out.println(s);
        System.out.println(str);
        System.out.println(newStr);
       
    }
}