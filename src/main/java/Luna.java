public class Luna {
    private static Add add;
    private static TaskList taskList;

    public static void main(String[] args) {
        Luna.entry();
        add = new Add();
        taskList = new TaskList();
        while (!add.isClosed()) {
            String input = add.read();
            switch (input) {
                case "bye":
                    add.close();
                    break;
                case "list":
                    taskList.listTasks();
                    break;
                default:
                    taskList.addTask(input);
                    add.printAddedTask(input);
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
