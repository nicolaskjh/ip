import java.util.Scanner;

public class Echo {
    private Scanner sc = new Scanner(System.in);

    public String read() {
        return sc.nextLine();
    }

    public void echo(String message) {
        System.out.println("--------------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------------");
    }
}
