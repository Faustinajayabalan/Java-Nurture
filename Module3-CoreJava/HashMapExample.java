import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<Integer, String> students =
                new HashMap<>();

        students.put(101, "John");
        students.put(102, "Mary");
        students.put(103, "David");

        System.out.println(students);

        System.out.println(
                "Student 102: "
                + students.get(102));
    }
}