package View;

import Controller.GameController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JFrame {
    private GameController controller;

    public TelaMenu(GameController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("Batalha Naval - Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton novoJogoButton = new JButton("Novo Jogo");
        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNovoJogo();
            }
        });

        JButton carregarJogoButton = new JButton("Carregar Jogo");
        carregarJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarJogo();
            }
        });

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(novoJogoButton);
        panel.add(carregarJogoButton);
        panel.add(sairButton);

        add(panel);

        setVisible(true);
    }

    private void iniciarNovoJogo() {
        String jogador1 = JOptionPane.showInputDialog(this, "Nome do Jogador 1:");
        String jogador2 = JOptionPane.showInputDialog(this, "Nome do Jogador 2:");
        if (jogador1 != null && jogador2 != null && !jogador1.isEmpty() && !jogador2.isEmpty()) {
            controller.iniciarNovoJogo(jogador1, jogador2);
            dispose(); // Fecha a tela de menu
        }
    }

    private void carregarJogo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
            controller.carregarJogoExistente(caminhoArquivo);
            dispose(); // Fecha a tela de menu
        }
    }
}
