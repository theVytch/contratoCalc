package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.NivelDeTrabalho;

public class Trabalhador {
	
	private String nome;
	private NivelDeTrabalho level;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HorasContrato> contrato = new ArrayList<>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelDeTrabalho level, Double salarioBase, Departamento departamento) {
		super();
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDeTrabalho getLevel() {
		return level;
	}

	public void setLevel(NivelDeTrabalho level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContrato> getContrato() {
		return contrato;
	}

	public void adicionaContrato(HorasContrato contrato) {
		this.contrato.add(contrato);
	}
	
	public void removeContrato(HorasContrato contrato) {
		this.contrato.remove(contrato);
	}
	
	public double calculaQuantoGanhouNoAnoEMes(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();
		for (HorasContrato apelidoContrato : contrato) {
			calendario.setTime(apelidoContrato.getData());
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = 1 + calendario.get(Calendar.MONTH);;
			if(ano == c_ano && mes == c_mes) {
				soma += apelidoContrato.valorTotal();
			}
		}
		return soma;
	}
}
