package backups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 10k time: 619
 */
@SuppressWarnings("Duplicates")
public class ImproveMagic {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String line;
        int elem, linesCount, counter = 0, question;
        //TODO probably better to read in Query
        Integer state;
        ArrayList<int[]>[] system;//array of elements
        ArrayList<int[]> element;//element that have joints
        int[] joint;//[step, connection]
        int root1, root2;
        StringBuilder answer = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String[] ss = bufferedReader.readLine().split("\\s");
            elem = Integer.valueOf(ss[0]);//TODO it's incremented!!
            linesCount = Integer.valueOf(ss[1]);
            system = new ArrayList[elem + 1];
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split("\\s");
                state = Integer.valueOf(ss[1]);
                root1 = Integer.valueOf(ss[2]);
//                root2 = Integer.valueOf(ss[3]);
//                if (line.charAt(0) == '+') {
//                    //
//                    if (system[root1] == 0) {
//                        system[root1] = -1;
//                    } else while (system[root1] != -1) root1 = system[root1];
//
//                    if (system[root2] == 0) {
//                        system[root2] = -1;
//                    } else while (system[root2] != -1) root2 = system[root2];
//
//                    if ((root1 != root2) || root1 == -1) system[root2] = root1;//if root1==-1 => root2 = -1
//                } else {
//                    //
//                    if (root1 == root2) answer.append("YES\n");
//                    else if (system[root1] == 0 || system[root2] == 0) answer.append("NO\n");
//                    else {
//                        while (system[root1] != -1) root1 = system[root1];
//                        while (system[root2] != -1) root2 = system[root2];
//                        if (root1 == root2) answer.append("YES\n");
//                        else answer.append("NO\n");
//                    }
//                }
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