package Ração;
import java.util.ArrayList;
import java.util.List;

class Racao {
    String nome;
    String marca;
    String descricao;
    double preco;

    Racao(String nome, String marca, String descricao, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
        this.preco = preco;
    }
}

class CadastroCaesCanil {
    public static void main(String[] args) {
        List<Racao> racoes = new ArrayList<>();

        cadastrarRacao(racoes, "Ração Pedigree", "Pedigree Adulto", "Ração completa e balanceada para cães adultos", 29.90);
        cadastrarRacao(racoes, "Ração Royal Canin", "Royal Canin Medium Junior", "Ração específica para cães filhotes de porte médio", 49.90);

        exibirRacoes(racoes);
    }

    static void cadastrarRacao(List<Racao> racoes, String nome, String marca, String descricao, double preco) {
        Racao novaRacao = new Racao(nome, marca, descricao, preco);
        racoes.add(novaRacao);
        System.out.println("Ração cadastrada com sucesso!");
    }

    static void exibirRacoes(List<Racao> racoes) {
        System.out.println("Rações disponíveis:");
        for (Racao racao : racoes) {
            System.out.println("Nome: " + racao.nome);
            System.out.println("Marca: " + racao.marca);
            System.out.println("Descrição: " + racao.descricao);
            System.out.println("Preço: R$" + racao.preco);
            System.out.println("---------------------------");
        }
    }
}

