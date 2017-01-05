package backups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MakeMagic_v1 {
    static class Query {
        public Integer sign;//0 +, 1 ?
        public Integer s;
        public Integer a;
        public Integer b;

        public Query(Integer sign, Integer s, Integer a, Integer b) {
            this.sign = sign;
            this.s = s;
            this.a = a;
            this.b = b;
        }
    }

    static class Future {
        public Future f;

        Future(Future f) {
            this.f = f;
        }
    }

    public static void main(String[] args) {
        String line;
        int elem = 0, linesCount = 0, counter = 0, question = 0;
        Query[] lines = new Query[0];
        //TODO probably better to read in Query
        List<Integer> statesSave = new ArrayList<>();
        Integer state;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            String[] ss = bufferedReader.readLine().split("\\s");
            elem = Integer.valueOf(ss[0]);
            linesCount = Integer.valueOf(ss[1]);
            lines = new Query[linesCount];
            while ((line = bufferedReader.readLine()) != null) {
                ss = line.split("\\s");
                state = Integer.valueOf(ss[1]);
//                lines[counter++] = new Query(state, Integer.valueOf(ss[2]), Integer.valueOf(ss[3]));
                if (line.charAt(0) == '?') {
                    question++;
                    statesSave.add(state);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tooth array

        //TODO find what states i should save

        //TODO firstable solve coherent instruction
        int row = 0;
        Future[] system = new Future[elem + 1];
        Future root1, root2;
        for (Query query : lines) {
            root1 = system[query.a];
            root2 = system[query.b];
            if (root1 == null) {
                root1 = new Future(null);
                system[query.a] = root1;
            } else while (root1.f != null) root1=root1.f;
//                if(root1.f != null) { rootShouldBeOne = true;

            if (root2 == null) {
                root2 = new Future(null);
                system[query.b] = root2;
            } else while (root2.f != null) root2=root2.f;

            root2.f = root1;
        }


        StringBuilder answer = new StringBuilder();


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            bufferedWriter.write(answer.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
