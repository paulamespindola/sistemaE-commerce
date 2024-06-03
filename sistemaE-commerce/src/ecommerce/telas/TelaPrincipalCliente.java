package ecommerce.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ecommerce.pessoas.Cliente;
import ecommerce.estoque.Produto;
import ecommerce.interacao.Interface;

public class TelaPrincipalCliente extends JFrame {
    private TelaPrincipal telaPrincipal;
    private Interface interacao;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JTextField nomeField;
    private JTextField enderecoField;

    public TelaPrincipalCliente(TelaPrincipal telaPrincipal, Interface interacao) {
        this.telaPrincipal = telaPrincipal;
        this.interacao = interacao;
        setTitle("Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 1));

        JLabel tituloLabel = new JLabel("Cliente", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pane.add(tituloLabel);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });
        pane.add(loginButton);

        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCadastroDialog();
            }
        });
        pane.add(cadastroButton);

        JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCompraDialog();
            }
        });
        pane.add(comprarButton);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaPrincipal.setVisible(true);
                setVisible(false);
            }
        });
        pane.add(voltarButton);
    }

    private void showLoginDialog() {
        JDialog dialog = new JDialog(this, "Login Cliente", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(3, 2));

        dialog.add(new JLabel("Email:"));
        emailField = new JTextField();
        dialog.add(emailField);

        dialog.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        dialog.add(senhaField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                if (interacao.loginCliente(email, senha)) {
                    JOptionPane.showMessageDialog(dialog, "Login bem-sucedido!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Email ou senha incorretos.");
                }
            }
        });
        dialog.add(loginButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(cancelarButton);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showCadastroDialog() {
        JDialog dialog = new JDialog(this, "Cadastro Cliente", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(5, 2));

        dialog.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        dialog.add(nomeField);

        dialog.add(new JLabel("Email:"));
        emailField = new JTextField();
        dialog.add(emailField);

        dialog.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        dialog.add(senhaField);

        dialog.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        dialog.add(enderecoField);

        JButton cadastroButton = new JButton("Cadastrar");
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                String endereco = enderecoField.getText();
                Cliente novoCliente = new Cliente(nome, email, senha, endereco);
                interacao.adicionarCliente(novoCliente);
                JOptionPane.showMessageDialog(dialog, "Cadastro bem-sucedido!");
                dialog.dispose();
            }
        });
        dialog.add(cadastroButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(cancelarButton);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showCompraDialog() {
        if (!interacao.isLoginClienteFeito()) {
            JOptionPane.showMessageDialog(this, "Por favor, faça login primeiro.");
            return;
        }

        JDialog dialog = new JDialog(this, "Comprar Produtos", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        JLabel instrucoesLabel = new JLabel("Escolha um produto e a quantidade para adicionar ao carrinho:");
        dialog.add(instrucoesLabel, BorderLayout.NORTH);

        JPanel produtosPanel = new JPanel();
        produtosPanel.setLayout(new GridLayout(0, 1));

        for (Produto produto : interacao.getEstoque().getProdutosEmEstoque()) {
            JPanel produtoPanel = new JPanel();
            produtoPanel.setLayout(new FlowLayout());

            JLabel produtoLabel = new JLabel(produto.getNome() + " - R$" + produto.getValor());
            produtoPanel.add(produtoLabel);

            JTextField quantidadeField = new JTextField(5);
            produtoPanel.add(quantidadeField);

            JButton adicionarButton = new JButton("Adicionar");
            adicionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int quantidade = Integer.parseInt(quantidadeField.getText());
                        interacao.adicionarNoCarrinho(produto, quantidade);
                        JOptionPane.showMessageDialog(dialog, "Produto adicionado ao carrinho!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(dialog, "Quantidade inválida.");
                    }
                }
            });
            produtoPanel.add(adicionarButton);

            produtosPanel.add(produtoPanel);
        }

        JScrollPane scrollPane = new JScrollPane(produtosPanel);
        dialog.add(scrollPane, BorderLayout.CENTER);

        JButton finalizarButton = new JButton("Finalizar Compra");
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de finalização da compra
                JOptionPane.showMessageDialog(dialog, "Compra finalizada!");
                dialog.dispose();
            }
        });
        dialog.add(finalizarButton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
