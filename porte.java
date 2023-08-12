import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Cao {
    String nome;
    String raca;
    String coleira;
    String racao;
    String porte;

    Cao(String nome, String raca, String coleira, String racao, String porte) {
        this.nome = nome;
        this.raca = raca;
        this.coleira = coleira;
        this.racao = racao;
        this.porte = porte;
    }
}

class Canil {
    Map<String, List<Cao>> caesPorPorte = new HashMap<>();

    void cadastrarCao(String nome, String raca, String coleira, String racao, String porte) {
        Cao novoCao = new Cao(nome, raca, coleira, racao, porte);
        if (caesPorPorte.containsKey(porte)) {
            caesPorPorte.get(porte).add(novoCao);
        } else {
            List<Cao> caes = new ArrayList<>();
            caes.add(novoCao);
            caesPorPorte.put(porte, caes);
        }
        System.out.println("Cão cadastrado com sucesso!");
    }

    List<Cao> getCaesPorPorte(String porte) {
        return caesPorPorte.getOrDefault(porte, new ArrayList<>());
    }
}

class Main {
    public static void main(String[] args) {
        Canil canil = new Canil();

        canil.cadastrarCao("Rex", "Labrador", "C123", "Ração A", "Grande");
        canil.cadastrarCao("Luna", "Golden Retriever", "G456", "Ração B", "Médio");

        List<Cao> caesGrande = canil.getCaesPorPorte("Grande");
        System.out.println("Cães de porte grande:");
        for (Cao cao : caesGrande) {
            System.out.println("Nome: " + cao.nome);
            System.out.println("Raça: " + cao.raca);
            System.out.println("Coleira: " + cao.coleira);
            System.out.println("Ração: " + cao.racao);
            System.out.println("---------------------------");
        }

        List<Cao> caesMedio = canil.getCaesPorPorte("Médio");
        System.out.println("Cães de porte médio:");
        for (Cao cao : caesMedio) {
            System.out.println("Nome: " + cao.nome);
            System.out.println("Raça: " + cao.raca);
            System.out.println("Coleira: " + cao.coleira);
            System.out.println("Ração: " + cao.racao);
            System.out.println("---------------------------");
        }
    }
}

