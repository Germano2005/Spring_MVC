package com.germanomvc.registroweb.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView("hello"); //nome do arquivo html a ser exibido
        mv.addObject("nome", "Cabral");
        return mv; // o Spring vai renderizar o arquivo que está em templetes/hello.html
    }


    @GetMapping("/hello-model")
    public String hello(Model model){
        model.addAttribute("nome", "Germano");
        return "hello.html"; // o Spring vai renderizar o arquivo que está em templetes/hello.html
    }

    @GetMapping("/hello-servlet")
    public String hello(HttpServletRequest request){
        request.setAttribute("nome", "Zezinho");
        return "hello.html"; // o Spring vai renderizar o arquivo que está em templetes/hello.html
    }
    // o próprio Spring fica responsável de encontra o nome do arquivo nos templates, não é necessário chamar o arquivo por sua extensão
}
