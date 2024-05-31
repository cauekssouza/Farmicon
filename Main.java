import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Farmicon ----");

        // Exemplo de uso das classes do projeto Farmicon
        // Criando farmácias e medicamentos
        Farmacia farmacia1 = new Farmacia("Pague Menos", "Av. do Batel, 1340 - Batel, Curitiba", "07:00 - 22:00");
        farmacia1.adicionarMedicamento(new Medicamento("Paracetamol", 10.50, farmacia1, "Corredor A"));
        farmacia1.adicionarMedicamento(new Medicamento("Dipirona", 5.75, farmacia1, "Corredor B"));

        Farmacia farmacia2 = new Farmacia("Panvel", " R. Benjamin Lins, 680 - Loja 01 - Batel, Curitiba", "24:00 ");
        farmacia2.adicionarMedicamento(new Medicamento("Paracetamol", 11.00, farmacia2, "Corredor C"));
        farmacia2.adicionarMedicamento(new Medicamento("Dipirona", 6.00, farmacia2, "Corredor D"));

        // Exibindo informações da farmácia e seus medicamentos
        exibirInformacoesFarmacia(farmacia1);
        exibirInformacoesFarmacia(farmacia2);

        // Exemplo de cliente
        Cliente cliente1 = new ClienteConcreto("João", "Av. Principal, 456", "(41) 99999-9999", "123.456.789-00",
                "Receita XYZ", 1);
        // Realizando operações de cliente (exemplo)
        cliente1.realizarCompra();
        cliente1.compararPreco();

        // Exemplo de avaliação
        Avaliação avaliação = new Avaliação("Maria", farmacia1, "Ótimo atendimento!", 5);
        exibirAvaliacao(avaliação);

        // Menu de interação
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    buscarFarmacia(scanner);
                    break;
                case 2:
                    compararPrecos(farmacia1, farmacia2);
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Buscar Farmácia");
        System.out.println("2. Comparar Preços");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void buscarFarmacia(Scanner scanner) {
        System.out.print("Digite o nome da farmácia: ");
        String nomeFarmacia = scanner.nextLine();

        // Buscar a farmácia pelo nome
        Farmacia farmaciaEncontrada = buscarFarmaciaPorNome(nomeFarmacia);
        if (farmaciaEncontrada != null) {
            exibirInformacoesFarmacia(farmaciaEncontrada);
        } else {
            System.out.println("Farmácia não encontrada: " + nomeFarmacia);
        }
    }

    private static Farmacia buscarFarmaciaPorNome(String nomeFarmacia) {
        // Simulação de busca de farmácia pelo nome (pode ser implementado com uma lista
        // de farmácias)
        // Aqui estamos simulando com as duas farmácias criadas no main
        Map<String, Farmacia> farmacias = new HashMap<>();
        farmacias.put("Pague Menos",
                new Farmacia("Pague Menos", "Av. do Batel, 1340 - Batel, Curitiba", "07:00 - 22:00"));
        farmacias.put("Panvel", new Farmacia("Panvel", "R. Benjamin Lins, 680 - Loja 01 - Batel, Curitiba", "24:00"));
        return farmacias.get(nomeFarmacia);
    }

    private static void compararPrecos(Farmacia farmacia1, Farmacia farmacia2) {
        System.out.println("--- Comparação de Preços ---");
        System.out.println("Farmácia 1: " + farmacia1.getNome());
        System.out.println("Farmácia 2: " + farmacia2.getNome());

        // Comparação de preços para medicamentos em ambas as farmácias
        for (Medicamento medicamento1 : farmacia1.getListaMedicamentos()) {
            for (Medicamento medicamento2 : farmacia2.getListaMedicamentos()) {
                if (medicamento1.getNome().equals(medicamento2.getNome())) {
                    System.out.println("Medicamento: " + medicamento1.getNome());
                    System.out.println("Preço " + farmacia1.getNome() + ": R$" + medicamento1.getPreco());
                    System.out.println("Preço " + farmacia2.getNome() + ": R$" + medicamento2.getPreco());
                    System.out.println("Diferença de preço: R$" + (medicamento1.getPreco() - medicamento2.getPreco()));
                }
            }
        }
    }

    private static void exibirInformacoesFarmacia(Farmacia farmacia) {
        System.out.println("\nFarmácia: " + farmacia.getNome());
        System.out.println("Endereço: " + farmacia.getEndereco());
        System.out.println("Horário de Funcionamento: " + farmacia.getHorarioFuncionamento());
        System.out.println("Medicamentos:");
        for (Medicamento medicamento : farmacia.getListaMedicamentos()) {
            System.out.println("- Nome: " + medicamento.getNome());
            System.out.println("  Preço: R$" + medicamento.getPreco());
            System.out.println("  Localização: " + medicamento.getLocalizacao());
        }
    }

    private static void exibirAvaliacao(Avaliação avaliação) {
        System.out.println(
                "\nAvaliação de " + avaliação.getUsuario() + " para " + avaliação.getFarmacia().getNome() + ":");
        System.out.println("Comentário: " + avaliação.getComentario());
        System.out.println("Nota: " + avaliação.getNota());
    }
}
