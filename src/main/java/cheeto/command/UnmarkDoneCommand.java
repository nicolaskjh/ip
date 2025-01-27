package cheeto.command;

import cheeto.task.TaskList;

public class UnmarkDoneCommand extends Command {
    private int idx;

    public UnmarkDoneCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String getResponse(TaskList taskList) {
        taskList.unmarkDone(this.idx);

        return "I've unmarked this task:\n"
                + taskList.getTask(idx).toString();
    }
}
