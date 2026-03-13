package bt5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 8);
        TicketPool roomC = new TicketPool("C", 12);

        BookingCounter c1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter c2 = new BookingCounter("Quầy 2", roomB);
        BookingCounter c3 = new BookingCounter("Quầy 3", roomC);
        BookingCounter c4 = new BookingCounter("Quầy 4", roomA);
        BookingCounter c5 = new BookingCounter("Quầy 5", roomB);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        Thread t5 = new Thread(c5);

        TimeoutManager manager =
                new TimeoutManager(Arrays.asList(roomA, roomB, roomC));

        Thread timeoutThread = new Thread(manager);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        timeoutThread.start();
    }
}
