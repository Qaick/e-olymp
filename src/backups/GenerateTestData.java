package backups;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateTestData {
    public static void main(String[] args) {
        int elements = 100_000,
                testel = 50*elements/100,
                plus = 99*elements/100;
        int quest = elements-plus, state = 1, queries = plus + quest;
        StringBuilder sb = new StringBuilder(elements + " " + queries + '\n');
        Random rand = new Random();
        for (int i = 0; i < plus; i++) {
            sb.append("+ " + (state-1) + " " + (rand.nextInt(testel)+1) + " " + (rand.nextInt(testel)+1) + '\n');
            state++;
        }
        for (int i = 0; i < quest; i++) {
            sb.append("? " + rand.nextInt(state) + " " + (rand.nextInt(testel)+1) + " " + (rand.nextInt(testel)+1) + '\n');
        }
        try {
            FileWriter fileWriter = new FileWriter("input.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
