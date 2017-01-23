package oli;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UsefulCode {

    static boolean prime(long n){
        for(long i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a;
        double pow,bcd;
        while(in.hasNext()){
            a = in.nextInt();
            pow = Math.pow(2,a-2);
            bcd = binomial_coefficient(a-2,(a-2)/2);
            sb.append(String.format("%.8f",((pow-bcd)/pow)).replace(',','.')+"\n");
            System.out.println("pow:"+pow+" bcd:"+bcd+" ans:"+sb);
        }
        System.out.println(sb);
    }
    //Pascal's triangle
    static double binomial_coefficient(int n, int k){
        double r = 1;
        for (int i = 1; i <=k; i++) {
            r*=n-k+i;
            r/=i;
        }
        return Math.ceil(r-0.2);
    }


    //greatest common divisor NOD
    static long GCD(long a, long b){
        long tmp;
        while(b!=0){
            tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    //least common multiple NOK
    static long LCM(long a, long b){
        return a/ GCD(a,b)*b;
    }

    public static void comparator_example(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        Integer arr[] = new Integer[a];
        for(int i = 0;i<a;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(a==b) return 0;
                if(a%10 == b%10){
                    if(a>b) return 1;
                    else return -1;
                }else {
                    if(a%10 >b%10) return 1;
                    else return -1;
                }
            }
        });
        for(int i = 0;i<a;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
