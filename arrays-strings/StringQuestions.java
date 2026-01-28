import  java.util.*;

public class StringQuestions {

    public static boolean checkPalindrome(String str) {

        for(int i = 0; i < str.length() / 2; i++) {
            int n = str.length() - i - 1;
            if(str.charAt(i) != str.charAt(n)) {
                return false;
            }
        }

        return true;
        
    }

    public static String substring(String str, int si, int ei) {
        String subString = "";

        for(int i = si;  i < ei; i++) {
            subString += str.charAt(i);
        }

        return subString;
    }

    public static int printVowels(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a'  || str.charAt(i) ==  'e' || str.charAt(i) ==  'i' ||  str.charAt(i) ==  'o' || str.charAt(i) ==  'u') {
                count++;
            }
        }

        return count;
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()) {

            char[] str1CharArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();


            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean res = Arrays.equals(str1CharArray, str2CharArray);
            if(res) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public static void main(String args[]) {
        //String str = "HelloWorld";
        //System.out.print(checkPalindrome(str));
        //System.out.println(substring(str, 0, 4));
        //System.out.println(str.substring(0, 4));

        // lowercase vowels -> a,e,i,o,u  -> right
        // Uppercase -> A, E, I, O, U -> not right
        // String str = "aeiou" -> 5
        // String str2 = "AEIOU" -> 0 NOT VALID BECAUSE OF CAPITAL VOWELS !
        //String str = "DHIRAdhande";
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // System.out.println(printVowels(str));
        String str1 = "race";
        String str2 = "care";
        System.out.println(isAnagram(str1, str2));
    }
}

