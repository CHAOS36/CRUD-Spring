package com.ensat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // Renvoie la vue nommée "index.html" ou "index.jsp" selon votre configuration.
    }

}
