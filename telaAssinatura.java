package boundary;

import controller.AssinaturaController;
import java.util.Scanner;

public class TelaAssinatura {

    private Scanner scanner = new Scanner(System.in);
    private AssinaturaController controller = new AssinaturaController();

    public void iniciar() {
        System.out.println("=== Sistema de Assinatura ===");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu celular: ");
        String celular = scanner.nextLine();

        if (!controller.validarCelular(celular)) {
            System.out.println("Celular inválido.");
            return;
        }

        System.out.println("Selecione um plano:");
        System.out.println("1 - Básico");
        System.out.println("2 - Premium");
        int opcaoPlano = scanner.nextInt();
        scanner.nextLine();

        String plano = opcaoPlano == 1 ? "Básico" : "Premium";
        controller.selecionarPlano(plano);

        System.out.print("Digite o produto desejado: ");
        String produto = scanner.nextLine();
        controller.escolherProduto(produto);

        System.out.print("Digite seu endereço: ");
        String endereco = scanner.nextLine();
        controller.informarEndereco(endereco);

        System.out.print("Digite o número do cartão: ");
        String cartao = scanner.nextLine();

        boolean pagamentoAprovado = controller.realizarPagamento(cartao);

        if (pagamentoAprovado) {
            controller.confirmarAssinatura(nome, celular);
            System.out.println("Assinatura confirmada com sucesso!");
        } else {
            System.out.println("Pagamento recusado.");
        }
    }
}