package zawkin.asuna.repository;

import zawkin.asuna.container.ComponentContainer;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WordsRepository {
    public static HashMap<String, String> getWordlist() {
        String fileData = readFile();
        HashMap<String, String> dictionary = new HashMap<String, String>();
        String currentWord = "";
        String previousWord = "";
        char c;
        for (int i = 0; i < fileData.length(); i++) {
            c = fileData.charAt(i);
            switch (c) {
                case ',':
                    previousWord = currentWord;
                    currentWord = "";
                    break;
                case '\n':
                    dictionary.put(previousWord, currentWord);
                    previousWord = "";
                    currentWord = "";
                    break;
                default:
                    currentWord += Character.toString(c);
            }
        }
        return dictionary;
    }

    public static String readFile() {
        String data = "";
        try {
            Scanner reader = new Scanner(ComponentContainer.csvFile);
            while (reader.hasNextLine()) {
                data += reader.nextLine() + "\n";
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return data;
    }
}
