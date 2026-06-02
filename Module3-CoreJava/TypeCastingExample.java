public class TypeCastingExample {
    public static void main(String[] args) {

        double d = 25.89;
        int a = (int)d;

        System.out.println("Double to Int = " + a);

        int b = 50;
        double c = b;

        System.out.println("Int to Double = " + c);
    }
}