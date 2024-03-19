import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\\ \n" + " \\ \n" + "  | \n" + "  |\n" + " ( )\n" + " \\|/\n" + "  |\n" + " / \\");
        String s = "Hello";

        Word a = new Word();
        arrToString s2 = new arrToString();

        System.out.println(Arrays.toString(a.wordArr(s)));
        System.out.println(s2.arrToString((a.wordArr(s))));

        Scanner input = new Scanner(System.in);
                String b = input.nextLine();


    }
}
