package Homework.Homework7.Constants;

public enum FootballerCommands {
    ADD("add"), REMOVE("remove"),SHOWALL("showall"),EXIT("exit"),SHOWMY("showmy");
    private String command;

    FootballerCommands(String cmd) {
        this.command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public static FootballerCommands fromString(String orderName) {
        for (FootballerCommands cmd : FootballerCommands.values()) {
            if (cmd.getCommand().equalsIgnoreCase(orderName)) {
                return cmd;
            }
        }
        return null;
    }
}
