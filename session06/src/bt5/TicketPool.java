package bt5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {

            boolean vip = (i <= 2);

            String id = roomName + "-" + String.format("%03d", i);

            tickets.add(new Ticket(id, roomName, vip));
        }
    }

    public synchronized Ticket holdTicket(boolean wantVIP, String counterName) {

        for (Ticket t : tickets) {

            if (!t.isSold() && !t.isHeld()) {

                if (!wantVIP || t.isVIP()) {

                    t.setHeld(true);

                    t.setHoldExpiryTime(System.currentTimeMillis() + 5000);

                    System.out.println(counterName + ": Đã giữ vé "
                            + t.getTicketId() + (t.isVIP() ? " (VIP)" : "")
                            + ". Thanh toán trong 5s");

                    return t;
                }
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket t, String counterName) {

        if (t != null && t.isHeld() && !t.isSold()) {

            t.setSold(true);
            t.setHeld(false);

            System.out.println(counterName + ": Thanh toán thành công vé "
                    + t.getTicketId());
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld() && !t.isSold() && now > t.getHoldExpiryTime()) {

                t.setHeld(false);

                System.out.println("TimeoutManager: Vé "
                        + t.getTicketId()
                        + " hết hạn giữ, trả lại kho");
            }
        }
    }
}