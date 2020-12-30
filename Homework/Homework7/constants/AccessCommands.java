package Homework.Homework7.Constants;

public enum AccessCommands {
    LOGIN("login"),SIGNUP("signup"),EXIT("exit");
    private String command;
    AccessCommands(String cmd){
        this.command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public static AccessCommands fromString(String orderName) {
        for (AccessCommands cmd : AccessCommands.values()) {
            if (cmd.getCommand().equalsIgnoreCase(orderName)) {
                return cmd;
            }
        }
        return null;
    }
}
