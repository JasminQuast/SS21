package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController(Endpoints.Site.DIARYST).setViewName(ViewNames.DIARYST);
            registry.addViewController(Endpoints.Site.SLASH).setViewName(ViewNames.DIARYST);
            registry.addViewController(Endpoints.Site.TODAY).setViewName(ViewNames.TODAY);
            registry.addViewController(Endpoints.Site.OVERVIEW).setViewName(ViewNames.OVERVIEW);
            registry.addViewController(Endpoints.Site.SETTINGS).setViewName(ViewNames.SETTINGS);

            registry.addViewController(Endpoints.Site.LOGIN).setViewName(ViewNames.LOGIN);
        }

        @Bean
        LocaleResolver localeResolver() {
            return new FixedLocaleResolver(Locale.ENGLISH);
        }

}
