//
const readline = require('readline-sync');

// Produtos disponíveis para venda
const produtos = [
    { nome: "Produto 1", preco: 10 },
    { nome: "Produto 2", preco: 20 },
    { nome: "Produto 3", preco: 30 },
    { nome: "Produto 4", preco: 40 },
    { nome: "Produto 5", preco: 50 }
  ];
  
  // Função para exibir o menu de produtos
  function exibirMenuProdutos() {
    console.log("Produtos disponíveis para venda:");
    produtos.forEach((produto, index) => {
      console.log(`${index + 1} - ${produto.nome} - R$ ${produto.preco.toFixed(2)}`);
    });
  }
  
  // Função para calcular o valor de venda do produto selecionado pelo usuário
  function calcularValorDeVendaProduto() {
    // Exibe o menu de produtos
    exibirMenuProdutos();
  
    // Lê o número do produto selecionado pelo usuário
    const numeroProduto = parseInt(readline.question('Digite o número do produto que deseja comprar: '));
  
    // Verifica se o número do produto é válido
    if (numeroProduto < 1 || numeroProduto > produtos.length) {
      console.log("Opção inválida!");
      return;
    }
  
    // Obtém o produto selecionado pelo usuário
    const produtoSelecionado = produtos[numeroProduto - 1];
  
    // Lê a quantidade de produtos que o usuário deseja comprar
    const quantidade = parseInt(readline.question(`Digite a quantidade de ${produtoSelecionado.nome} que deseja comprar:`));
  
    // Calcula o valor total da compra
    const valorTotal = produtoSelecionado.preco * quantidade;
  
    // Exibe o valor total da compra
    console.log(`Valor total da compra: R$ ${valorTotal.toFixed(2)}`);
  }
  
  // Chama a função para calcular o valor de venda do produto selecionado pelo usuário
  calcularValorDeVendaProduto();
  