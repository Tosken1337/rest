package com.tosken.rest.controller;

import com.tosken.rest.model.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping(value = "/info")
    public Info getInfo() {
        return new Info("0.1.0");
    }
}
