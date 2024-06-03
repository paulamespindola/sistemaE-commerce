package ecommerce.telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ecommerce.estoque.Produto;
import ecommerce.interacao.Interface;

public class TelaLoginAdm extends JFrame {
    private TelaPrincipal telaPrincipal;
    private Interface interacao;
    private JTextField nomeProdutoField;
    private JTextField precoProdutoField;
    private JTextField quantidadeProdutoField;
    private JTextField nomeProdutoUpdateField;
    private JTextField precoProdutoUpdateField;
    private JTextField quantidadeProdutoUpdateField;
    private JComboBox<String> produtosComboBox;

    public TelaLoginAdm(TelaPrincipal telaPrincipal, Interface interacao) {
        this.telaPrincipal = telaPrincipal;
        this.interacao = interacao;
        setTitle("Administrador");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 1));

        JLabel tituloLabel = new JLabel("Administrador", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pane.add(tituloLabel);

        JButton adicionarProdutoButton = new JButton("Adicionar Produto");
        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdicionarProdutoDialog();
            }
        });
        pane.add(adicionarProdutoButton);

        JButton removerProdutoButton = new JButton("Remover Produto");
        removerProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRemoverProdutoDialog();
            }
        });
        pane.add(removerProdutoButton);

        JButton atualizarProdutoButton = new JButton("Atualizar Produto");
        atualizarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAtualizarProdutoDialog();
            }
        });
        pane.add(atualizarProdutoButton);

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

    private void showAdicionarProdutoDialog() {
        JDialog dialog = new JDialog(this, "Adicionar Produto", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(4, 2));

        dialog.add(new JLabel("Nome:"));
        nomeProdutoField = new JTextField();
        dialog.add(nomeProdutoField);

        dialog.add(new JLabel("Preço:"));
        precoProdutoField = new JTextField();
        dialog.add(precoProdutoField);

        dialog.add(new JLabel("Quantidade:"));
        quantidadeProdutoField = new JTextField();
        dialog.add(quantidadeProdutoField);


        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeProdutoField.getText();
                double preco = Double.parseDouble(precoProdutoField.getText());
                int quantidade = Integer.parseInt(quantidadeProdutoField.getText());
                // falta completar as informações sobre o produto.
               // Produto novoProduto = new Produto(nome, codigo,  preco, quantidade);
               // interacao.adicionarProdutoEstoque(novoProduto, quantidade);
                JOptionPane.showMessageDialog(dialog, "Produto adicionado com sucesso!");
                dialog.dispose();
            }
        });
        dialog.add(adicionarButton);

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

    private void showRemoverProdutoDialog() {
        JDialog dialog = new JDialog(this, "Remover Produto", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(2, 2));

        dialog.add(new JLabel("Produto:"));
        produtosComboBox = new JComboBox<>();
        for (Produto produto : interacao.getEstoque().getProdutos()) {
            produtosComboBox.addItem(produto.getNome());
        }
        dialog.add(produtosComboBox);

        JButton removerButton = new JButton("Remover");
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = (String) produtosComboBox.getSelectedItem();
                Produto produtoRemover = interacao.buscarProduto(nomeProduto);
                if (produtoRemover != null) {
                    interacao.removerProdutoEstoque(produtoRemover);
                    JOptionPane.showMessageDialog(dialog, "Produto removido com sucesso!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Produto não encontrado.");
                }
            }
        });
        dialog.add(removerButton);

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

    private void showAtualizarProdutoDialog() {
        JDialog dialog = new JDialog(this, "Atualizar Produto", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(4, 2));

        dialog.add(new JLabel("Produto:"));
        produtosComboBox = new JComboBox<>();
        for (Produto produto : interacao.getEstoque().getProdutos()) {
            produtosComboBox.addItem(produto.getNome());
        }
        produtosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produtoSelecionado = interacao.buscarProduto((String) produtosComboBox.getSelectedItem());
                if (produtoSelecionado != null) {
                    nomeProdutoUpdateField.setText(produtoSelecionado.getNome());
                    precoProdutoUpdateField.setText(String.valueOf(produtoSelecionado.getValor()));
                    quantidadeProdutoUpdateField.setText(String.valueOf(produtoSelecionado.getQuantidadeEstoque()));
                }
            }
        });
        dialog.add(produtosComboBox);

        dialog.add(new JLabel("Novo Nome:"));
        nomeProdutoUpdateField = new JTextField();
        dialog.add(nomeProdutoUpdateField);

        dialog.add(new JLabel("Novo Preço:"));
        precoProdutoUpdateField = new JTextField();
        dialog.add(precoProdutoUpdateField);

        dialog.add(new JLabel("Nova Quantidade:"));
        quantidadeProdutoUpdateField = new JTextField();
        dialog.add(quantidadeProdutoUpdateField);

        JButton atualizarButton = new JButton("Atualizar");
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeAntigo = (String) produtosComboBox.getSelectedItem();
                Produto produtoAtualizar = interacao.buscarProduto(nomeAntigo);
                if (produtoAtualizar != null) {
                    String novoNome = nomeProdutoUpdateField.getText();
                    double novoPreco = Double.parseDouble(precoProdutoUpdateField.getText());
                    int novaQuantidade = Integer.parseInt(quantidadeProdutoUpdateField.getText());
                    interacao.atualizarProdutoEstoque(produtoAtualizar, novoNome, novoPreco, novaQuantidade);
                    JOptionPane.showMessageDialog(dialog, "Produto atualizado com sucesso!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Produto não encontrado.");
                }
            }
        });
        dialog.add(atualizarButton);

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
}
