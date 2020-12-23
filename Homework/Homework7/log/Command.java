package Homework.Homework7.log;

public enum Command {
    LOGIN("login"),SIGNUP("signup"),EXIT("exit");
    private String command;
    Command(String cmd){
        this.command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    public static Command fromString(String orderName) {
        for (Command cmd : Command.values()) {
            if (cmd.getCommand().equalsIgnoreCase(orderName)) {
                return cmd;
            }
        }
        return null;
    }
}
