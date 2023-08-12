// Verifica se o adotante pode comparecer no dia da adoção
function verificarDisponibilidadeAdotante(disponibilidade) {
    if (disponibilidade) {
      console.log("Adotante disponível para adoção.");
    } else {
      console.log("Adotante não pode comparecer no dia da adoção.");
      oferecerOpcoesAlternativas();
    }
  }
  
  // Oferece opções alternativas para o adotante
  function oferecerOpcoesAlternativas() {
    console.log("Opções alternativas:");
    console.log("1. Reagendar a adoção");
    console.log("2. Opção de entrega");
    console.log("3. Adoção por procuração");
    console.log("4. Reservar o cão para adoção futura");
  }
  
  // Exemplo de uso
  var adotanteDisponivel = false;
  verificarDisponibilidadeAdotante(adotanteDisponivel);
  