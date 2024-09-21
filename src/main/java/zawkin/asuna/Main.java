package zawkin.asuna;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zawkin.asuna.config.SpringConfig;
import zawkin.asuna.controller.MainController;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MainController mainController = (MainController) context.getBean("mainController");

        mainController.start();
    }
}