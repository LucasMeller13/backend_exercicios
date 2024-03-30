package com.example.exercicio04;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class Exerc04Controller {
    public static String[] paths = {"nomes.txt","sobrenomes.txt","posicoes.txt","clubes.txt"};
    public static ReadTxtFiles loader = new ReadTxtFiles(new DefaultResourceLoader());

    public static String[] lista_nomes;
    public static String[] lista_sobrenomes;
    public static String[] lista_posicoes;
    public static String[] lista_clube;
    public Map<String, String> map = new HashMap();

    static {
        try {
            lista_nomes = loader.abrirArquivo(paths[0]).split("\n");
            lista_sobrenomes = loader.abrirArquivo(paths[1]).split("\n");
            lista_posicoes = loader.abrirArquivo(paths[2]).split("\n");
            lista_clube = loader.abrirArquivo(paths[3]).split("\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String returnRandomElement(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array nula");
        }
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }

    public String returnMensagem(String[] arrayNome,String[] arraySobrenome,String[] arrayPosicao,String[] arrayClube){
        return (returnRandomElement(arrayNome) + " " + returnRandomElement(arraySobrenome) + " é um futebolista brasileiro de " + returnAge(18,40) +" anos que atua como " + returnRandomElement(arrayPosicao) + ". Atualmente defende o " + returnRandomElement(arrayClube) + ".");
    }

    public static String toJson(Map<String, String> map) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    public String returnMensagemJSON(String[] arrayNome,String[] arraySobrenome,String[] arrayPosicao,String[] arrayClube){
        map.put("nome",returnRandomElement(lista_nomes));
        map.put("sobrenome",returnRandomElement(lista_sobrenomes));
        map.put("idade", String.valueOf(returnAge(18,40)));
        map.put("posicao",returnRandomElement(lista_posicoes));
        map.put("clube",returnRandomElement(lista_clube));

        try {
            return toJson(map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer returnAge(int age_min, int age_max){
        Random rand = new Random();
        return rand.nextInt((age_max - age_min) + 1) + age_min;
    }

    @Autowired
    private Exer04Service exer04Service;

    @GetMapping("/mensagem")
    public String mensagemPadrao() {
        return exer04Service.printarMensagem(returnMensagem(lista_nomes,lista_sobrenomes,lista_posicoes,lista_clube));
    }

    @GetMapping("/mensagemJson")
    public String mensagemJSON() {
        return exer04Service.printarMensagem(returnMensagemJSON(lista_nomes,lista_sobrenomes,lista_posicoes,lista_clube));
    }
}
