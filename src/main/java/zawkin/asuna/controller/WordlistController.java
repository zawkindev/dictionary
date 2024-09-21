package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zawkin.asuna.repository.WordsRepository;

import java.util.HashMap;

@Controller
public class WordlistController {
    @Autowired
    private WordsRepository wordsRepository;

    public void printList() {
        HashMap<String, String> words = wordsRepository.getWordlist();
        for (String key : words.keySet()) {
            System.out.println(key + " - " + words.get(key));
        }
    }
}
