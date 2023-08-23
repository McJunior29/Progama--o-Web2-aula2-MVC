package com.web.aula2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.web.aula2.model.DTO.AtletaDados;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
public class Atleta {
    private static int count;
    private int id;
    private String nome;
    private double peso;
    private double altura;
    private int idade;
    private double imc;
    private String classificacao;

    public Atleta(String nome, double peso, int idade, double imc, String classificacao) {
        count++;
        this.id = count;
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.imc = imc;
        this.classificacao = classificacao;
    }

    public Atleta(AtletaDados dados){
        count++;
        this.id = count;
        this.nome = dados.nome();
        this.peso= dados.peso();
        this.altura = dados.altura();
        this.idade = dados.idade();
        this.imc = this.calcularImc(peso, altura);
        this.classificacao = this.getClassification(imc);
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
