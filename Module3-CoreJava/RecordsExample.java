record Student(int id, String name) {}

public class RecordsExample {

    public static void main(String[] args) {

        Student s =
                new Student(101, "John");

        System.out.println(s.id());
        System.out.println(s.name());
    }
}