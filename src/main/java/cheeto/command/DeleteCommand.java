package cheeto.command;

import cheeto.task.Task;
import cheeto.task.TaskList;

public class DeleteCommand extends Command {
    private int idx;

    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String getResponse(TaskList taskList) {
        Task removed = taskList.getTask(idx);
        taskList.removeTask(this.idx);
        return "Got it, I've removed this task:\n" + removed.toString() +
                "\nYou now have " + taskList.getNumTasks() + " tasks.";
    }
}