public class JogadorGerador {
    public Jogador[] gerarJogadores(int x) throws Exception{
        Jogador[] teste = new Jogador[x];
        for (int i = 0; i < x; i++){
            teste[i] = new Jogador();
        }
        return teste;
    }
}
