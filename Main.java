package br.com.banco.app;

import br.com.banco.model.Banco;
import br.com.banco.thread.Cliente;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  Banco banco = new Banco(1000);
		  	Scanner sc= new Scanner (System.in);
	        Cliente c1 = new Cliente("cliente 1", banco,sc);
	        Cliente c2 = new Cliente("cliente 2", banco,sc);
	        c1.start();
	        c2.start();
	}

}
