package com.csm.boot.initialboot.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
          UserModel alex= new UserModel(

                    "Alex Macedon",
                    "asd123",
                    "test@user.com",
                    "Iuliu-Maniu 22",
                    LocalDate.of(2000, Month.NOVEMBER,5)

            );
          repository.saveAll(
                  List.of(alex)
          );
        };
    }
}
