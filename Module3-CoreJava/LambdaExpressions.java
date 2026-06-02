interface Message {

    void display();
}

public class LambdaExpressions {

    public static void main(String[] args) {

        Message msg =
                () -> System.out.println(
                        "Hello Lambda");

        msg.display();
    }
}