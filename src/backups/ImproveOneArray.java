package backups;

import java.util.HashMap;

public class ImproveOneArray {
    public static void main(String[] args) {
        HashMap<int[], int[]> primitiveArray = new HashMap<>();
        HashMap<Integer, Integer> wrap = new HashMap<>();
        int testSize = 5_000_000;
        long time = System.currentTimeMillis();
        for (int i = 0; i < testSize; i++) {//Arrays.hashCode
            primitiveArray.containsKey(new int[]{i});
            primitiveArray.put(new int[]{i}, new int[]{i});
        }
        System.out.println("primitive array: "+ (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        for (int i = 0; i < testSize; i++) {//Arrays.hashCode
            wrap.containsKey(Integer.valueOf(i));
            wrap.put(Integer.valueOf(i), Integer.valueOf(i));
        }
        System.out.println("primitive array: "+ (System.currentTimeMillis() - time));
    }
}
