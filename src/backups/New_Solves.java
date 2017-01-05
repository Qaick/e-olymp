package backups;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class New_Solves {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, summ = 0;
        char[] line;
        summ = 0;
        try {
            n = Integer.valueOf(br.readLine());
            for (int i = 0; i < n; i++) {
                line = br.readLine().toCharArray();
                for (int j = i+1; j < n; j++) {
                        if (line[j<<1]=='1') {
                            summ++;
                        }
                }
            }
        } catch (Exception e) {
        }
        System.out.println(summ);
    }
}