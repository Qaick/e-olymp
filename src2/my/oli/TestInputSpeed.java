package oli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by a1zberg on 27.11.2016.
 */
public class TestInputSpeed {
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        System.out.println("ready?");
        long time=0;
        try {
            System.out.println("readed: "+bi.readLine());
            time = System.currentTimeMillis();
            System.out.println("time");
            while ((line = bi.readLine()) != null)
                for (String numStr: line.split("\\s"))
                    sb.append(numStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-time);
        System.out.println(sb);
    }
}
