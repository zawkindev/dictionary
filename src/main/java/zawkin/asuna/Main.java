package zawkin.asuna;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zawkin.asuna.controller.MainController;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MainController mainController = (MainController) context.getBean("mainController");

        mainController.start();
    }
}