package command;

import task.TaskList;

public abstract class Command {
    public abstract String getResponse(TaskList taskList);

    public boolean isExit() {
        return false;
    }
}
