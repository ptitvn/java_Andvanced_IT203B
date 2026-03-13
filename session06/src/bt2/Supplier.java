package bt2;

public class Supplier implements Runnable {

    private TicketPool pool;

    public Supplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000); // đợi 5s rồi thêm vé
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.addTickets(3);
    }
}