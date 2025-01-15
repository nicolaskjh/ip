public class Luna {
    private static Add add;
    private static TaskList taskList;

    public static void main(String[] args) {
        Luna.entry();
        add = new Add();
        taskList = new TaskList();
        while (!add.isClosed()) {
            String input = add.readCommand();
            switch (input) {
                case "bye":
                    add.close();
                    break;
                case "list":
                    taskList.listTasks();
                    break;
                case "mark":
                    int markTaskId = Integer.parseInt(add.readInput());
                    taskList.markTaskDone(markTaskId);
                    break;
                case "unmark":
                    int unmarkTaskId = Integer.parseInt(add.readInput());
                    taskList.markTaskNotDone(unmarkTaskId);
                    break;
                default:
                    String description = input + add.readInput();
                    taskList.addTask(new Task(description));
            }
        }
        Luna.exit();
    }

    public static void entry() {
        System.out.println("--------------------------------------");
        System.out.println("Hello! I'm Luna!");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
    }

    public static void exit() {
        System.out.println("-------------------------------------");
        System.out.println("Hope to see you again soon! meow");
        System.out.println("-------------------------------------");
    }
}
