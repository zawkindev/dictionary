package zawkin.asuna.container;

import java.io.File;
import java.util.Scanner;

public class ComponentContainer {
    public static String fileName = "dictionary.csv";
    public static Scanner scanner = new Scanner(System.in);
    public static File csvFile = new File(fileName);
}
