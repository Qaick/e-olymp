package my.test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by olehb on 31.10.16.
 */
public class Fibonacci {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        Fibonacci(in.nextInt());
    }
    public static void Fibonacci(int n){
        int[] arr = new int[n];
        arr[0]=0;
        arr[1]=1;
        StringBuilder sb = new StringBuilder("0 1 ");
        for (int i = 2; i < n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
