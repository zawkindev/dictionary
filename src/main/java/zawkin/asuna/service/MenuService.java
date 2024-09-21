package zawkin.asuna.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MenuService {
    public void printMenu(HashMap<String, String> options) {
        System.out.print("\n" + options.get("*") + "\n\n");
        for (String key : options.keySet())
            if (key != "*")
                System.out.println(key + ". " + options.get(key));

        System.out.print("\nEnter your choice: ");
    }

    public void assignMainMenu(HashMap<String, String> menu) {
        menu.clear();
        menu.put("*", "**** Main Menu ****");
        menu.put("1", "Multiple Choice");
        menu.put("2", "Add word");
        menu.put("3", "Wordlist");
    }
}
