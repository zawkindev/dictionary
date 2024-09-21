package zawkin.asuna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import zawkin.asuna.repository.WordsRepository;

@ComponentScan(basePackages = "zawkin.asuna")
public class SpringConfig {

    @Bean
    public WordsRepository wordsRepository(){
        return new WordsRepository();
    }
}
