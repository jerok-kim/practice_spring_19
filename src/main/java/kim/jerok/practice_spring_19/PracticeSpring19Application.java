package kim.jerok.practice_spring_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Map;

@SpringBootApplication
public class PracticeSpring19Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PracticeSpring19Application.class, args);
        Map<String, Object> repositories = context.getBeansWithAnnotation(Repository.class);
        for (String key : repositories.keySet()) {
            System.out.println(key + " : " + repositories.get(key));
        }
    }

}
