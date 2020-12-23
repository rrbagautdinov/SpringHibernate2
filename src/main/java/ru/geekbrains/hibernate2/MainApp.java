package ru.geekbrains.hibernate2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.hibernate2.configuration.AppConfiguration;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    }
}
