package bt1;
public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private boolean reverseOrder;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, boolean reverseOrder) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.reverseOrder = reverseOrder;
    }

    @Override
    public void run() {
        sellComboDeadlock();
    }

    // Phiên bản gây deadlock
    public void sellComboDeadlock() {

        TicketPool first = reverseOrder ? roomB : roomA;
        TicketPool second = reverseOrder ? roomA : roomB;

        synchronized (first) {

            String ticket1 = first.getTicket();
            System.out.println(counterName + ": Đã lấy vé " + ticket1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(counterName + ": Đang chờ vé phòng " + second.getRoomName());

            synchronized (second) {

                String ticket2 = second.getTicket();

                if (ticket1 != null && ticket2 != null) {
                    System.out.println(counterName +
                            " bán combo thành công: " + ticket1 + " & " + ticket2);
                } else {

                    System.out.println(counterName + ": Bán combo thất bại");

                    if (ticket1 != null) first.returnTicket(ticket1);
                    if (ticket2 != null) second.returnTicket(ticket2);
                }
            }
        }
    }
}