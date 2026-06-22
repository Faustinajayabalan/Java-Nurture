interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext creditCardContext = new PaymentContext(new CreditCardPayment());
        creditCardContext.executePayment(2000);

        PaymentContext payPalContext = new PaymentContext(new PayPalPayment());
        payPalContext.executePayment(3500);
    }
}