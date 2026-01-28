import java.util.ArrayList;

public class ArrayListExample {

    // list of lists -> 2d Arrays with n space
    public static void multiDimArrList() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        
        for(int i = 1; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }
        
        mainList.add(list1); 
        mainList.add(list2); 
        mainList.add(list3);

        System.out.println(mainList);

        for(int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j));
            }
            System.out.println();
        }
    }

    public static boolean isMonotonic(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                if (!(list.get(i) >= list.get(j) || list.get(i) <= list.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(3); list.add(2); 
        System.out.println(isMonotonic(list));
    }
}