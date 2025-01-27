package cheeto.command;

import cheeto.task.Task;
import cheeto.task.TaskList;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String getResponse(TaskList taskList) {
        taskList.addTask(this.task);
        return "Got it, I've added this cheeto.task:\n" + this.task.toString() +
                "\nYou now have " + taskList.getNumTasks() + " tasks.";
    }
}
