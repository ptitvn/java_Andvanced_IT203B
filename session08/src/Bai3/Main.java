package src.Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán command");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chon :");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Chọn nút:");
                    int slot = sc.nextInt();

                    System.out.println("1.Light ON  2.Light OFF  3.Fan ON  4.Fan OFF  5.AC set temp");
                    int type = sc.nextInt();

                    Command command = null;

                    switch (type) {
                        case 1:
                            command = new LightOnCommand(light);
                            break;
                        case 2:
                            command = new LightOffCommand(light);
                            break;
                        case 3:
                            command = new FanOnCommand(fan);
                            break;
                        case 4:
                            command = new FanOffCommand(fan);
                            break;
                        case 5:
                            System.out.println("Nhập nhiệt độ:");
                            int temp = sc.nextInt();
                            command = new ACSetTemperatureCommand(ac, temp);
                            break;
                    }

                    if (command != null) {
                        remote.setCommand(slot, command);
                    }
                    break;

                case 2:
                    System.out.println("Nhấn nút:");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 0:
                    return;
            }
        }
    }
}