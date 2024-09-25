package zawkin.asuna.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import zawkin.asuna.container.ComponentContainer;
import zawkin.asuna.model.WordModel;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

@Repository
public class WordsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HashMap<String, String> getWordlist() {
        String fileData = readFile();
        HashMap<String, String> dictionary = new HashMap<>();
        String previousWord = "";
        String currentWord = "";
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

    public String readFile() {
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

    public void addWord(WordModel word) {
        String sql = "insert into dictionary (eng, uzb) values(?, ?)";
        jdbcTemplate.update(sql, word.getName(), word.getTranslation());
    }

    public void createDictionaryTable() {
        String sql = "create table if not exists dictionary("
                + "id serial primary key,"
                + "eng varchar,"
                + "eng varchar);";
        jdbcTemplate.update(sql);
    }
}
