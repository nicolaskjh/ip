package cheeto.command;

import cheeto.task.TaskList;

public class MarkDoneCommand extends Command {
    private int idx;

    public MarkDoneCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String getResponse(TaskList taskList) {
        taskList.markDone(this.idx);
        return "I've marked this task as done:\n"
                + taskList.getTask(idx).toString();
    }
}
