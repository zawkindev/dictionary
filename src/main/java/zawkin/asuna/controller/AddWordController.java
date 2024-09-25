package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zawkin.asuna.container.ComponentContainer;
import zawkin.asuna.model.WordModel;
import zawkin.asuna.repository.WordsRepository;

@Controller
public class AddWordController {
    @Autowired
    private WordsRepository wordsRepository;

    public void run() {
        WordModel word = new WordModel();

        System.out.print("\nEnter word: ");
        String name = ComponentContainer.scanner.next();
        word.setEng(name);

        System.out.print("Enter translation: ");
        String translation = ComponentContainer.scanner.next();
        word.setUzb(translation);

        wordsRepository.addWord(word);
    }
}
