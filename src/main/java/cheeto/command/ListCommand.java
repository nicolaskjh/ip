package cheeto.command;

import cheeto.task.TaskList;

public class ListCommand extends Command {
    @Override
    public String getResponse(TaskList taskList) {
        if (taskList.getNumTasks() == 0) {
            return "You currently have no tasks!";
        } else {
            return "You currently have " + taskList.getNumTasks() + " tasks:\n"
                    + taskList.toString();
        }
    }
}
