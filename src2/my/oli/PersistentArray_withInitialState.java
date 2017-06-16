package oli;

import java.io.*;

/**
 * Ver. 1.0
 * Have initial state from {@link data}.
 *
 * Created by olehb on 14.12.16.
 */
@Deprecated
public class persistent_array {
    final static String WhSp = "\\s";// whitespace

    /*  <persistent array>  */
    final static int MAXN = 100_005, MAXQ = MAXN, MAXS = 10_000_000;//1e8
    static int lch[] = new int[MAXS], rch[] = new int[MAXS], cnt;

    static p_array root[] = new p_array[MAXQ];

    //n - elements count, s - lines count
    static int n, s, a, b, v,
            data[] = new int[MAXN], // used to setup first connections of system
            cnt_a, cnt_b;
    //data is binary tree where last element is element of problem

    static int new_node(int l, int r) {
        assert (cnt < MAXS);
        lch[cnt] = l;
        rch[cnt] = r;
        return cnt++;
    }

    static class p_array {
        int n, root;

        int build(int[] data, int start, int n) {
            if (n == 1)
                return new_node(data[start], data[start]);

            int m = n / 2;
            return new_node(build(data, 0, m), build(data, m, n - m));
        }

        p_array(int[] data, int n) {
            this.n = n;
            root = build(data, 0, n);
        }

        p_array(int n, int root) {
            this.n = n;
            this.root = root;
        }

        int get(int v, int n, int i) {//vertex, number of all, i what to get
            if (n == 1)
                return lch[v];

            int m = n / 2;
            if (i < m) {
                return get(lch[v], m, i);
            } else {
                return get(rch[v], n - m, i - m);
            }
//            return i < m ? get(lch[v], m, i) : get(rch[v], n - m, i - m);
        }

        // get the value at potition i.
        int get(int i) {
            return get(root, n, i);
        }

        int set(int v, int n, int i, int x) {
            if (i < 0 || i >= n)
                return v;

            if (n == 1)
                return new_node(x, x);

            int m = n / 2;
            return new_node(set(lch[v], m, i, x), set(rch[v], n - m, i - m, x));
        }

        // get the resultant array of setting value x to position i.
        p_array set(int i, int x) {
            return new p_array(n, set(root, n, i, x));
        }
    }// root[v] = root of the tree that represent the version # v of the array.

    static int find_set(p_array root, int a) {
        int p = root.get(a);

        if (p < 0)
            return a;

        int ans = find_set(root, p);
        //data = data.set(a, ans);
        return ans;
    }

    static p_array union_set(p_array root, int a, int b) {
        a = find_set(root, a);
        b = find_set(root, b);

        if (a != b) {
            cnt_a = root.get(a);
            cnt_b = root.get(b);

            if (cnt_a > cnt_b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            p_array ans = root.set(a, cnt_a + cnt_b);
            ans = ans.set(b, a);
            return ans;
        } else
            return root;
    }

    public static void main(String... args) {
        long time = System.currentTimeMillis();
        StringBuilder answer = new StringBuilder();
        try {
            String line, ss[];
            final BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            ss = bufferedReader.readLine().split(WhSp);
            n = Integer.parseInt(ss[0]);
            s = Integer.parseInt(ss[1]);
//            lch = new int[s + 1];
//            rch = new int[s + 1];
            root[0] = new p_array(data, n + 1);
            for (int i = 1; i <= s; ++i) {
                line = bufferedReader.readLine();
                ss = line.split(WhSp);
                v = Integer.parseInt(ss[1]);
                a = Integer.parseInt(ss[2]);
                b = Integer.parseInt(ss[3]);

                if (line.charAt(0) == '+')
                    root[i] = union_set(root[v], a, b);
                else {
                    int id_b = find_set(root[v], b);
                    int id_a = find_set(root[v], a);
                    answer.append(((id_a == id_b) ? "YES" : "NO") + '\n');
                }
            }

            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write(answer.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));
    }
}