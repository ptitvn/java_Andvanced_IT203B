package bt3;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {

        if (paymentMethod instanceof CODPayable cod) {
            cod.processCOD(amount);
        }
        else if (paymentMethod instanceof CardPayable card) {
            card.processCreditCard(amount);
        }
        else if (paymentMethod instanceof EWalletPayable wallet) {
            wallet.processMomo(amount);
        }
    }
}