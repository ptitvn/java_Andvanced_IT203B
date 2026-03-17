package src.Bai3;

import java.util.*;

public class RemoteControl {
    private Map<Integer, Command> slots = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int slot, Command command) {
        slots.put(slot, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + slot);
    }

    public void pressButton(int slot) {
        Command command = slots.get(slot);
        if (command != null) {
            command.execute();
            history.push(command);
        } else {
            System.out.println("Nút chưa được gán!");
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        } else {
            System.out.println("Không có lệnh để undo!");
        }
    }
}