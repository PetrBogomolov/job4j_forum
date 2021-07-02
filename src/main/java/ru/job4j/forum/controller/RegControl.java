package ru.job4j.forum.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.entity.User;
import ru.job4j.forum.service.RegAndAuthService;

@Controller
public class RegControl {
    private final RegAndAuthService regAndAuthService;

    public RegControl(RegAndAuthService regAndAuthService) {
        this.regAndAuthService = regAndAuthService;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String informAboutUserAlreadyReg() {
        return "redirect:/reg?regError=true";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "regError", required = false) String regError,
                      Model model) {
        String errorMessage = null;
        if (regError != null) {
            errorMessage = "Такой пользователь уже зарегистрирован";
        }
        model.addAttribute("error", errorMessage);
        return "reg/reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        regAndAuthService.save(user);
        return "auth/login";
    }
}
