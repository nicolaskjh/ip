public class Luna {
    private static Echo echo;

    public static void main(String[] args) {
        Luna.entry();
        echo = new Echo();
        while (true) {
            String input = echo.read();
            if (input.equals("bye")) {
                break;
            }
            echo.echo(input);
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
