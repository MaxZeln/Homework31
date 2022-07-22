package ru.learnup.learnup.spring.mvc.homework31.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/resource")
    public String auth() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "SUCCESS AUTH:" + principal;
    }
}
