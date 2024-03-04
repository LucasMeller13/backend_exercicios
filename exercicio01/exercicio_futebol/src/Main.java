//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public Main() {
    }

    public static String returnGet(String t) throws Exception {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(t)).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String[] lista = ((String)response.body()).split("\n");
        List<String> temp_lista = new ArrayList();
        String[] var6 = lista;
        int randomIndex = lista.length;

        for(int var8 = 0; var8 < randomIndex; ++var8) {
            String nome = var6[var8];
            if (nome.contains("\"") && nome.contains(",")) {
                temp_lista.add(nome.replace("\"", "").replace(",", ""));
            } else if (nome.contains(",")) {
                temp_lista.add(nome.replace(",", ""));
            } else if (nome.contains("\"")) {
                temp_lista.add(nome.replace("\"", ""));
            } else {
                temp_lista.add(nome);
            }
        }

        lista = (String[])temp_lista.toArray(new String[0]);
        Random random = new Random();
        randomIndex = random.nextInt(lista.length);
        return lista[randomIndex];
    }

    public static Integer returnAge(int age_min, int age_max) throws Exception{
        int age = (int)(Math.random()*100);
        while (age <= age_min || age >= age_max){
            age = (int)(Math.random()*100);
        }
        return age;
    }

    public static void main(String[] args) throws Exception {
        String url_nomes = "https://venson.net.br/resources/data/nomes.txt";
        String url_sobrenome = "https://venson.net.br/resources/data/sobrenomes.txt";
        String url_posicoes = "https://venson.net.br/resources/data/posicoes.txt";
        String url_clubes = "https://venson.net.br/resources/data/clubes.txt";
        System.out.print(returnGet(url_nomes) + " " + returnGet(url_sobrenome) + " é um futebolista brasileiro de " + returnAge(18,40) +" anos que atua como " + returnGet(url_posicoes) + ". Atualmente defende o " + returnGet(url_clubes) + ".");
    }
}
