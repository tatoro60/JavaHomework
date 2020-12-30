package Homework.Homework7.Constants;

public enum GeneralCommands {
    FOOT("foot"), USER("user"),EXIT("exit");
    private String command;
    GeneralCommands(String cmd){
        this.command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public static GeneralCommands fromString(String orderName) {
        for (GeneralCommands cmd : GeneralCommands.values()) {
            if (cmd.getCommand().equalsIgnoreCase(orderName)) {
                return cmd;
            }
        }
        return null;
    }
}
