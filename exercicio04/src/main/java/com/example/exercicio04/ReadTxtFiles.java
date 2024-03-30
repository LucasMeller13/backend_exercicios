package com.example.exercicio04;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.nio.charset.StandardCharsets;

public class ReadTxtFiles {
    private final ResourceLoader resourceLoader;

    public ReadTxtFiles(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String abrirArquivo(String nomeArquivo) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:txtFiles/" + nomeArquivo);
        return lerConteudo(resource);
    }

    private String lerConteudo(Resource resource) throws Exception {
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
