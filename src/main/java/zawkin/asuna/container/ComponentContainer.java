package zawkin.asuna.container;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ComponentContainer {
    public static String fileName = "dictionary.csv";
    public static Scanner scanner = new Scanner(System.in);
    public static File csvFile = new File(fileName);
    public static Random random = new Random();

    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
