package bt5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool pool;

    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool pool) {
        this.counterName = counterName;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            boolean vip = random.nextBoolean();

            Ticket ticket = pool.holdTicket(vip, counterName);

            if (ticket != null) {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }

                pool.sellHeldTicket(ticket, counterName);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}