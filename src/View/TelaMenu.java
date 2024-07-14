package View;

import Controller.GameController;
import Model.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TelaMenu extends JFrame {
    private final GameController controller;

    public TelaMenu(GameController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("Batalha Naval - Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton novoJogoButton = new JButton("Novo Jogo");
        novoJogoButton.addActionListener(e -> iniciarNovoJogo());

        JButton carregarJogoButton = new JButton("Carregar Jogo");
        carregarJogoButton.addActionListener(e -> carregarJogo());

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> System.exit(0));

        panel.add(novoJogoButton);
        panel.add(carregarJogoButton);
        panel.add(sairButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void iniciarNovoJogo() {
        // Solicita os nomes dos jogadores
        String jogador1 = JOptionPane.showInputDialog(this, "Nome do Jogador 1:");
        String jogador2 = JOptionPane.showInputDialog(this, "Nome do Jogador 2:");

        if (jogador1 != null && jogador2 != null && !jogador1.isEmpty() && !jogador2.isEmpty()) {
            controller.iniciarNovoJogo(jogador1, jogador2);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Os nomes dos jogadores não podem estar vazios.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarJogo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Carregar estado do jogo");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            controller.carregarJogoExistente(fileToLoad.getAbsolutePath());
            dispose();
        }
    }
}
