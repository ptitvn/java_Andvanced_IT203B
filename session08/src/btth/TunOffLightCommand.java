package btth;

public class TunOffLightCommand implements Command {
    Light light;
    public TunOffLightCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
