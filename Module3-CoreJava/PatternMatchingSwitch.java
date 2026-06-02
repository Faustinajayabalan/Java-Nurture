public class PatternMatchingSwitch {

    public static void main(String[] args) {

        Object obj = "Hello";

        String result = switch(obj) {

            case String s ->
                    "String: " + s;

            case Integer i ->
                    "Integer: " + i;

            default ->
                    "Unknown";
        };

        System.out.println(result);
    }
}