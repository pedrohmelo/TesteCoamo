import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prototipo1 {
    public static void main(String[] args) {

        int perfil = 0;

        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Fertilizantes", 10.0));
        produtos.add(new Produto("Corretivos", 20.0));
        produtos.add(new Produto("Herbicidas", 30.0));
        produtos.add(new Produto("Fungicida", 40));
        produtos.add(new Produto("Inseticida", 10));

        System.out.println("Qual seu perfil? \n1 - Pessoa Física\n2 - Pessoa Jurídica");
        Scanner scannerPerfil = new Scanner(System.in);
        perfil = scannerPerfil.nextInt();

        System.out.println("Selecione o produto que deseja comprar:");
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println((i+1) + ". " + produto.getNome());
        }

        Scanner scannerProduto = new Scanner(System.in);

        int opcao = scannerProduto.nextInt();
        if (opcao < 1 || opcao > produtos.size()) {
            System.out.println("Opção inválida!");
            return;
        }
        System.out.println("Insira a quantidade de unidades do produto: ");
        Scanner scannerQuantidade = new Scanner(System.in);
        int quantidade = scannerQuantidade.nextInt();
        if(quantidade == 0){
            System.out.println("Quantidade inválida!");
        } else{
            Produto produtoSelecionado = produtos.get(opcao-1);
            double valorSemDesc = (produtoSelecionado.getPrecoVenda()*quantidade);
            System.out.println("O preço de venda sem descontos de " + produtoSelecionado.getNome() + " é " + valorSemDesc);
            System.out.println("Informe sua categoria: \n1 - A\n2 - B\n3 - C");
            Scanner scannerCategoria = new Scanner(System.in);
            int categoria = scannerCategoria.nextInt();
            if(categoria == 1){
                double descontoPorCategoria = valorSemDesc * (0.05);
                System.out.println("Valor do desconto: " + descontoPorCategoria);
            } else if(categoria == 2){
                double descontoPorCategoria = valorSemDesc * (0.03);
                System.out.println("Valor do desconto: " + descontoPorCategoria);
            }
        }
    }

    static class Produto {
        private String nome;
        private double precoVenda;

        public Produto(String nome, double precoVenda) {
            this.nome = nome;
            this.precoVenda = precoVenda;
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
}
