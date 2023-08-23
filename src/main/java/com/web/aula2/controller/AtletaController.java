package com.web.aula2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.aula2.model.Atleta;
import com.web.aula2.model.DTO.AtletaDados;

@Controller
@RequestMapping("/atletas")
public class AtletaController {
    List<Atleta> atletas = new ArrayList<>();
    
    @GetMapping
    public String loadAteltaForm(){
        return "atleta/cadastro";
    }

    @GetMapping("/cadastrar")
    public String cadastrarAtleta(AtletaDados dados, Model model){
        Atleta atleta = new Atleta(dados);
        atletas.add(atleta);
        model.addAttribute("atletas", atletas);
        return "atleta/exibir";
    }



}
