package br.com.banco.thread;

import br.com.banco.model.Banco;

public class Cliente extends Thread {

    private String nome;
    private Banco banco;
    private Scanner sc;

    public Cliente(String nome, Banco banco, Scanner sc) {
        this.nome = nome;
        this.banco = banco;
        this.sc = sc;
    }

    public void run() {

        int op = -1;

        do {

            synchronized (sc) {

                boolean entradaValida = false;

                while (!entradaValida) {

                    try {

                        System.out.println("\n" + nome + " escolha operação:");
                        System.out.println("1 - Consultar saldo");
                        System.out.println("2 - Depositar");
                        System.out.println("3 - Sacar");
                        System.out.println("4 - Pagar boleto");
                        System.out.println("0 - Sair do programa");

                        op = sc.nextInt();
                        entradaValida = true;

                        switch (op) {

                            case 1:
                                banco.consultarSaldo(nome);
                                break;

                            case 2:
                                System.out.println("Digite o valor a ser depositado:");
                                double deposito = sc.nextDouble();
                                banco.depositar(nome, deposito);
                                break;

                            case 3:
                                System.out.println("Digite o valor a ser sacado:");
                                double saque = sc.nextDouble();
                                banco.sacar(nome, saque);
                                break;

                            case 4:
                                System.out.println("Digite o valor do boleto:");
                                double boleto = sc.nextDouble();
                                banco.pagarBoleto(nome, boleto);
                                break;

                            case 0:
                                System.out.println(nome + " saiu do sistema.");
                                break;

                            default:
                                System.out.println("Operação inválida.");
                        }

                    } catch (InputMismatchException e) {

                        System.out.println("Entrada inválida! Digite apenas números.");
                        sc.nextLine();

                    }

                }

            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Erro na thread.");
            }

        } while (op != 0);
    }
}
