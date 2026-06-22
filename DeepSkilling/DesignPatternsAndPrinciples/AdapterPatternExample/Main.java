interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    void makePayment(double amount) {
        System.out.println("Payment of " + amount + " processed through PayPal");
    }
}

class StripeGateway {
    void payAmount(double amount) {
        System.out.println("Payment of " + amount + " processed through Stripe");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        stripeGateway.payAmount(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        paypal.processPayment(1500);
        stripe.processPayment(2500);
    }
}