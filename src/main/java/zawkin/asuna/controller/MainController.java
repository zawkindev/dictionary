package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zawkin.asuna.container.ComponentContainer;
import zawkin.asuna.repository.WordsRepository;
import zawkin.asuna.service.MenuService;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class MainController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private AddWordController addWordController;
    @Autowired
    private WordlistController wordlistController;
    @Autowired
    private MultipleChoiceController multipleChoiceController;

    private HashMap<String, String> menuOptions = new HashMap<>();

    public void start() {
        try {
            ComponentContainer.csvFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        menuService.assignMainMenu(menuOptions);

        while (true) {
            menuService.printMenu(menuOptions);
            String userChoice = ComponentContainer.scanner.next();
            switch (userChoice) {
                case "1":
                    multipleChoiceController.run();
                    menuService.assignMainMenu(menuOptions);
                    break;
                case "2":
                    addWordController.run();
                    wordlistController.printList();
                    menuService.assignMainMenu(menuOptions);
                    ComponentContainer.clearTerminal();
                    break;
                case "3":
                    wordlistController.printList();
                    menuService.assignMainMenu(menuOptions);
                    break;
                default:
                    System.out.println("This option doesn't exist!!!");
            }
        }
    }
}
