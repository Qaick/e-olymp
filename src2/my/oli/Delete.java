package oli;

import java.util.Scanner;

public class Delete {
    //1316
    static int cash,ca;
    static double tt = 10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a;
        double pow,bcd;
        int idx=0;
        while(idx++<=50_000){
            cash =ca= 0;
            a = idx*2;
            if(a!=2) {
                bcd = binomial_coefficient(a - 2, (a - 2) / 2);
                pow = pow(a - 2);
            }else{
                bcd=1;
                pow=1;
            }
            System.out.print(idx+" "+String.format("%.8f",((pow-bcd)/pow)).replace(',','.')+"\n");
        }
        System.out.println(sb);
    }
    static double pow(int n){
        double tmp = 2;
        while(n!=1) {
            tmp *= 2;
            n--;
            if(tmp>tt) {
                tmp /= tt;
                cash++;
            }
        }
        return tmp;
    }

    //Pascal's triangle
    static double binomial_coefficient(int n, int k){
        double r = 1;
        for (int i = 1; i <=k; i++) {
            r*=n-k+i;
            r/=i;
            if(r>tt){
                ca++;
                r/=tt;
            }
        }
        return Math.ceil(r-0.2);
    }
}