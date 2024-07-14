package Model;

public class Cruzador extends Embarcacao {
    public Cruzador(char direcao) {
        super(4, direcao); // Tamanho do cruzador é 4
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro) {
        return super.posicionar(linha, coluna, tabuleiro, 3); // O código '3' representa um cruzador
    }
}
