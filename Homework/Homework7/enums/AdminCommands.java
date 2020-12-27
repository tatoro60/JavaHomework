package Homework.Homework7.enums;

public enum AdminCommands {
    ADD("add"), SAVE("save"), REMOVE("remove"),SHOW("show"),EXIT("exit");
    private String command;

    AdminCommands(String cmd) {
        this.command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public static AdminCommands fromString(String orderName) {
        for (AdminCommands cmd : AdminCommands.values()) {
            if (cmd.getCommand().equalsIgnoreCase(orderName)) {
                return cmd;
            }
        }
        return null;
    }
}
