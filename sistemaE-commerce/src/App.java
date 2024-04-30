public class App {
    public static void main(String[] args) throws Exception {
        // Criar uma instância da classe Estoque
        Estoque estoque = new Estoque();

        // Criar os produtos
        Produto produto1 = new Produto("Geladeira Brastemp Frost Free", 0001, "Eletrodomésticos", 2850.85, "A Geladeira Brastemp Frost Free Duplex 375 litros tem design sofisticado e grande capacidade para armazenar os alimentos. Pelo Painel Eletrônico você acessa funções como Turbo Freezer, Festa, Compras e Férias. Com o Espaço Adapt, você conta com prateleiras ajustáveis para armazenar itens de diversos tamanhos. Além disso possui a Tecnologia EVOX.\nDetalhes: 375 litros cor Inox com Espaço Adapt - BRM45JK • 110V");
        
        Produto produto2 = new Produto("Fogão Consul 4 bocas cor Inox com mesa\n de vidro e grade de ferro fundido", 0002, "Eletrodomésticos", 1400.95, "Além de deixar sua cozinha moderna, o fogão consul cfo4var foi desenvolvido para trazer mais praticidade na hora de limpar seu fogão. Sua mesa de vidro, permite que a limpeza seja feita com menos esforço e menos tempo, além de agregar um design elegante ao ambiente com um formato que se assemelha aos práticos e modernos cooktops. Conta com quatro queimadores, grades robustas de ferro fundido e quatro queimadores que aceleram o tempo de cozimentos dos alimentos. Seu forno é amplo, possui tecnologia cleartec que impede o acúmulo de gordura em seu interior e duas prateleiras, uma autodeslizante e outra com duas opções de regulagem de altura, facilitando o uso do seu fogão.");
        
        Produto produto3 = new Produto("Sofá 3 lugares MUY", 0003, "Móveis", 1799.00, "Perfeita para relaxar em frente à TV do home cinema ou na roda de bate papo com amigos e familiares na sala de estar, a linha Muy possui desenho livre de excessos e ótima relação custo x benefício.Seus itens são confeccionados em madeira maciça de reflorestamento Eucalipto, percintas elásticas e espuma D26; matérias-primas que garantem a resistência, durabilidade e o conforto ideais para o dia a dia.Disponível em uma cartela de cores variadas, este sofá é a escolha certa para compor ambientes com medidas compactas. E para deixar seu décor ainda mais aconchegante e cheio de personalidade, combine-o com uma manta e almofadas de sua preferência, e arrase nesta escolha.*Importante: Produto de grandes dimensões; verifique as larguras das portas e passagens, bem como o tamanho do elevador.\nObservação: Medida total da frente do assento: 1,63 m. Os pés são fornecidos desmontados; vide manual de montagem");
        
        Produto produto4 = new Produto("Cama Box Colchão + Base Attractive Casal\n - Umaflex", 0004, "Móveis", 999.90, "Colchão Casal Umaflex de Mola Ensacada\r\n" + //
                        "Durma tranquilamente e tenha um descanso necessário para ser produtivo \nno dia seguinte com o Colchão de Casal Duomo da Umaflex. Possui molas ensacadas\nindividualmente e pré-comprimidas, fabricadas com fio de aço de alto teor de carbono.\nPor trabalharem independentemente e terem mais molas por m², elas comprimem de acordo\ncom a pressão exercida pelo corpo, proporcionando uma firmeza anatômica perfeita.\nConta também com um pillow top, trazendo a maciez, suavidade e conforto necessário\nque o corpo precisa.Com densidade D26, suporta até 120kg por pessoa e é ideal\npara cama box. Suas medidas são 138x25x188cm.");

        // Adicionar os produtos ao estoque
        estoque.adicionarProduto(produto1, 10);
        estoque.adicionarProduto(produto2, 15);
        estoque.adicionarProduto(produto3, 20);
        estoque.adicionarProduto(produto4, 0);

        Cliente p1 = new Cliente("Julia", 122222222, 81888888, "llll", 01);

        p1.adicionarProduto(produto4, 1);
        p1.adicionarProduto(produto1, 4);
        p1.exibirCarrinho();
        
     //  produto4.exibirProduto();
      // estoque.listarProduto();

       //teste interface
       //Interface telas = new Interface();

       //telas.telaPrincipal();
    
    }
}
