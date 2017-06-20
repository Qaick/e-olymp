package my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
        al.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(al.toString());
    }

    int doFooBar(){return 1;}//Function in middle of code
}
