package Ração;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Cao {
    String nome;
    String raca;
    String coleira;
    String racao;

    Cao(String nome, String raca, String coleira, String racao) {
        this.nome = nome;
        this.raca = raca;
        this.coleira = coleira;
        this.racao = racao;
    }
}

class CadastroCaesCanil {
    public static void main(String[] args) {
        List<Cao> caes = new ArrayList<>();
        Map<String, String> racoes = new HashMap<>();

        // Exemplo de uso
        cadastrarRacao(racoes, "Ração A", "Ração premium para cães de grande porte");
        cadastrarRacao(racoes, "Ração B", "Ração especial para cães com sensibilidade alimentar");

        cadastrarCao(caes, "Rex", "Labrador", "C123", "Ração A");
        cadastrarCao(caes, "Luna", "Golden Retriever", "G456", "Ração B");

        exibirCaes(caes);
        exibirRacoes(racoes);
    }

    static void cadastrarCao(List<Cao> caes, String nome, String raca, String coleira, String racao) {
        Cao novoCao = new Cao(nome, raca, coleira, racao);
        caes.add(novoCao);
        System.out.println("Cão cadastrado com sucesso!");
    }

    static void cadastrarRacao(Map<String, String> racoes, String racao, String descricao) {
        racoes.put(racao, descricao);
        System.out.println("Ração cadastrada com sucesso!");
    }

    static void exibirCaes(List<Cao> caes) {
        System.out.println("Cães cadastrados no canil:");
        for (Cao cao : caes) {
            System.out.println("Nome: " + cao.nome);
            System.out.println("Raça: " + cao.raca);
            System.out.println("Coleira: " + cao.coleira);
            System.out.println("Ração: " + cao.racao);
            System.out.println("---------------------------");
        }
    }

    static void exibirRacoes(Map<String, String> racoes) {
        System.out.println("Rações cadastradas:");
        for (Map.Entry<String, String> entry : racoes.entrySet()) {
            String racao = entry.getKey();
            String descricao = entry.getValue();
            System.out.println("Ração: " + racao);
            System.out.println("Descrição: " + descricao);
            System.out.println("---------------------------");
        }
    }
}
