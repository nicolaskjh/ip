package lebron.command;

import lebron.task.TaskList;

/**
 * Represents a UnmarkDoneCommand to unmark a task as done
 */
public class UnmarkDoneCommand extends Command {
    private int idx;

    /**
     * Constructor for UnmarkDoneCommand
     *
     * @param idx The task number to be unmarked
     */
    public UnmarkDoneCommand(int idx) {
        this.idx = idx;
    }

    /**
     * Returns the response given upon successfully unmarking a task as done
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given upon successfully unmarking a task as done
     */
    @Override
    public String getResponse(TaskList taskList) {
        taskList.unmarkDone(this.idx);

        return "I've unmarked this task:\n"
                + taskList.getTask(idx).toString();
    }
}
