package org.algosketch.union.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @GetMapping("post")
    @ResponseBody
    public  String hello() {
        return "abc";
    }
}