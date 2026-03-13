package bt3;

public class TicketSupplier implements Runnable {

    private final TicketPool roomA;
    private final TicketPool roomB;
    private final int supplyCount;
    private final int interval;
    private final int rounds;

    public TicketSupplier(TicketPool roomA, TicketPool roomB,
                          int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {

        for (int i = 0; i < rounds; i++) {

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }

            roomA.addTickets(supplyCount);
            roomB.addTickets(supplyCount);
        }
    }
}