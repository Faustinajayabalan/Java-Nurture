public class MethodOverloading {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        MethodOverloading obj = new MethodOverloading();

        System.out.println("Sum of 2 Integers = " + obj.add(10, 20));

        System.out.println("Sum of 2 Doubles = " + obj.add(10.5, 20.5));

        System.out.println("Sum of 3 Integers = " + obj.add(10, 20, 30));
    }
}