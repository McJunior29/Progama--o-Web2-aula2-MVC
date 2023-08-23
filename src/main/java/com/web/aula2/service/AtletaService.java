package com.web.aula2.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.web.aula2.model.Atleta;
import com.web.aula2.model.DTO.AtletaDados;
import com.web.aula2.model.DTO.AtletaResponse;

public class AtletaService {
    
    public AtletaResponse cadastrarAtleta(AtletaDados dados){
        Atleta atleta = new Atleta();
        double imc = this.calcularImc(dados.peso(), dados.altura());
        atleta.setNome(dados.nome());
        atleta.setAltura(dados.altura());
        atleta.setPeso(dados.peso());
        atleta.setImc(imc);
        atleta.setClassificacao(this.getClassification(imc));
        
        return null;
    }

    private double calcularImc(double height, double weight){
        double heightModel = height;
        double weightModel = weight;

        double imc = weightModel / (heightModel*2) ;
        int scale = 2; 
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        
        BigDecimal imcBigDecimal = new BigDecimal(imc).setScale(scale, roundingMode);
        double roundedImc = imcBigDecimal.doubleValue();

        return roundedImc;
    }

    private String getClassification(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }
}
