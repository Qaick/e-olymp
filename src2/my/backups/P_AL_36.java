package backups;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 10k 2462 ms
 */
public class P_AL_36 {
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
        int n = in.nextInt(),m = in.nextInt(),chitoge,kirisaki;
        // struc - sets - set
        List<List<List<Integer>>> raku = new ArrayList<>();
        List<List<Integer>> ichijou;
        List<Integer> ich;
        StringBuilder sb = new StringBuilder();
        raku.add(new ArrayList<>());//0
        boolean contains;
        line:
        for (int i = 0; i < m; i++) {
            if(in.next().equals("+")){
                ichijou = raku.get(in.nextInt());
                chitoge = in.nextInt();
                kirisaki = in.nextInt();
                contains=false;
                ichijou = copyStruct(ichijou);//copy ichijou line
                raku.add(ichijou);
                added:
                for(List<Integer> ichi:ichijou){
                    if(ichi.contains(chitoge)){
                        contains = true;
                        if(ichi.contains(kirisaki)) break;
                        for (int j = ichijou.indexOf(ichi); j < ichijou.size(); j++) {
                            if(ichijou.get(j).contains(kirisaki)){
                                ichi.addAll(ichijou.get(j));
                                ichijou.remove(ichijou.get(j));
                                break added;
                            }
                        }
                        ichi.add(kirisaki);
                        break added;
                    }
                    if(ichi.contains(kirisaki)){
                        contains = true;
                        if(ichi.contains(chitoge)) break;
                        for (int j = ichijou.indexOf(ichi); j < ichijou.size(); j++) {
                            if(ichijou.get(j).contains(chitoge)){
                                ichi.addAll(ichijou.get(j));
                                ichijou.remove(ichijou.get(j));
                                break added;
                            }
                        }
                        ichi.add(chitoge);
                        break added;
                    }
                }
                if(contains==false){
                    ich = new ArrayList<>();
                    ich.add(chitoge);
                    ich.add(kirisaki);
                    ichijou.add(ich);
                }
            }else{
                raku.add(null);
                ichijou = raku.get(in.nextInt());
                chitoge = in.nextInt();
                kirisaki = in.nextInt();
                if(chitoge==kirisaki){
                    sb.append("YES\n");
                    continue;
                }
                contains=false;
                for(List<Integer> ichi:ichijou){
                    if(ichi.contains(chitoge)){
                        contains=true;
                        if(ichi.contains(kirisaki)) sb.append("YES\n");
                        else sb.append("NO\n");
                        break;
                    }
                }
                if(contains==false) sb.append("NO\n");
            }
        }
        pw.print(sb);
        pw.close();
        System.out.println(System.currentTimeMillis()-time+" ms");
    }
    static List<List<Integer>> copyStruct(List<List<Integer>> line){
        List<List<Integer>> copied = new ArrayList<>();
        List<Integer> tmp;
        for(List<Integer> el:line){
            tmp = new ArrayList<>();
            Collections.addAll(tmp,el.toArray(new Integer[0]));
            copied.add(tmp);
        }
        return copied;
    }
}