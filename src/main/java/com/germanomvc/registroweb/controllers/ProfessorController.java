package com.germanomvc.registroweb.controllers;


import com.germanomvc.registroweb.dto.RequisicaoNovoProfessor;
import com.germanomvc.registroweb.models.EStatusProfessor;
import com.germanomvc.registroweb.models.Professor;
import com.germanomvc.registroweb.repositories.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired // essa anotação analisa a dependencia abaixo e cria esse objeto para você e vai injetar automaticamente sem a necessidade de um controller
    private ProfessorRepository professorRepository;

    @GetMapping("/professores")
    public ModelAndView index(){


        List<Professor> professores = this.professorRepository.findAll(); // busca todos os dados contidos no banco de dados

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("Professores", professores);
        return mv;
    }

    @GetMapping("/professor/new")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("/professores/new");
        mv.addObject("statusProfessor", EStatusProfessor.values());

        return mv;
    }

    @PostMapping("/professores") // ao invés de ser GET usamos o POST por se tratar de dados sensíveis que não podem ser passados na URL
    public String create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult){
        System.out.println("\n ***************************TEM ERROS*******************");
        if (bindingResult.hasErrors()){
            return "redirect:/professores/new";
        }
        else {
            Professor professor = requisicao.toProfessor();
            this.professorRepository.save(professor); // inserindo um novo professor na base de dados
            return "redirect:/professores";
        }

    }

}
