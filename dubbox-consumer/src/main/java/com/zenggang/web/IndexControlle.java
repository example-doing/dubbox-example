package com.zenggang.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexControlle {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }
}
