package my.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by olehb on 28.10.16.
 */
public class Arraylist {
    static ArrayList<Integer> al = new ArrayList<>();
    static HashMap<Integer,Integer> hm = new HashMap<>();
    public static void main(String args[]){
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        System.out.println(Arrays.toString(arr2));
        System.arraycopy(arr1,0,arr2,0,4);
        Double d;
        String s;
        System.out.println(Arrays.toString(arr2));
        hm.put(17,45);
        hm.put(1,45);
        System.out.println(Integer.MAX_VALUE);
        long t = 0x8000_0000L;
        System.out.println(Integer.parseUnsignedInt(Long.toString(t)));
        al.add(0,null);
        System.out.println(args.length);
        al.add(1,5);
        System.out.println(al.get(0));
    }
}
