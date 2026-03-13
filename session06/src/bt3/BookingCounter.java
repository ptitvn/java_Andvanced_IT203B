package bt3;

public class BookingCounter implements Runnable {

    private final String name;
    private final TicketPool pool;
    private int sold = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            Ticket t = pool.sellTicket();

            if (t != null) {
                sold++;
                System.out.println(name + " đã bán vé " + t.getId());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public int getSold() {
        return sold;
    }
}