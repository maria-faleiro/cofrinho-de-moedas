
import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private Cofrinho cofrinho;

    public Menu() { // vai pegar as opções do usuario
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    // metodo vai exibir o menu principal
    public void exibirMenuPrincipal() {
        System.out.println(" $$$ COFRINHO $$$ :");
        System.out.println("1- Adicionar Moeda:");
        System.out.println("2- Remover Moeda:");
        System.out.println("3- Listar Moedas");
        System.out.println("4- Calcular Valor Total Convertido Para Real:");
        System.out.println("0- Encerrar Programa:");

        String opcaoExcolhida = sc.next(); // vai permitir que o usuario escolha uma opção e armazena em uma variavel

        switch (opcaoExcolhida) {
            case "0":
                System.out.println("Programa Encerrado!");
                break;

            case "1":
                exibirSubMenuAdicionarMoedas();
                exibirMenuPrincipal();
                break;

            case "2":
                exibirSubMenuRemoverMoedas();
                exibirMenuPrincipal();
                break;

            case "3":
                cofrinho.listaMoedas();
                exibirMenuPrincipal();
                break;

            case "4":
                double valorTotalConvertido = cofrinho.totalConvertido();
                String valorTotalConvertidoTextual = String.valueOf(valorTotalConvertido);
                valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
                System.out.println("O valor total convertido para real? " + valorTotalConvertidoTextual);
                exibirMenuPrincipal();
                break;

            default:
                System.out.println("Opção inválida!!!");
                exibirMenuPrincipal();
                break;
        }
    }

    private void exibirSubMenuAdicionarMoedas() {
        System.out.println("Escolha a Moeda:");
        System.out.println("1 => Real:");
        System.out.println("2 => Dolar:");
        System.out.println("3 => Euro:");

        int opcaoMoeda = sc.nextInt();

        System.out.println("Digite o valor:");

        String valorTextualMoeda = sc.next();

        valorTextualMoeda = valorTextualMoeda.replace(",", "."); // não modifica a variavel em sim, mas sim uma copia
        double valorMoeda = Double.valueOf(valorTextualMoeda);

        Moeda moeda = null;

        if (opcaoMoeda == 1) {
            moeda = new Real(valorMoeda);
        } else if (opcaoMoeda == 2) {
            moeda = new Dolar(valorMoeda);
        } else if (opcaoMoeda == 3) {
            moeda = new Euro(valorMoeda);
        } else {
            System.out.println("Não existe essa moeda!");
            exibirMenuPrincipal();
        }

        cofrinho.adicionar(moeda);
        System.out.println("Moeda Adicionada! :) ");
    }

    private void exibirSubMenuRemoverMoedas() {
        System.out.println("Escolha a Moeda:");
        System.out.println("1 => Real:");
        System.out.println("2 => Dolar:");
        System.out.println("3 => Euro:");

        int opcaoMoeda = sc.nextInt();

        System.out.println("Digite o valor:");

        String valorTextualMoeda = sc.next();

        valorTextualMoeda = valorTextualMoeda.replace(",", "."); // não modifica a variavel em sim, mas sim uma copia
        double valorMoeda = Double.valueOf(valorTextualMoeda);

        Moeda moeda = null;

        if (opcaoMoeda == 1) {
            moeda = new Real(valorMoeda);
        } else if (opcaoMoeda == 2) {
            moeda = new Dolar(valorMoeda);
        } else if (opcaoMoeda == 3) {
            moeda = new Euro(valorMoeda);
        } else {
            System.out.println("Não existe essa moeda!");
            exibirMenuPrincipal();
        }

        if (cofrinho.remover(moeda)) {
            System.out.println("Moeda removida com sucesso! (: ");
        } else {
            System.out.println("Não foi encontrada nenhuma moeda com esse valor! ): ");
        }
    }
}
