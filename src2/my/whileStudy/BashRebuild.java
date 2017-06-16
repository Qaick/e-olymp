package bashRebuilt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BashRebuild {
    public static String fileName;

    public static ArrayList<String> readBash(String fileName) {
        ArrayList<String> bash = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            try {
                String s;
                StringBuilder sb = new StringBuilder();
                while(br.readLine() != null) {
                    sb = new StringBuilder();
                    while((s = br.readLine()).equals("  ") == false) {
                        s = s.replaceAll("<br />", "\r\n");
                        s = s.replaceAll("&quot;", "\"");
                        sb.append(s);
                        sb.append("\r\n");
                    }
                    String s1 = sb.toString();
                    bash.add(s1);
                }
            }
            finally {
                br.close();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return bash;
    }

    public static boolean saveBash(ArrayList<String> bash) {
        boolean saved = false;
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("new" + fileName));
            try {
                bw.write("Bash Rebuilt\r\nby Oleg Bovsunivsky\r\n  \r\n");
                for (int i = bash.size()-1; i >= 0; i--) {
                    bw.write(bash.get(i) + "  \r\n  \r\n");
                }
                saved = true;
            }
            finally {
                bw.close();
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return saved;
    }

    public static void printBash(ArrayList<String> bash) {
        System.out.print("Bash Rebuilt\r\nby Oleg Bovsunivskyi\r\n  \r\n");
        for (int i = bash.size()-1; i >= 0; i--) {
            System.out.print(bash.get(i) + "  \r\n  \r\n");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the name of bash-file.(bash.txt)");
        fileName = in.nextLine();
        ArrayList<String> ar = new ArrayList<String>();
        ar = readBash(fileName);
        if (saveBash(ar) == true) {
            System.out.print("Done");
        }
        else {
            System.out.print("Error in save file! Look StackTrace!");
        }
    }

}
