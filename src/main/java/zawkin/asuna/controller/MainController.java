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
    private HashMap<String, String> menuOptions = new HashMap<>();

    public void start() {
        try {
            ComponentContainer.csvFile.createNewFile();
        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }

        menuService.assignMainMenu(menuOptions);

        while (true) {
            menuService.printMenu(menuOptions);
            String userChoice = ComponentContainer.scanner.next();
            switch (userChoice) {
                case "3":
                    HashMap<String, String> words = WordsRepository.getWordlist();
                    for (String key : words.keySet()) {
                        System.out.println(key + " - " + words.get(key));
                    }
                    menuService.assignMainMenu(menuOptions);
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
