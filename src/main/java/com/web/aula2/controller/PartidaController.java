package com.web.aula2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.aula2.model.Partida;
import com.web.aula2.model.DTO.PartidaDTO;

@Controller
@RequestMapping("/partidas")
public class PartidaController {

     List<Partida> partidas = new ArrayList<>();
    
    @GetMapping
    public String loadPartidaForm(){
        return "partida/cadastro";
    }

    @GetMapping("/cadastrar")
    public String cadastrarPartida(PartidaDTO dados, Model model){
        Partida partida = new Partida(dados);
        partidas.add(partida);
        model.addAttribute("partidas",partidas);
        return "partida/exibir";
    }
    
}
