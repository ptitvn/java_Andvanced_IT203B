package bt5;

public class Ticket {

    private String ticketId;
    private String roomName;

    private boolean isSold = false;
    private boolean isHeld = false;
    private boolean isVIP;

    private long holdExpiryTime;

    public Ticket(String ticketId, String roomName, boolean isVIP) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isVIP = isVIP;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}