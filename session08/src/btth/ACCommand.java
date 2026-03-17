package btth;

public class ACCommand implements Command {
    AC ac;
    int newTemp;
    int oldTemp;

    public ACCommand(AC ac, int newTemp){
        this.ac = ac;
        this.newTemp = newTemp;
    }


    @Override
    public void execute() {
        this.oldTemp = ac.getTemp();
        ac.changeTemp(newTemp);
        System.out.println(
                oldTemp > newTemp ?
                        "đang giảm nhiệt độ " :
                        "đang tăng nhiệt độ");

    }

    @Override
    public void undo() {
        ac.changeTemp(oldTemp);
        System.out.println("Đã trở lại nhiệt độ cũ" + ac.getTemp());
    }
}
