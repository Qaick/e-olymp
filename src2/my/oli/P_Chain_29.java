package oli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by a1zberg on 27.11.2016.
 */
class Tibet {
    public int a;
    public int b;
    public Tibet t;

    public Tibet(int a, int b, Tibet t) {
        this.a = a;
        this.b = b;
        this.t = t;
    }
}

public class P_Chain_29 {
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
        int n = in.nextInt(), m = in.nextInt(), prev;
        ArrayList<Tibet> list = new ArrayList<>();
        list.add(new Tibet(0, 0, null));
        ArrayList<ArrayList<Integer>> system;
        ArrayList<Integer> plural;
        Tibet tibet;
        int raku, chitoge;
        boolean contains;
        StringBuilder sb = new StringBuilder();
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
                    sb.append("YES\n");
                    continue nextLine;
                }
                system = new ArrayList<>();
                system.add(new ArrayList<>());
                while (tibet != null) {
                    contains = false;
                    search:
                    for (ArrayList<Integer> el : system) {
                        if (el.contains(tibet.a)) {
                            contains = true;
                            for (int j = system.indexOf(el) + 1; j < system.size(); j++) {
                                if (system.get(j).contains(tibet.b)) {
                                    el.addAll(system.get(j));
                                    system.remove(j);
                                    break search;
                                }
                            }
                            el.add(tibet.b);
                            break search;
                        }
                        if (el.contains(tibet.b)) {
                            contains = true;
                            for (int j = system.indexOf(el) + 1; j < system.size(); j++) {
                                if (system.get(j).contains(tibet.a)) {
                                    el.addAll(system.get(j));
                                    break search;
                                }
                            }
                            el.add(tibet.a);
                            break search;
                        }
                    }
                    if (!contains) {
                        plural = new ArrayList<>();
                        plural.add(tibet.a);
                        plural.add(tibet.b);
                        system.add(plural);
                    }
                    tibet = tibet.t;
                }
                contains = false;
                for (ArrayList<Integer> el : system) {
                    if (el.contains(raku)) {
                        contains = true;
                        if (el.contains(chitoge)) {
                            sb.append("YES\n");
                        } else sb.append("NO\n");
                        break;
                    }
                }
                if (!contains) sb.append("NO\n");
            }
        }
        pw.print(sb);
        pw.close();
        System.out.println(System.currentTimeMillis()-time+" ms");
    }
}
