package ru.yandex.practicum.quiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yandex.practicum.quiz.model.QuizLog;
import ru.yandex.practicum.quiz.service.ConsoleUI;
import ru.yandex.practicum.quiz.service.ReportGenerator;

@SpringBootApplication
public class QuizApp implements CommandLineRunner {
    private final ConsoleUI ui;
    private final ReportGenerator reportGenerator;

    // Явный конструктор для Spring
    public QuizApp(ConsoleUI ui, ReportGenerator reportGenerator) {
        this.ui = ui;
        this.reportGenerator = reportGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(QuizApp.class, args);
    }

    @Override
    public void run(String... args) {
        QuizLog log = ui.startQuiz();
        reportGenerator.generate(log);
    }
}