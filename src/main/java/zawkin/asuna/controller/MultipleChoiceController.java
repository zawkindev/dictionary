package zawkin.asuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import zawkin.asuna.service.MenuService;

@Controller
public class MultipleChoiceController {
    @Autowired
    private MenuService menuService;

    public void start(){

    }
}
