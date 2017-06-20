package my.oli;

import java.io.*;
import java.util.Scanner;

/**
 * Created by a1zberg on 27.11.2016.
 */
public class TestParseFile {
    static StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();

    public static void main(String[] args) {
        System.out.println("Test read file speed:");
        withBuffer();
        withScanner();
        System.out.println(sb1.length()==sb2.length());
    }

    static void withBuffer() {
        long time = System.currentTimeMillis();
        BufferedReader bi = null;
        try {
            bi = new BufferedReader(new FileReader("input.txt"),8192);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = bi.readLine()) != null)
                sb1.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("bi time: " + (System.currentTimeMillis() - time));
    }

    static void withScanner() {
        long time = System.currentTimeMillis();
        Scanner in = null;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNext())
            sb2.append(in.nextLine());
        System.out.println("scanner time: " + (System.currentTimeMillis() - time));
    }
}
