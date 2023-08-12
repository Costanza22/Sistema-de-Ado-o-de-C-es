// Função para gerar um número aleatório entre um valor mínimo e máximo
function gerarNumeroAleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
  
  // Gerar um número aleatório para a coleira do cachorro
  var numeroColeira = gerarNumeroAleatorio(100, 999);
  
  console.log(numeroColeira); // Exibe o número aleatório no console
  