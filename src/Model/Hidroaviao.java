package Model;

public class Hidroaviao extends Embarcacao {
    public Hidroaviao(char direcao) {
        super(3, direcao); // Tamanho do hidroavião é 3
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro) {
        return super.posicionar(linha, coluna, tabuleiro, 2); // O código '2' representa um hidroavião
    }
}
