package backups;

import java.io.*;
import java.util.ArrayList;

/**
 * 5k - Extreme: 17527
 */
@SuppressWarnings("Duplicates")
public class ExtremeMagic_9_12 {
    static ArrayList<int[]>[] system;//element line ref-to-root
    static int[] lines;
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String line;
        int elem, linesCount, counter = 0, question;
        //TODO probably better to read in Query
        int state;
        int[] tmp;
        int root1, root2, lineNow = 1;
        StringBuilder answer = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String[] ss = bufferedReader.readLine().split("\\s");
            elem = Integer.valueOf(ss[0]);
            linesCount = Integer.valueOf(ss[1]);
            lines = new int[linesCount+1];
            system = new ArrayList[linesCount + 1];
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split("\\s");
                state = Integer.valueOf(ss[1]);
                root1 = Integer.valueOf(ss[2]);
                root2 = Integer.valueOf(ss[3]);
                lines[lineNow] = state;
                if (line.charAt(0) == '+') {
                    //
                    if (system[root1] == null) system[root1] = new ArrayList<>();
                    else root1 = tooshan(state, root1);
                    if (i==-1||j==0){
                        tmp = new int[]{state,-1};
                        system[root1].add(tmp);
                    }

                    if (system[root2] == null) system[root2] = new ArrayList<>();
                    else root2 = tooshan(state, root2);
                    if (i==-1||j==0){
                        tmp = new int[]{state,-1};
                        system[root2].add(tmp);
                    }

                    if ((root1 != root2) ){//? || system[root1].get(i)[1] == -1
                        tmp = new int[] { state, root1 };
                        system[root2].add(tmp);
                        tmp = new int[] { state, -1};
                        system[root1].add(tmp);
                    }
                } else {
                    //
                    if (root1 == root2) answer.append("YES\n");
                    else {
                        root1 = tooshan(state, root1);
                        if (i==-1||j==0) {
                            answer.append("NO\n");
                        } else {
                            root2 = tooshan(state, root2);
                            if (i==-1||j==0) {
                                answer.append("NO\n");
                            } else {
                                if (root1 == root2) answer.append("YES\n");
                                else answer.append("NO\n");
                            }
                        }
                    }
                }
                lineNow++;
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
        System.out.println("Extreme: " + (System.currentTimeMillis()-time));
    }

    static int i,j;
    static int tooshan(int state, int root2) {
        if (system[root2] != null) {
            i = system[root2].size() - 1;
            j = state;
            while (i != -1 && j != 0 && system[root2].get(i)[1] != -1) {
                if (system[root2].get(i)[0] == j) {
                    if (system[root2].get(i)[1] == -1) break;
                    root2 = system[root2].get(i)[1];
                    i = system[root2].size() - 1;
                    j = state;
                } else if (system[root2].get(i)[0] < j) j = lines[j];
                else i--;
            }
        } else {
            i = -1;
        }
        return root2;
    }
}
