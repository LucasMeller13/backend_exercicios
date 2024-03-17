public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        Jogador jogador1 = new Jogador();
        System.out.println(jogador1.getDescricao());
        System.out.println("\t Nome: "+jogador1.getNome()+" "+jogador1.getSobrenome()+".");
        System.out.println("\t Idade: "+jogador1.getIdade()+".");
        System.out.println("\t Posição: "+jogador1.getPosicao()+".");
        System.out.println("\t Clube: "+jogador1.getClube()+".\n\n\n");

        JogadorGerador gerador = new JogadorGerador();
        Jogador[] jogadores = gerador.gerarJogadores(2);

        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getDescricao());
            System.out.println("\t Nome: "+jogador.getNome()+" "+jogador.getSobrenome()+".");
            System.out.println("\t Idade: "+jogador.getIdade()+".");
            System.out.println("\t Posição: "+jogador.getPosicao()+".");
            System.out.println("\t Clube: "+jogador.getClube()+".\n");
        }
    }
}