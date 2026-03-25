package HN_KS24_CNTT5_LeTrungDong;

public class Main {
    public static void main(String[] args) {
        TransferService service = new TransferService();
        service.transfer("ACC01", "ACC02", 1000);
    }
}
