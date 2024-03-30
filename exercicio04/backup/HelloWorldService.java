package com.example.exercicio04;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String gerarOlaMundo(String mensagem) {
        return mensagem;
    }
}
