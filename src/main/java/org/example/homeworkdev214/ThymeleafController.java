package org.example.homeworkdev214;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf-test")
    public String test(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "test";
    }
}
