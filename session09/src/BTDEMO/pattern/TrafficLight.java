package BTDEMO.pattern;

public class TrafficLight implements Runnable {

    private String state = "RED";

    public String getState() {
        return state;
    }

    private void changeState() {

        switch (state) {
            case "RED":
                state = "GREEN";
                break;

            case "GREEN":
                state = "YELLOW";
                break;

            case "YELLOW":
                state = "RED";
                break;
        }

        System.out.println(" Đèn giao thông chuyển sang: " + state);
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(3000);

                changeState();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
