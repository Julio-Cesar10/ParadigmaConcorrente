package Projeto;

public class Banco {
		private double saldo;

		public Banco(double saldo) {
			this.saldo = saldo;
		}
		
		public void consultarSaldo (String cliente) {
			System.out.println(cliente +" visualizou o saldo, saldo atual: "+ saldo);
		}
		
		public void depositar(String cliente, double valor) {
			saldo+=valor;
			System.out.println("Adicionado a conta: R$"+ valor+" por "+cliente);
			System.out.println("Saldo atual: R$"+ saldo);
			
		}
		public void sacar(String cliente, double valor) {
			if(saldo>=valor) {
				saldo-=valor;
				System.out.println(cliente+ " sacou: R$"+valor);
			}else {
				System.out.println("Saldo insuficiente");
			}
			System.out.println("Saldo atual: R$"+saldo);
		}
		
		public void pagarBoleto(String cliente, double boleto) {
			if(saldo>=boleto) {
				saldo-=boleto;
				System.out.println(cliente+ " pagou: R$"+boleto);
			}else {
				System.out.println("Saldo insuficiente");
			}
			System.out.println("Saldo atual: R$"+saldo);
		}
		
}