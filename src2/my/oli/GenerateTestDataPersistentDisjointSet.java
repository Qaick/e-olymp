package my.oli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by a1zberg on 27.11.2016.
 */
public class GenerateTestDataPersistentDisjointSet {
    public static void main(String[] args) {
        int elements = 10_000,
                testel = 50*elements/100,
                plus = 99*elements/100;
        int quest = elements-plus, state = 1, queries = plus + quest;
        StringBuilder sb = new StringBuilder(elements + " " + queries + '\n');
        Random rand = new Random();
        for (int i = 0; i < plus; i++) {
            sb.append("+ " + (state-1) + " " + rand.nextInt(testel) + " " + rand.nextInt(testel) + '\n');
            state++;
        }
        for (int i = 0; i < quest; i++) {
            sb.append("? " + rand.nextInt(state) + " " + rand.nextInt(testel) + " " + rand.nextInt(testel) + '\n');
        }
        try {
            FileWriter fileWriter = new FileWriter("input.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // for controled scopes random numbers
//        sb = new StringBuilder(elements + " " + queries + '\n');
//        List<Integer> q = new ArrayList<>();
//        q.add(0);
//        state = 1;
//        for (int i = 0; i < queries; i++) {
//            if(rand.nextBoolean()){
//                sb.append("+ " + q.get(rand.nextInt(state)) + " " + rand.nextInt(testel) + " " + rand.nextInt(testel) + '\n');
//                state++;
//                q.add(i+1);
//            } else {
//                sb.append("? " + q.get(rand.nextInt(state)) + " " + rand.nextInt(testel) + " " + rand.nextInt(testel) + '\n');
//            }
//        }
//        try {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("input.txt"));
//            bufferedWriter.write(sb.toString());
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
