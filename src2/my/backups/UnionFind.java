package backups;

import java.util.Scanner;

public class UnionFind {
    static class Union {
        int size = 1;
        int summ;
        Union union;
        Union(int summ) {
            this.summ = summ;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            int n = in.nextInt(), m = in.nextInt(), q;
            Union[] unions = new Union[n + 1];
            for (int i = 0; i < m; i++) {
                int tmp = in.nextInt();
                final int p = in.nextInt();
                Union un = unions[p];
                if (un == null) {
                    un = new Union(p);
                    unions[p] = un;
                }
                if (tmp == 1) {//union
                    q = in.nextInt();
                    if (p != q) {
                        Union un2 = unions[q];
                        if (un2 == null) {
                            un2 = new Union(q);
                            unions[q] = un2;
                        }
                        while (un.union != null) un = un.union;
                        while (un2.union != null) un2 = un2.union;
                        if (!un.equals(un2)) {
                            un.union = un2;
                            un2.summ += un.summ;
                            un2.size += un.size;
                        }
                    }
                } else if (tmp == 2) {//move first to second set
                    q = in.nextInt();
                    if (p != q) {
                        Union un2 = unions[q];
                        if (un2 == null) {
                            un2 = new Union(q);
                            unions[q] = un2;
                        }
                        while (un.union != null) un = un.union;
                        while (un2.union != null) un2 = un2.union;
                        if (!un.equals(un2)) {
                            un.summ -= p;
                            un2.summ += p;
                            un.size--;
                            un2.size++;
                            unions[p] = new Union(p);
                            unions[p].union = un2;
                        }
                    }
                } else {//how much elements in set
                    while (un.union != null) un = un.union;
                    sb.append(un.size + " " + un.summ + '\n');
                }
            }
        }
        System.out.println(sb);
    }
}