import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            personList.add(new Person(array[0], array[1]));
        }

        /**
         * 비교
         */
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                Person person = personList.get(i);
                Person cmpPerson = personList.get(j);

                if (person.getHeight() < cmpPerson.getHeight() && person.getWeight() < cmpPerson.getWeight())
                    person.upRank();
            }
        }


        for (Person person : personList) {
            System.out.print(person.getRank() + " ");
        }
    }

    static class Person {
        private int weight;
        private int height;
        private int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public int getRank() {
            return rank;
        }

        public void upRank() {
            rank++;
        }
    }
}