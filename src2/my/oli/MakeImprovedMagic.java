package oli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 10k time: 619
 */
@SuppressWarnings("Duplicates")
public class MakeImprovedMagic {
    final static String YES = "YES\n";
    final static String NO = "NO\n";
    final static String WhSp = "\\s";//whitespace
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int elem = 0, linesCount = 0, counter = 1, ask, state, root1, root2, queryLine;
        ArrayList<Integer> questions = new ArrayList<>();
        ArrayList<int[]> usedMemory = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
//        int cacheSize = 0;
//        int[][] cacheMemory = new int[0][0];
        int[] system=null,tmp;
        int[] linesRefs = null;
        int[][] intLines = null;
        int[] calls = null;
        List<int[]> snapshots = null;
        String[] ss;
        String line;
        StringBuilder answer = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            ss = bufferedReader.readLine().split(WhSp);
            elem = parseInt(ss[0]);
//            if (elem > 10_000) {
//                cacheSize = 200_000_000 / (elem * 4);
//                cacheMemory = new int[cacheSize][elem];
//            }
            linesCount = parseInt(ss[1]);
            linesRefs = new int[linesCount + 1];
            intLines = new int[linesCount + 1][4];
            calls = new int[linesCount + 1];
            snapshots = new ArrayList<>(linesCount + 1);
            snapshots.add(0, new int[elem + 1]);//0 snapshot
//            for (int i = 1; i <= linesCount; i++) {
//                snapshots.add(null);
//            }
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split(WhSp);
                state = parseInt(ss[1]);

                if (line.charAt(0) == '?') {
                    ask = 1;
                    questions.add(counter);
                } else {
                    ask = 0;
                }
                intLines[counter] = new int[]{ask, state, parseInt(ss[2]), parseInt(ss[3])};
                linesRefs[counter] = state;
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        linesRefs[0] = -1;
        //make recursive from questions calls and add in call array
        for (int integer : questions) {
//            ArrayList<Integer> al = new ArrayList<>();
//            q.add(al);
            while (linesRefs[integer] != -1 && calls[integer] == 0) {//
                calls[integer]++;
//                al.add(integer);
                integer = linesRefs[integer];
            }
//            al.add(integer);
            calls[integer]++;
        }//perfect calls created! Congratulations!

        //go as usual algorithm but with optimization of memory. e.g. after call(=0) of snapshot make it null
//        for (ArrayList<Integer> al : q) {
//            for (int i = al.size()-2; i > 0; i--) {//without last element because it's to work with questions
//                queryLine = al.get(i);
//                state = intLines[queryLine][1];
//                root1 = intLines[queryLine][2];
//                root2 = intLines[queryLine][3];
//                calls[state]--;
//                if (calls[state] == 0) {//if this state is not needed anymore i can just delegate it to another and delete the reference
//                    system = snapshots.get(state);
//                    snapshots.set(state, null);//saving the memory
//                } else {//else i need to copy it
//                    if(usedMemory.isEmpty())
//                        system = new int[elem + 1];
//                    else {
//                        system = usedMemory.get(0);
//                        usedMemory.remove(system);
//                    }
//                    System.arraycopy(snapshots.get(state), 1, system, 1, elem);
//                }
//                snapshots.set(queryLine, system);
//                //
//                if (system[root1] == 0) {
//                    system[root1] = -1;
//                } else while (system[root1] != -1) root1 = system[root1];
//
//                if (system[root2] == 0) {
//                    system[root2] = -1;
//                } else while (system[root2] != -1) root2 = system[root2];
//
//                if ((root1 != root2) || root1 == -1) system[root2] = root1;//if root1==-1 => root2 = -1
//            }
//            queryLine = al.get(0);
//            state = intLines[queryLine][1];
//            root1 = intLines[al.get(0)][2];
//            root2 = intLines[al.get(0)][3];
//            system = snapshots.get(state);
//            calls[state]--;
//            //
//            if (root1 == root2) answer.append(YES);
//            else if (system[root1] == 0 || system[root2] == 0) answer.append(NO);
//            else {
//                while (system[root1] != -1) root1 = system[root1];
//                while (system[root2] != -1) root2 = system[root2];
//                if (root1 == root2) answer.append(YES);
//                else answer.append(NO);
//            }
//            if (calls[state] == 0) {
//                snapshots.set(state, null);//deleting ref to the system snapshot
//                Arrays.fill(system, 0);//cleaning array
//                usedMemory.add(system);//adding array for future use
//            }
//        }


        for (int i = 1; i <= linesCount; i++) {
            if (calls[i] != 0) {
                state = intLines[i][1];
                root1 = intLines[i][2];
                root2 = intLines[i][3];
                if (intLines[i][0] == 0) {
                    calls[state]--;
                    if (calls[state] == 0) {//if this state is not needed anymore i can just delegate it to another and delete the reference
                        system = snapshots.get(state);
                        snapshots.set(state, null);//saving the memory
                    } else {//else i need to copy it
                        tmp = snapshots.get(state);
                        if(usedMemory.isEmpty()) {
                            //if used different element no needs of new state creating
                            if (tmp[root1]==0 && tmp[root2]==0) system = tmp;
                            else {
                                system = new int[elem + 1];
                                System.arraycopy(tmp, 1, system, 1, elem);
                            }
                        } else {
                            system = usedMemory.get(0);
                            usedMemory.remove(system);
                            System.arraycopy(tmp, 1, system, 1, elem);
                        }
                    }
                    snapshots.add(system);
                    //
                    if (system[root1] == 0) {
                        system[root1] = -1;
                    } else while (system[root1] != -1) root1 = system[root1];

                    if (system[root2] == 0) {
                        system[root2] = -1;
                    } else while (system[root2] != -1) root2 = system[root2];

                    if ((root1 != root2) || root1 == -1) system[root2] = root1;//if root1==-1 => root2 = -1
                } else {
                    system = snapshots.get(state);
                    calls[state]--;
                    snapshots.add(null);
                    //
                    if (root1 == root2) answer.append(YES);
                    else if (system[root1] == 0 || system[root2] == 0) answer.append(NO);
                    else {
                        while (system[root1] != -1) root1 = system[root1];
                        while (system[root2] != -1) root2 = system[root2];
                        if (root1 == root2) answer.append(YES);
                        else answer.append(NO);
                    }
                    if (calls[state] == 0) {
                        snapshots.set(state, null);//deleting ref to the system snapshot
                        Arrays.fill(system, 0);//cleaning array
                        usedMemory.add(system);//adding array for future use
                    }
                }
                intLines[i] = null;
            } else {
                snapshots.add(null);
            }
        }

        try {
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write(answer.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }

    public static int parseInt(String s) {
        int result = 0, i = 0, len = s.length();
        while (i < len) {
            result = result*10 + s.charAt(i++) - 48;
        }
        return result;
    }
}