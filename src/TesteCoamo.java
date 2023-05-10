import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
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


    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<>();

        Categoria categoria1 = new Categoria("Fertilizantes");
        categoria1.addProduto(new Produto("Fertilizante 1-1", 10.0, "Categoria 1"));
        categoria1.addProduto(new Produto("Fertilizante 1-2", 20.0, "Categoria 1"));
        categoria1.addProduto(new Produto("Fertilizante 1-3", 30.0, "Categoria 1"));
        categorias.add(categoria1);

        Categoria categoria2 = new Categoria("Corretivos");
        categoria2.addProduto(new Produto("Corretivo 2-1", 15.0, "Categoria 2"));
        categoria2.addProduto(new Produto("Corretivo 2-2", 25.0, "Categoria 2"));
        categoria2.addProduto(new Produto("Corretivo 2-3", 35.0, "Categoria 2"));
        categorias.add(categoria2);

        Categoria categoria3 = new Categoria("Herbicidas");
        categoria2.addProduto(new Produto("Herbicida 3-1", 15.0, "Categoria 3"));
        categoria2.addProduto(new Produto("Herbicida 3-2", 25.0, "Categoria 3"));
        categoria2.addProduto(new Produto("Herbicida 3-3", 35.0, "Categoria 3"));
        categorias.add(categoria3);

        Categoria categoria4 = new Categoria("Fungicidas");
        categoria2.addProduto(new Produto("Fungicida 4-1", 15.0, "Categoria 4"));
        categoria2.addProduto(new Produto("Fungicida 4-2", 25.0, "Categoria 4"));
        categoria2.addProduto(new Produto("Fungicida 4-3", 35.0, "Categoria 4"));
        categorias.add(categoria4);

        Categoria categoria5 = new Categoria("Inseticidas");
        categoria2.addProduto(new Produto("Inseticida 4-1", 15.0, "Categoria 5"));
        categoria2.addProduto(new Produto("Inseticida 4-2", 25.0, "Categoria 5"));
        categoria2.addProduto(new Produto("Inseticida 4-3", 35.0, "Categoria 5"));
        categorias.add(categoria5);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a categoria do produto que deseja comprar:");
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            System.out.println((i+1) + ". " + categoria.getNome());
        }

        int opcaoCategoria = scanner.nextInt();
        if (opcaoCategoria < 1 || opcaoCategoria > categorias.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Categoria categoriaSelecionada = categorias.get(opcaoCategoria-1);
        List<Produto> produtosDaCategoria = categoriaSelecionada.getProdutos();

        System.out.println("Selecione o produto que deseja comprar:");
        for (int i = 0; i < produtosDaCategoria.size(); i++) {
            Produto produto = produtosDaCategoria.get(i);
            System.out.println((i+1) + ". " + produto.getNome());
        }

        int opcaoProduto = scanner.nextInt();
        if (opcaoProduto < 1 || opcaoProduto > produtosDaCategoria.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Produto produtoSelecionado = produtosDaCategoria.get(opcaoProduto-1);

        System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
        System.out.println("Preço de venda: " + produtoSelecionado.getPrecoVenda());
    }
}
