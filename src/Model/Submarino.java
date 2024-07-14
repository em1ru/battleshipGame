package Model;

public class Submarino extends Embarcacao {
    public Submarino(char direcao) {
        super(1, direcao); // Tamanho do submarino é 1
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro) {
        return super.posicionar(linha, coluna, tabuleiro, 5); // O código '5' representa um submarino
    }
}
