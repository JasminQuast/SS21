package com.example.demo.web;

import com.example.demo.config.Endpoints;
import com.example.demo.config.ViewNames;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//public class IndexController {
//    @GetMapping(value= {Endpoints.Site.HOME})
//    public ModelAndView getCurrentUser(@AuthenticationPrincipal OidcUser user) {
//        Map<String, Object> viewModel = new HashMap<>();
//        if(user != null){
//            viewModel.put("name", user.getGivenName());
//        }
//        return new ModelAndView(ViewNames.HOME, viewModel);
//    }
//
//}

