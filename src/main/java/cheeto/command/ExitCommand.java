package cheeto.command;

import cheeto.task.TaskList;

public class ExitCommand extends Command {
    @Override
    public String getResponse(TaskList taskList) {
        return "Hope to see you again soon! meow";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
