package backups;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 10k time: 16175
 */
@SuppressWarnings("Duplicates")
public class WhiteMagic {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String line;
        int elem, linesCount;
        //TODO probably better to read in Query
        Integer state;
        HashMap<Integer,Integer> system;
        List<HashMap<Integer,Integer>> snapshots;
        Integer root1, root2, mi = Integer.valueOf(-1);
        StringBuilder answer = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String[] ss = bufferedReader.readLine().split("\\s");
            elem = Integer.valueOf(ss[0]);//TODO it's incremented!!
            linesCount = Integer.valueOf(ss[1]);
            snapshots = new ArrayList<>(linesCount + 1);
            snapshots.add(new HashMap<>());
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split("\\s");
                state = Integer.valueOf(ss[1]);
                root1 = Integer.valueOf(ss[2]);
                root2 = Integer.valueOf(ss[3]);
                if (line.charAt(0) == '+') {
                    system = new HashMap<>(snapshots.get(state).size());
                    system.putAll(snapshots.get(state));
//                    System.arraycopy(snapshots.get(state), 1, system, 1, elem);
                    snapshots.add(system);
                    //
                    if (!system.containsKey(root1)) {
                        system.put(root1,mi);
                    } else while (system.get(root1) != mi) root1 = system.get(root1);

                    if (!system.containsKey(root2)) {
                        system.put(root2,mi);
                    } else while (system.get(root2) != mi) root2 = system.get(root2);

                    if ((!root1.equals(root2)) || root1 == mi) system.put(root2,root1);//if root1==-1 => root2 = -1
                } else {
                    system = snapshots.get(state);
                    snapshots.add(null);
                    //
                    if (root1 == root2) answer.append("YES\n");
                    else if (!system.containsKey(root1) || !system.containsKey(root2)) answer.append("NO\n");
                    else {
                        while (system.get(root1) != mi) root1 = system.get(root1);
                        while (system.get(root2) != mi) root2 = system.get(root2);
                        if (root1 == root2) answer.append("YES\n");
                        else answer.append("NO\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write(answer.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }
}
