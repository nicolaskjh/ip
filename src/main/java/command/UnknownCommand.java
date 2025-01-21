package command;

import task.TaskList;

public class UnknownCommand extends Command {
    @Override
    public String getResponse(TaskList taskList) {
        return "I'm not sure what you mean by this meow :(";
    }
}
