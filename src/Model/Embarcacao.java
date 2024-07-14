package Model;

public class Embarcacao {
    protected int tamanho;
    protected char direcao;
    protected int[][] partes;

    public Embarcacao(int tamanho, char direcao) {
        this.tamanho = tamanho;
        this.direcao = direcao;
        this.partes = new int[tamanho][2]; // Inicializa as partes da embarcação
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro) {
        int indiceLinha = linha - 'A';
        if (indiceLinha < 0 || indiceLinha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro[0].length) {
            return false; // Fora dos limites
        }

        for (int i = 0; i < tamanho; i++) {
            int x = indiceLinha;
            int y = coluna;
            if (direcao == 'H') {
                y += i;
            } else {
                x += i;
            }
            if (x < 0 || x >= tabuleiro.length || y < 0 || y >= tabuleiro[0].length || tabuleiro[x][y] != 0) {
                return false; // Posição inválida ou já ocupada
            }
        }

        for (int i = 0; i < tamanho; i++) {
            int x = indiceLinha;
            int y = coluna;
            if (direcao == 'H') {
                y += i;
            } else {
                x += i;
            }
            tabuleiro[x][y] = tamanho; // Marca a posição da embarcação com seu tamanho
        }
        return true;
    }

    public boolean posicionar(char linha, int coluna, int[][] tabuleiro, int codigo) {
        return posicionarComCodigo(linha, coluna, tabuleiro, codigo);
    }

    private boolean posicionarComCodigo(char linha, int coluna, int[][] tabuleiro, int codigo) {
        int indiceLinha = linha - 'A';
        if (indiceLinha < 0 || indiceLinha >= tabuleiro.length || coluna < 0 || coluna >= tabuleiro[0].length) {
            return false; // Fora dos limites
        }

        for (int i = 0; i < tamanho; i++) {
            int x = indiceLinha;
            int y = coluna;
            if (direcao == 'H') {
                y += i;
            } else {
                x += i;
            }
            if (x < 0 || x >= tabuleiro.length || y < 0 || y >= tabuleiro[0].length || tabuleiro[x][y] != 0) {
                return false; // Posição inválida ou já ocupada
            }
        }

        for (int i = 0; i < tamanho; i++) {
            int x = indiceLinha;
            int y = coluna;
            if (direcao == 'H') {
                y += i;
            } else {
                x += i;
            }
            tabuleiro[x][y] = codigo;
        }
        return true;
    }
}
