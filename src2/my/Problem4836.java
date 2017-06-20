package my;

import java.math.BigInteger;
import java.util.*;

public class Problem4836 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),k=in.nextInt();
        calcSequences(n,k);
    }

    static void calcSequences(int n,int k){
        StringBuilder sb, sakura=new StringBuilder();
        String pattern = "%"+n+"s";
        BigInteger bishamon = BigInteger.ZERO,kazuma = BigInteger.valueOf(2).pow(n);

        while(!bishamon.equals(kazuma)){
            if(bishamon.bitCount()==k) sakura.append(String.format(pattern,bishamon.toString(2)).replace(' ','0')+'\n');
            bishamon = bishamon.add(BigInteger.ONE);
        }
        System.out.print(sakura);
    }
}