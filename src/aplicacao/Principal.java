package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTercerizado;

public class Principal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> lista = new ArrayList<>();	
		
		System.out.print("Qual a quantidade de funcionarios? ");
		int numero = sc.nextInt();
				
		for(int i = 1; i <= numero; i++) {
			System.out.println("Dados do funcionário nº " + i + ":");
			System.out.print("Terceirizado (s/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			if(ch == 's') {
				System.out.print("Taxa adicional: ");
				double taxaAdicional = sc.nextDouble();
				lista.add(new FuncionarioTercerizado(nome, horas, valorPorHora, taxaAdicional));
			
			}
			else{
				lista.add(new Funcionario(nome, horas, valorPorHora));
			}
		}
			System.out.println();
			System.out.println("PAGAMENTO:");
			for(Funcionario funcionario : lista) {
				System.out.println(funcionario.getNome() + " - $ " + String.format("%.2f", funcionario.pagamento()));
			}
				
				sc.close();
	}

}
