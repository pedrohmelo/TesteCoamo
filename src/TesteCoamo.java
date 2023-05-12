import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class TesteCoamo {
    public static class Produto {
        private String nome;
        private double precoVenda;
        private String categoria;

        public Produto(String nome, double precoVenda, String categoria){
            this.nome = nome;
            this.precoVenda = precoVenda;
            this.categoria = categoria;
        }

        public String getNome() {
            return nome;
        }

        public double getPrecoVenda() {
            return precoVenda;
        }

        public void setPrecoVenda(double precoVenda) {
            this.precoVenda = precoVenda;
        }
    }

    public static class Categoria{
        private String nome;
        private List<Produto> produtos;

        public Categoria(String nome){
            this.nome = nome;
            this.produtos = new ArrayList<>();
        }

        public String getNome(){
            return nome;
        }

        public List<Produto> getProdutos(){
            return produtos;
        }

        public void addProduto(Produto produto){
            produtos.add(produto);
        }
    }

    public static class Carrinho{
        private Produto produto;
        private Integer quantidade;
        private double valorPorProduto;

        public double getValorPorProduto() {
            return valorPorProduto;
        }

        public void setValorPorProduto(double valorPorProduto) {
            this.valorPorProduto = valorPorProduto;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }

        public Carrinho(Produto produto, Integer quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.valorPorProduto = produto.getPrecoVenda() * quantidade;
        }
    }

    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<>();
        List<Carrinho> carrinho = new ArrayList<>();
        List<Boolean> categoriasSelecionadas = Arrays.asList(false, false, false, false, false);

        int totalCategorias = 0;

        Categoria categoria1 = new Categoria("Fertilizantes");
        categoria1.addProduto(new Produto("Fertilizante A", 10.0, "Categoria 1"));
        categoria1.addProduto(new Produto("Fertilizante B", 20.0, "Categoria 1"));
        categoria1.addProduto(new Produto("Fertilizante C", 30.0, "Categoria 1"));
        categorias.add(categoria1);

        Categoria categoria2 = new Categoria("Corretivos");
        categoria2.addProduto(new Produto("Corretivo A", 15.0, "Categoria 2"));
        categoria2.addProduto(new Produto("Corretivo B", 25.0, "Categoria 2"));
        categoria2.addProduto(new Produto("Corretivo C", 35.0, "Categoria 2"));
        categorias.add(categoria2);

        Categoria categoria3 = new Categoria("Herbicidas");
        categoria3.addProduto(new Produto("Herbicida A", 15.0, "Categoria 3"));
        categoria3.addProduto(new Produto("Herbicida B", 25.0, "Categoria 3"));
        categoria3.addProduto(new Produto("Herbicida C", 35.0, "Categoria 3"));
        categorias.add(categoria3);

        Categoria categoria4 = new Categoria("Fungicidas");
        categoria4.addProduto(new Produto("Fungicida A", 15.0, "Categoria 4"));
        categoria4.addProduto(new Produto("Fungicida B", 25.0, "Categoria 4"));
        categoria4.addProduto(new Produto("Fungicida C", 35.0, "Categoria 4"));
        categorias.add(categoria4);

        Categoria categoria5 = new Categoria("Inseticidas");
        categoria5.addProduto(new Produto("Inseticida A", 15.0, "Categoria 5"));
        categoria5.addProduto(new Produto("Inseticida B", 25.0, "Categoria 5"));
        categoria5.addProduto(new Produto("Inseticida C", 35.0, "Categoria 5"));
        categorias.add(categoria5);

        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        while(opcao == 1) {
            System.out.println("Selecione a categoria do produto que deseja comprar:");
            for (int i = 0; i < categorias.size(); i++){
                Categoria categoria = categorias.get(i);
                System.out.println((i + 1) + ". " + categoria.getNome());
            }

            int opcaoCategoria = scanner.nextInt();
            if (opcaoCategoria < 1 || opcaoCategoria > categorias.size()){
                System.out.println("Opção inválida!");
                return;
            }

            Categoria categoriaSelecionada = categorias.get(opcaoCategoria - 1);
            List<Produto> produtosDaCategoria = categoriaSelecionada.getProdutos();

            System.out.println("Selecione o produto que deseja comprar:");
            for (int i = 0; i < produtosDaCategoria.size(); i++) {
                Produto produto = produtosDaCategoria.get(i);
                System.out.println((i + 1) + ". " + produto.getNome());
            }

            int opcaoProduto = scanner.nextInt();
            if (opcaoProduto < 1 || opcaoProduto > produtosDaCategoria.size()){
                System.out.println("Opção inválida!");
                return;
            }

            Produto produtoSelecionado = produtosDaCategoria.get(opcaoProduto - 1);

            System.out.println("Insira a quantidade do produto a comprar: ");

            int quantidade = scanner.nextInt();
            //inserindo o produto/quantidade na lista carrinho
            carrinho.add(new Carrinho(produtoSelecionado, quantidade));
            //a negação é para não repetir a inserção da mesma categoria novamente.
            if(!categoriasSelecionadas.get(opcaoCategoria-1)){
                categoriasSelecionadas.set(opcaoCategoria-1, true);
                totalCategorias++; //AQUI É FEITA A CONTAGEM!!!!!!!!!
            }

            for(int i = 0; i < carrinho.size(); i++ ) {
                System.out.println("Nome do produto: " + carrinho.get(i).getProduto().getNome());
                System.out.println("Quantidade: " + carrinho.get(i).getQuantidade());
                System.out.println("Valor dos produtos: R$ " + carrinho.get(i).getValorPorProduto());
            }

            System.out.println("""
                    Deseja comprar outro produto?
                    1 - Sim
                    2 - Não
                    """);
            opcao = scanner.nextInt();
        }

        double valorTotal = 0;
        double valorPorProduto = 0;
        for(Carrinho c : carrinho){
            valorTotal += c.getValorPorProduto();
            System.out.println("Nome do Produto: " + c.getProduto().getNome());
            System.out.println("Quantidade: " + c.getQuantidade());
            System.out.println("Valor do Produto: R$ " + c.getValorPorProduto());
        }
        System.out.println("Valor total: " + valorTotal);

        double valorDesconto = 0;
        double valorDescontoCategorias = 0;
        
        System.out.println("""
                Insira o método de pagamento: 
                1. À vista
                2. A prazo
                """);
        int formaPagamento = scanner.nextInt();
        if(formaPagamento == 1){
            System.out.println("""
                    Insira o seu conceito para prosseguir com a compra:
                    1. (A) - Excelente
                    2. (B) - Bom
                    3. (C) - Básico
                    """);

            int conceito = scanner.nextInt();
            double desconto = 0;

            if(conceito == 1){
                desconto = 0.05;
            } else if(conceito == 2){
                desconto = 0.03;
            }

            if(totalCategorias == 1){
                valorDescontoCategorias = 0.01;
            } else if(totalCategorias == 2){
                valorDescontoCategorias = 0.02;
            } else if(totalCategorias == 3){
                valorDescontoCategorias = 0.03;
            } else if(totalCategorias == 4){
                valorDescontoCategorias = 0.04;
            } else if(totalCategorias == 5){
                valorDescontoCategorias = 0.05;
            }
            
            valorDesconto = valorTotal - (valorTotal*(desconto + valorDescontoCategorias));
            System.out.println("Valor com desconto à vista: R$ " + valorDesconto);
            //System.out.println("QUANTIDADE DE CATEGORIAS DA COMPRA: " + totalCategorias);
        } else{
            System.out.println("""
                    Insira o seu conceito para prosseguir com a compra:
                    1. (A) - Excelente
                    2. (B) - Bom
                    3. (C) - Básico
                    """);
            int conceito = scanner.nextInt();
            System.out.println("Insira o número de dias a parcelar: ");
            int numDias = scanner.nextInt();
            double desconto = 0;
            double valorJuros = 0;
            double valorFinal = 0;

            if(conceito == 1){
                desconto = 0.05;
            } else if(conceito == 2){
                desconto = 0.03;
            }

            if(totalCategorias == 1){
                valorDescontoCategorias = 0.01;
            } else if(totalCategorias == 2){
                valorDescontoCategorias = 0.02;
            } else if(totalCategorias == 3){
                valorDescontoCategorias = 0.03;
            } else if(totalCategorias == 4){
                valorDescontoCategorias = 0.04;
            } else if(totalCategorias == 5){
                valorDescontoCategorias = 0.05;
            }

            valorDesconto = valorTotal - (valorTotal*(desconto + valorDescontoCategorias));

            valorJuros = valorTotal * ((Math.pow((1 + (0.12/100)), numDias)) - 1);
            valorFinal = valorDesconto + valorJuros;
            System.out.println("Juros: R$ " + valorJuros + " ao mês");
            System.out.println("Valor com desconto a prazo: R$ " + valorDesconto);
            System.out.println("Valor com desconto a prazo após juros aplicados: R$ " + valorFinal);
            //System.out.println("QUANTIDADE DE CATEGORIAS DA COMPRA: " + totalCategorias);
        }
    }
}