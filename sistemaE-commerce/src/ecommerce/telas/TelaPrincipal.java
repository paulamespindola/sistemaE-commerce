package ecommerce.telas; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ecommerce.estoque.Estoque;
import ecommerce.interacao.Interface;

public class TelaPrincipal extends JFrame {
    private Interface interacao;

    public TelaPrincipal(Interface interacao) {
        this.interacao = interacao;
        setTitle("E-commerce");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, 1));

        JLabel tituloLabel = new JLabel("E-commerce", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pane.add(tituloLabel);

        JButton clienteButton = new JButton("Cliente");
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaPrincipalCliente(TelaPrincipal.this, interacao).setVisible(true);
                setVisible(false);
            }
        });
        pane.add(clienteButton);

        JButton adminButton = new JButton("Administrador");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLoginAdm(TelaPrincipal.this, interacao).setVisible(true);
                setVisible(false);
            }
        });
        pane.add(adminButton);
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque(); // Inicialize seu estoque conforme necessário
        Interface interacao = new Interface(estoque);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaPrincipal ex = new TelaPrincipal(interacao);
                ex.setVisible(true);
            }
        });
    }
}
