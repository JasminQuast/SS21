//package com.example.demo;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class NoteConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(DiaryRepository diaryRepository) {
//        return args -> {
//            Note note1 = new Note(
//                    "I'm a new headline",
//                    "I'm a new text ...",
//                    1,
//                    LocalDate.of(2011, Month.APRIL,4)
//                );
//            Note note2 = new Note(
//                    "I'm a new headline from note 2",
//                    "I'm a text ...",
//                    5,
//                    LocalDate.of(2019, Month.APRIL,30)
//            );
//            diaryRepository.saveAll(
//                    List.of(note1, note2)
//            );
//        };
//
//    }
//}
