package backups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This should be realized with array of edges. And depth-search first algorithm.
 * 10k time: 1578
 */
@SuppressWarnings("Duplicates")
public class BlackMagic {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String line;
        int elem, linesCount, counter = 0, question,len,leni;
        //TODO probably better to read in Query
        Integer state;
        int[][] system;//edges
        int[] marks;
        List<int[][]> snapshots;
        int root1, root2;
        StringBuilder answer = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String[] ss = bufferedReader.readLine().split("\\s");
            elem = Integer.valueOf(ss[0])+1;//TODO it's incremented!!
            linesCount = Integer.valueOf(ss[1]);
            snapshots = new ArrayList<>(linesCount + 1);
            snapshots.add(new int[2][0]);
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split("\\s");
                state = Integer.valueOf(ss[1]);
                root1 = Integer.valueOf(ss[2]);
                root2 = Integer.valueOf(ss[3]);
                if (line.charAt(0) == '+') {
                    len = snapshots.get(state)[0].length;
                    system = new int[2][len+1];
                    System.arraycopy(snapshots.get(state)[0], 0, system[0], 0, len);
                    System.arraycopy(snapshots.get(state)[1], 0, system[1], 0, len);
                    snapshots.add(system);
                    //
                    system[0][len]=root1;
                    system[1][len]=root2;
                } else {
                    system = snapshots.get(state);
                    snapshots.add(null);
                    //
                    if (root1 == root2) answer.append("YES\n");
                    else {

//                    int n = in.nextInt(), m = in.nextInt();
                        int[][] arr = new int[elem][elem];
                        for (int i = 0; i < system[0].length; i++) {
                            arr[system[0][i]][system[1][i]] = 1;
                            arr[system[1][i]][system[0][i]] = 1;
                        }
                        marks = new int[elem];
                        String ans = "YES\n";
                        marks[root1]=2;
                        int working=-1,prev = -2;
                        while(prev!=working) {
                            prev = working;
                            for (int i = 0; i < elem; i++) {
                                if (marks[i] == 2) {
                                    marks[i] = 3;
                                    working = i;
                                    break;
                                }
                            }
                            for (int i = 0; i < elem; i++) {
                                if (arr[working][i] == 1 && marks[i] == 0) {
                                    marks[i] = 2;
                                }
                            }
                        }
//                    for (int i = 0; i < elem; i++) {
                        if(marks[root2]==0){
                            ans = "NO\n";
//                        }
                        }
                        answer.append(ans);
//                    System.out.println(ans);



//                    else if (system[root1] == 0 || system[root2] == 0) answer.append("NO\n");
//                    else {
//                        while (system[root1] != -1) root1 = system[root1];
//                        while (system[root2] != -1) root2 = system[root2];
//                        if (root1 == root2) answer.append("YES\n");
//                        else answer.append("NO\n");
//                    }
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
