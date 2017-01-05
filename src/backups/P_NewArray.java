package backups;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by a1zberg on 27.11.2016.
 */
@SuppressWarnings("Duplicates")
public class P_NewArray {
    static class Tibet {
        public int a;
        public int b;
        public Tibet t;

        public Tibet(int a, int b, Tibet t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner in = null;
        PrintWriter pw = null;
        try {
            in = new Scanner(new File("input.txt"));
            pw = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = in.nextInt() + 1, m = in.nextInt(), prev;
        ArrayList<Tibet> list = new ArrayList<>();
        list.add(new Tibet(0, 0, null));
        int[] system = new int[n];
        Tibet tibet;
        int raku, chitoge, seta, setb,root1,root2;
        StringBuilder answer = new StringBuilder();
        nextLine:
        for (int i = 0; i < m; i++) {
            if (in.next().equals("+")) {
                prev = in.nextInt();
                list.add(new Tibet(in.nextInt(), in.nextInt(), list.get(prev)));
            } else {
                list.add(null);
                tibet = list.get(in.nextInt());
                raku = in.nextInt();
                chitoge = in.nextInt();
                if (raku == chitoge) {
                    answer.append("YES\n");
                    continue nextLine;
                }
//                for (int k = 0; k < n; k++) {
//                    system[k] = k;
//                }
                root1 = tibet.a;
                root2 = tibet.b;
                while (tibet != null) {
                    root1 = tibet.a;
                    root2 = tibet.b;

                    if (system[root1] == 0) {
                        system[root1] = -1;
                    } else while (system[root1] != -1) root1 = system[root1];

                    if (system[root2] == 0) {
                        system[root2] = -1;
                    } else while (system[root2] != -1) root2 = system[root2];

                    if ((root1 != root2) || root1 == -1) system[root2] = root1;//if root1==-1 => root2 = -1
//                    seta = system[tibet.a];
//                    setb = system[tibet.b];
//                    for (int j = 0; j < n; j++) {
//                        if (system[j] == setb) system[j] = seta;
//                    }
                    tibet = tibet.t;
                }
                if (system[root1] == 0 || system[root2] == 0) answer.append("NO\n");
                else {
                    while (system[root1] != -1) root1 = system[root1];
                    while (system[root2] != -1) root2 = system[root2];
                    if (root1 == root2) answer.append("YES\n");
                    else answer.append("NO\n");
                }
            }
        }
        pw.print(answer);
        pw.close();
        System.out.println(System.currentTimeMillis()-time+" ms");
    }
}