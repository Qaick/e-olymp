package backups;

import java.io.*;
import java.util.Random;

/**
 * Created by olehb on 13.12.16.
 */
public class Eolymp_WriteReadFile {
    public static void main(String[] args) {
        String line;
        final BufferedReader bufferedReader;
        int k = 10000;
        String[] rand = new String[k];
        Random randa = new Random();
        for (int i = 0; i < k; i++) {
            rand[i] = Integer.toString(randa.nextInt());
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("input.txt"));
            while ((line = bufferedReader.readLine()) != null) {

            }



            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
//            bufferedWriter.write(answer.toString());
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
