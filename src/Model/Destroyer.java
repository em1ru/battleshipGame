package Model;

public class Destroyer extends Embarcacao {
    public Destroyer(char direcao) {
        super(2, direcao); // Tamanho do destroyer é 2
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro) {
        return super.posicionar(linha, coluna, tabuleiro, 4); // O código '4' representa um destroyer
    }
}
