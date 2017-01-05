package backups;

import java.io.*;
import java.util.*;

/**
 * 50k time: 9791
 */
@SuppressWarnings("Duplicates")
public class MakeHashMagic {
    final static String YES = "YES\n";
    final static String NO = "NO\n";
    final static String WhSp = "\\s";//whitespace
    final static Integer MINUS = Integer.valueOf(-1);
    final static Integer ONE = Integer.valueOf(1);
    final static Integer ZERO = Integer.valueOf(0);


    public static void main(String... args) {
        long time = System.currentTimeMillis();
        int elem = 0, linesCount = 0, counter = 1;
        Integer ask, root1, root2, queryLine, state;
        ArrayList<Integer> questions = new ArrayList<>();
        ArrayList<Map<Integer, Integer>> usedMemory = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        Map<Integer, Integer> system = new HashMap<>(512);
        Integer[][] intLines = new Integer[0][0];
        int[] linesRefs = new int[0];
        int[] calls = new int[0];
        List<Map<Integer, Integer>> snapshots = null;
        String[] ss;
        String line;
        StringBuilder answer = new StringBuilder();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            ss = bufferedReader.readLine().split(WhSp);
            elem = Integer.valueOf(ss[0]);
            linesCount = Integer.valueOf(ss[1]);
            linesRefs = new int[linesCount + 1];
            intLines = new Integer[linesCount + 1][4];
            calls = new int[linesCount + 1];
            snapshots = new ArrayList<>(linesCount + 1);
            snapshots.add(0, system);//0 snapshot
//            for (int i = 1; i <= linesCount; i++) {
//                snapshots.add(null);
//            }
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split(WhSp);
                state = Integer.valueOf(ss[1]);

                if (line.charAt(0) == '?') {
                    ask = ONE;
                    questions.add(counter);
                } else {
                    ask = ZERO;
                }
                intLines[counter] = new Integer[]{ask, state, Integer.valueOf(ss[2]), Integer.valueOf(ss[3])};
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
//            for (int i = al.size() - 2; i > 0; i--) {//without last element because it's to work with questions
//                queryLine = al.get(i);
//                state = intLines[queryLine][1];
//                root1 = intLines[queryLine][2];
//                root2 = intLines[queryLine][3];
//                calls[state]--;
//                if (calls[state] == 0) {//if this state is not needed anymore i can just delegate it to another and delete the reference
//                    system = snapshots.get(state);
//                    snapshots.set(state, null);//saving the memory
//                } else {//else i need to copy it
//                    if (usedMemory.isEmpty())
//                        system = new HashMap<>(snapshots.get(state));
//                    else {
//                        system = usedMemory.get(0);
//                        usedMemory.remove(system);
//                        system.putAll(snapshots.get(state));
//                    }
//                }
//                snapshots.set(queryLine, system);
//                //
//                if (!system.containsKey(root1)) {
//                    system.put(root1, -1);
//                } else while (system.get(root1) != -1) root1 = system.get(root1);
//
//                if (!system.containsKey(root2)) {
//                    system.put(root2, -1);
//                } else while (system.get(root2) != -1) root2 = system.get(root2);
//
//                if ((root1 != root2) || root1 == -1) system.put(root2, root1);//if root1==-1 => root2 = -1
//            }
//            queryLine = al.get(0);
//            state = intLines[queryLine][1];
//            root1 = intLines[al.get(0)][2];
//            root2 = intLines[al.get(0)][3];
//            system = snapshots.get(state);
//            calls[state]--;
//            //
//            if (root1 == root2) answer.append(YES);
//            else if (!system.containsKey(root1) || !system.containsKey(root2)) answer.append(NO);
//            else {
//                while (system.get(root1) != -1) root1 = system.get(root1);
//                while (system.get(root2) != -1) root2 = system.get(root2);
//                if (root1 == root2) answer.append(YES);
//                else answer.append(NO);
//            }
//            if (calls[state] == 0) {
//                snapshots.set(state, null);//deleting ref to the system snapshot
//                system.clear();//cleaning array
//                usedMemory.add(system);//adding array for future use
//            }
//        }
        int stata;
        //linear algorithm
        for (int i = 1; i <= linesCount; i++) {
            if (calls[i] != 0) {
                state = intLines[i][1];
                stata = state;
                root1 = intLines[i][2];
                root2 = intLines[i][3];
                if (intLines[i][0].equals(ZERO)) {
                    calls[stata]--;
                    if (calls[stata] == 0) {//if this state is not needed anymore i can just delegate it to another and delete the reference
                        system = snapshots.get(stata);
                        snapshots.set(stata, null);//saving the memory
                    } else {//else i need to copy it
                        if (usedMemory.isEmpty())
                            system = new HashMap<>(snapshots.get(stata));
                        else {
                            system = usedMemory.get(0);
                            usedMemory.remove(system);
                            system.putAll(snapshots.get(stata));
                        }
                    }
                    snapshots.add(system);
                    //
                    if (!system.containsKey(root1)) {
                        system.put(root1, MINUS);
                    } else while (!system.get(root1).equals(MINUS)) root1 = system.get(root1);

                    if (!system.containsKey(root2)) {
                        system.put(root2, MINUS);
                    } else while (!system.get(root2).equals(MINUS)) root2 = system.get(root2);

                    if (!root1.equals(root2) || root1.equals(MINUS)) system.put(root2, root1);//if root1==-1 => root2 = -1
                } else {
                    system = snapshots.get(stata);
                    calls[stata]--;
                    snapshots.add(null);
                    //
                    if (root1.equals(root2)) answer.append(YES);
                    else if (!system.containsKey(root1) || !system.containsKey(root2)) answer.append(NO);
                    else {
                        while (!system.get(root1).equals(MINUS)) root1 = system.get(root1);
                        while (!system.get(root2).equals(MINUS)) root2 = system.get(root2);
                        if (root1 == root2) answer.append(YES);
                        else answer.append(NO);
                    }
                    if (calls[stata] == 0) {
                        snapshots.set(stata, null);//deleting ref to the system snapshot
                        system.clear();//cleaning array
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
}