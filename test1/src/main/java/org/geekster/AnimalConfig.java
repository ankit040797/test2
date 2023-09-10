package org.geekster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AnimalConfig {
    @Bean
    public Dog dog() {
        return new Dog();
    }
}
