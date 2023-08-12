package Transporte;
import java.util.ArrayList;
import java.util.List;


class Transporte {
    String cao;
    String destino;
    String dataEntrega;

    Transporte(String cao, String destino, String dataEntrega) {
        this.cao = cao;
        this.destino = destino;
        this.dataEntrega = dataEntrega;
    }
}

class Canil {
    List<Transporte> transportes = new ArrayList<>();

    void cadastrarTransporte(String cao, String destino, String dataEntrega) {
        Transporte novoTransporte = new Transporte(cao, destino, dataEntrega);
        transportes.add(novoTransporte);
        System.out.println("Transporte cadastrado com sucesso!");
    }

    List<Transporte> exibirTransportes() {
        return transportes;
    }
}

class Main {
    public static void main(String[] args) {
        Canil canil = new Canil();

        canil.cadastrarTransporte("Rex", "Casa Nova", "2023-05-20");
        canil.cadastrarTransporte("Luna", "Parque", "2023-05-22");

        List<Transporte> transportes = canil.exibirTransportes();
        System.out.println("Transportes cadastrados no canil:");
        for (Transporte transporte : transportes) {
            System.out.println("Cão: " + transporte.cao);
            System.out.println("Destino: " + transporte.destino);
            System.out.println("Data de Entrega: " + transporte.dataEntrega);
            System.out.println("---------------------------");
        }
    }
}

