package Adoção;
import java.util.ArrayList;
import java.util.List;

class Adocao {
    String cao;
    String adotante;
    String dataAdocao;

    Adocao(String cao, String adotante, String dataAdocao) {
        this.cao = cao;
        this.adotante = adotante;
        this.dataAdocao = dataAdocao;
    }
}

class Canil {
    List<Adocao> adocoes = new ArrayList<>();

    void cadastrarAdocao(String cao, String adotante, String dataAdocao) {
        Adocao novaAdocao = new Adocao(cao, adotante, dataAdocao);
        adocoes.add(novaAdocao);
        System.out.println("Adoção cadastrada com sucesso!");
    }

    List<Adocao> exibirAdocoes() {
        return adocoes;
    }
}

class Main {
    public static void main(String[] args) {
        Canil canil = new Canil();

        canil.cadastrarAdocao("Rex", "João", "2023-05-20");
        canil.cadastrarAdocao("Luna", "Maria", "2023-05-22");

        List<Adocao> adocoes = canil.exibirAdocoes();
        System.out.println("Adoções realizadas no canil:");
        for (Adocao adocao : adocoes) {
            System.out.println("Cão: " + adocao.cao);
            System.out.println("Adotante: " + adocao.adotante);
            System.out.println("Data de Adoção: " + adocao.dataAdocao);
            System.out.println("---------------------------");
        }
    }
}
