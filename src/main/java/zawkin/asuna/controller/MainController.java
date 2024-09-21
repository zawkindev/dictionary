package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import zawkin.asuna.service.MenuService;

import java.util.HashMap;
import java.util.Scanner;

@Controller
public class MainController {
    @Autowired
    private MenuService menuService;
    private HashMap<String, String> menuOptions = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        menuService.assignMainMenu(menuOptions);

        while (true) {
            menuService.printMenu(menuOptions);
            String userChoice = scanner.next();
        }
    }
}
