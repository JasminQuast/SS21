package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

        @Autowired
        private Environment enw;

        @RequestMapping("/")
        public String index() {
            return "Hello World!";
        }
}

