package Controller;

import Model.Tabuleiro;
import View.TelaAtaques;
import View.TelaMenu;
import View.TelaPosicionamento;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameController {
    private static GameController instance; // Singleton instance

    private Tabuleiro tabuleiro;
    private String jogador1;
    private String jogador2;
    private char jogadorAtual;

    private GameController() {
        System.out.println("GameController iniciado.");
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = '1';
        new TelaMenu(this); // Inicializa a tela de menu ao iniciar o controlador
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void iniciarNovoJogo(String jogador1, String jogador2) {
        System.out.println("Iniciando novo jogo. Jogador 1: " + jogador1 + ", Jogador 2: " + jogador2);
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro.criacaoTabuleiros();

        JFrame frame = new JFrame("Posicionamento - Jogador 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TelaPosicionamento(jogador1, jogador2, tabuleiro, this));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void iniciarAtaques() {
        System.out.println("Iniciando etapa de ataques.");
        new TelaAtaques(tabuleiro, jogadorAtual, this);
    }

    public void alternarJogador() {
        jogadorAtual = (jogadorAtual == '1') ? '2' : '1';
        System.out.println("Jogador alternado para: " + jogadorAtual);
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }

    public void verificarVitoria() {
        if (tabuleiro.jogadorPerdeu('2')) {
            JOptionPane.showMessageDialog(null, "Jogador 1 venceu!");
            reiniciarJogo();
        } else if (tabuleiro.jogadorPerdeu('1')) {
            JOptionPane.showMessageDialog(null, "Jogador 2 venceu!");
            reiniciarJogo();
        }
    }

    public void reiniciarJogo() {
        instance = new GameController(); // Reinicia o controlador
        new TelaMenu(instance); // Volta para o menu inicial
    }

    public void carregarJogoExistente(String caminhoArquivo) {
        tabuleiro.carregarEstado(caminhoArquivo);
        iniciarAtaques();
    }
}
