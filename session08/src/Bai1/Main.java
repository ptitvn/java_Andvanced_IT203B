package src.Bai1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();
        HardwareConnection connection = HardwareConnection.getInstance();

        while (true) {
            System.out.println("""
                      ===== MENU =====
                      1. Kết nối phần cứng
                      2. Tạo thiết bị
                      3. Bật thiết bị
                      4. Tắt thiết bị
                      0. Thoát 
                    """);
            System.out.println("Nhập lựa chọn : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    connection.connect();
                    break;

                case 2:
                    System.out.println("Chọn loại: 1. Đèn  2. Quạt  3. Điều hòa");
                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();
                    else {
                        System.out.println("Lựa chọn sai!");
                        continue;
                    }

                    Device device = factory.createDevice();
                    devices.add(device);
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    System.out.println("Chọn thiết bị:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1));
                    }

                    int onIndex = sc.nextInt() - 1;
                    devices.get(onIndex).turnOn();
                    break;

                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    System.out.println("Chọn thiết bị:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1));
                    }

                    int offIndex = sc.nextInt() - 1;
                    devices.get(offIndex).turnOff();
                    break;

                case 0:
                    System.out.println("Thoát!");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}
