package lebron.command;

import lebron.task.TaskList;

/**
 * Represents an easter egg SingCommand class
 */
public class SingCommand extends Command {
    /**
     * Returns the lyrics to the chorus of Drake's Forever song
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Lyrics to the chorus of Drake's Forever song
     */
    @Override
    public String getResponse(TaskList taskList) {
        return "IT MAY NOT MEAN NOTHING TO YALL\n"
                + "BUT UNDERSTAND NOTHING WAS DONE FOR ME\n"
                + "SO I DONT PLAN ON STOPPING AT ALL\n"
                + "I WANT THIS FOREVER MINE EVER MINE EVER MINE";
    }
}
