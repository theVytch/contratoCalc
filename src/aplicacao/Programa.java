package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.HorasContrato;
import entidade.Trabalhador;
import entidade.enums.NivelDeTrabalho;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDoDepartamento = ler.nextLine();
		System.out.print("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = ler.nextLine();
		System.out.print("Nivel: ");
		String nivelDoTrabalhador = ler.nextLine();
		System.out.print("Salario Base: ");
		Double salarioBaseDoTrabalhador = ler.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeTrabalho.valueOf(nivelDoTrabalhador), salarioBaseDoTrabalhador, new Departamento(nomeDoDepartamento));
		
		
		System.out.print("Quantos contratos esse trabalhador vai ter? : ");
		int n = ler.nextInt();
		for(int i = 1; i <= n; i++ ) {
			System.out.println("Entre com o " +i+ " contrato ");
			System.out.print("Entre com a data (DD/MM/YYYY): ");
			Date dataContrato = (Date) sdf.parse(ler.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = ler.nextDouble();
			System.out.print("Dura��o do contrato: ");
			int horas = ler.nextInt();
			
			HorasContrato horaContrato = new HorasContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionaContrato(horaContrato);
		}
		
		System.out.println();
		System.out.print("Entre com o m�s e ano para calcular o salario: ");
		String mesEAno = ler.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNomeDp());
		System.out.println("Nessa data " +mesEAno + " O trabalhador ganhou: " + String.format("%.2f", trabalhador.calculaQuantoGanhouNoAnoEMes(ano, mes)));
		
		ler.close();
	}

}
