package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.GameController;

public class TelaInicio extends JFrame {
    private JTextField jogador1Field;
    private JTextField jogador2Field;
    private GameController controller;

    public TelaInicio(GameController controller) {
        this.controller = controller;
        setTitle("Batalha Naval - Tela Inicial");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel jogador1Label = new JLabel("Nome do Jogador 1:");
        jogador1Field = new JTextField(15);
        JLabel jogador2Label = new JLabel("Nome do Jogador 2:");
        jogador2Field = new JTextField(15);
        JButton iniciarButton = new JButton("Iniciar Jogo");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(jogador1Label, gbc);

        gbc.gridx = 1;
        panel.add(jogador1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(jogador2Label, gbc);

        gbc.gridx = 1;
        panel.add(jogador2Field, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(iniciarButton, gbc);

        add(panel);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1 = jogador1Field.getText().trim();
                String jogador2 = jogador2Field.getText().trim();
                if (jogador1.isEmpty() || jogador2.isEmpty()) {
                    JOptionPane.showMessageDialog(TelaInicio.this, "Por favor, insira os nomes dos jogadores.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    controller.iniciarNovoJogo(jogador1, jogador2);
                    dispose();
                }
            }
        });
    }
}
