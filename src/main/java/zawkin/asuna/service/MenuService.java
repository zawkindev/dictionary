package zawkin.asuna.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MenuService {
    public void printMenu(HashMap<String, String> options) {
        for (String key : options.keySet())
            System.out.println(key + ". " + options.get(key));

        System.out.print("\nEnter your choice: ");
    }

    public void assignMainMenu(HashMap<String, String> menu) {
        menu.clear();
        menu.put("1", "Multiple Choice");
        menu.put("2", "Add word");
        menu.put("3", "Word list");
    }
}
