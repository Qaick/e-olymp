package my;

import java.util.ArrayList;
import java.util.Scanner;

class Tibet{
    public int a;
    public int b;
    public Tibet t;
    public Tibet(int a,int b,Tibet t){
        this.a = a;
        this.b = b;
        this.t = t;
    }
}
public class Too {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt()+1,m = in.nextInt(),prev;
        ArrayList<Tibet> list = new ArrayList<>();
        list.add(new Tibet(0,0,null));
//        HashSet<HashSet<Integer>> system;
        int[] system = new int[n];
        Tibet tibet;
        int raku,chitoge,seta,setb;
        StringBuilder sb = new StringBuilder();
        nextLine:
        for (int i = 0; i < m; i++) {
            if(in.next().equals("+")){
                prev = in.nextInt();
                list.add(new Tibet(in.nextInt(),in.nextInt(),list.get(prev)));
            }else {
                list.add(null);
                tibet = list.get(in.nextInt());
                raku = in.nextInt();
                chitoge = in.nextInt();
                if(raku == chitoge){
                    sb.append("YES\n");
                    continue nextLine;
                }
                for (int k = 0; k < n; k++) {
                    system[k]=k;
                }
                while(tibet!=null) {
                    seta = system[tibet.a];
                    setb = system[tibet.b];
                    for (int j = 0; j < n; j++) {
                        if(system[j]==setb) system[j]=seta;
                    }
                    tibet = tibet.t;
                }
                if(system[raku]==system[chitoge]) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}