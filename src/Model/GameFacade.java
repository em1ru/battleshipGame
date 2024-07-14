package Model;

import Controller.GameController;

public class GameFacade {
    private GameController controller;
    private Tabuleiro tabuleiro;

    public GameFacade() {
        controller = GameController.getInstance();
        tabuleiro = new Tabuleiro();
    }

    public void iniciarNovoJogo(String jogador1, String jogador2) {
        controller.iniciarNovoJogo(jogador1, jogador2);
    }

    public void iniciarAtaques() {
        controller.iniciarAtaques();
    }

    public void alternarJogador() {
        controller.alternarJogador();
    }

    public char getJogadorAtual() {
        return controller.getJogadorAtual();
    }

    // Adicione outros métodos conforme necessário para simplificar a interface com o controlador e o tabuleiro
}
