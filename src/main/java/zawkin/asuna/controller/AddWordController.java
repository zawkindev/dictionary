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
        System.out.print("\nEnter word: ");
        String name = ComponentContainer.scanner.next();
        System.out.print("Enter translation: ");
        String translation = ComponentContainer.scanner.next();

        wordsRepository.addWord(new WordModel(name, translation));
    }
}
