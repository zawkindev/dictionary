package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zawkin.asuna.container.ComponentContainer;
import zawkin.asuna.repository.WordsRepository;

import java.util.*;

@Controller
public class MultipleChoiceController {
    private WordsRepository wordsRepository;

    public void run() {
        HashMap<String, String> wordlist = wordsRepository.getWordlist();
        String[] keys = wordlist.keySet().toArray(new String[0]);
        ArrayList<String> values = new ArrayList<>(wordlist.values());
        int totalTests = values.size();
        int totalCorrectAnswers = 0;

        for (int i = 0; i < totalTests; i++) {
            String currentWord = keys[i];                           // English word
            String currentTranslation = wordlist.get(currentWord);  // Translation
            System.out.printf("\nQuestion (%d/%d): %s - ?\n", i, totalTests, currentWord);

            HashMap<String, String> options = generateOptions(currentTranslation, values);
            for (String optKey : options.keySet()) {
                System.out.printf("%s. %s\n", optKey, options.get(optKey));
            }

            System.out.print("\nAnswer: ");
            String userChoice = ComponentContainer.scanner.next();
            if (currentTranslation == options.get(userChoice)) {
                totalCorrectAnswers++;
            }
            ComponentContainer.clearTerminal();
        }

        System.out.printf("\nResult: %d/%d\n", totalCorrectAnswers, totalTests);
    }

    public HashMap<String, String> generateOptions(String correctAnswer, ArrayList<String> values) {
        HashSet<String> randomValues = new HashSet<>();
        String[] characters = {"a", "b", "c", "d"};
        int totalOptions = Math.min(values.size(), 4);


        int randomIndex = ComponentContainer.random.nextInt(totalOptions);
        while (randomValues.size() < totalOptions) {
            int randomNumber = ComponentContainer.random.nextInt(totalOptions);
            if (randomIndex == randomValues.size() && !randomValues.contains(correctAnswer)) {
                randomValues.add(correctAnswer);
            } else {
                randomValues.add(values.get(randomNumber));
            }
        }

        HashMap<String, String> options = new HashMap<>();
        String[] randomValuesArray = randomValues.toArray(new String[0]);
        for (int i = 0; i < totalOptions; i++) {
            options.put(characters[i], randomValuesArray[i]);
        }

        return options;
    }
}
