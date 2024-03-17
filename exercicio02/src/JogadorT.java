import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JogadorT {
    public static String[] lista_nomes;
    public static String[] lista_sobrenomes;
    public static String[] lista_posicoes;
    public static String[] lista_clube;
    private String url_nomes = "https://venson.net.br/resources/data/nomes.txt";
    private String url_sobrenome = "https://venson.net.br/resources/data/sobrenomes.txt";
    private String url_posicoes = "https://venson.net.br/resources/data/posicoes.txt";
    private String url_clubes = "https://venson.net.br/resources/data/clubes.txt";
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private int idade;

    public String getNome() {
        return nome;
    }

    public String getDescricao(){
        return (getNome() + " " + getSobrenome() + " é um futebolista brasileiro de " + getIdade() +" anos que atua como " + getPosicao() + ". Atualmente defende o " + getClube() + ".");
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    public int getIdade() {
        return idade;
    }

    public JogadorT() throws Exception {
        if(lista_nomes == null || lista_sobrenomes == null || lista_posicoes == null || lista_clube == null){
            lista_nomes = returnGet(url_nomes);
            lista_sobrenomes = returnGet(url_sobrenome);
            lista_posicoes = returnGet(url_posicoes);
            lista_clube = returnGet(url_clubes);
        }
        this.nome = returnValue("nome",lista_nomes);
        this.sobrenome = returnValue("sobrenome",lista_sobrenomes);
        this.posicao = returnValue("posicao",lista_posicoes);
        this.clube = returnValue("clube",lista_clube);
        this.idade = returnAge(18,40);
    }

    public static String returnValue(String tipo, String[] lista) throws Exception{
        Random random = new Random();
        int randomIndex = random.nextInt(lista.length);
        if(tipo == "nome"){
            return capitalizarNome(lista[randomIndex]);
        } else if (tipo == "sobrenome") {
            return capitalizarNome(lista[randomIndex]);
        } else if (tipo == "posicao") {
            return lista[randomIndex];
        } else if (tipo == "clube") {
            return lista[randomIndex];
        } else{
            return "ERRO";
        }
    }

    public static Integer returnAge(int age_min, int age_max){
        Random rand = new Random();
        return rand.nextInt((age_max - age_min) + 1) + age_min;
    }

    public static String[] returnGet(String t) throws Exception {
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

        return (String[])temp_lista.toArray(new String[0]);

    }

    public static String capitalizarNome(String input) {
        String[] words = input.toLowerCase().split("\\s+");
        StringBuilder nome_correto = new StringBuilder();
        for (String word : words) {
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
            nome_correto.append(capitalizedWord).append(" ");
        }
        return nome_correto.toString().trim();
    }

}
