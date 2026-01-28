import java.util.ArrayList;
import java.util.List;

public class LeetCodePractice {
    private static void helper(
        List<List<String>> mainList, String arr[], int i) {
        if(i == 4) return;
        String s1 = new String(arr[i]); // top
        String s2 = new String(); // left
        String s3 = new String(); // right
        String s4 = new String(); // bottom
        int j = 0;
        while(j < 4) {
            if(j == i) {
                j++;
                continue;
            }
            if(s2.length() == 0) {
                s2 = arr[j];
            } else if(s3.length() == 0) {
                s3 = arr[j];
            } else if(s4.length() == 0) {
                s4 = arr[j];
            }
            j++;
        }
        char s1Char[] = s1.toCharArray();
        char s2Char[] = s2.toCharArray();
        char s3Char[] = s3.toCharArray();
        char s4Char[] = s4.toCharArray();
        if(             
            s1Char[0] == s3Char[0] && s1Char[3] == s4Char[0] && 
            s2Char[0] == s3Char[3] && s2Char[3] == s4Char[3]
        ) {
            List<String> list = new ArrayList<>();
            list.add(s1);
            list.add(s2);
            list.add(s3);
            list.add(s4);
            mainList.add(new ArrayList<>(list));
            
        }
        helper(mainList, arr, ++i);
    }
    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> mainList = new ArrayList<>();
        helper(mainList, words, 0);

        return mainList;
    }

    public static void main(String args[]) {
        String words[] = new String[]{"able","area","echo","also"};
        System.out.println(wordSquares(words));
    }

}
