package ru.yandex.practicum.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import ru.yandex.practicum.quiz.model.QuizLog;
import ru.yandex.practicum.quiz.service.ConsoleUI;
import ru.yandex.practicum.quiz.service.ReportGenerator;

@SpringBootApplication
@RequiredArgsConstructor // Lombok автоматически создаст конструктор для final полей
@ConfigurationPropertiesScan
public class QuizApp implements CommandLineRunner {
    private final ConsoleUI ui; // Внедряемый компонент
    private final ReportGenerator reportGenerator; // Внедряемый компонент

    public static void main(String[] args) {
        SpringApplication.run(QuizApp.class, args);
    }

    @Override
    public void run(String... args) {
        QuizLog log = ui.startQuiz(); // Запускаем тест через ConsoleUI
        reportGenerator.generate(log); // Генерируем отчет через ReportGenerator
    }
}