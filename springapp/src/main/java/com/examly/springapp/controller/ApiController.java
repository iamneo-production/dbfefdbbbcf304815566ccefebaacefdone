package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.ChildBean;

@RestController
@RequestMapping("/demo")
public class ApiController {
    private final ChildBean childBean;

    public ApiController(ChildBean childBean) {
        this.childBean = childBean;
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Message from Child Bean: " + childBean.getMessage();
    }
}
