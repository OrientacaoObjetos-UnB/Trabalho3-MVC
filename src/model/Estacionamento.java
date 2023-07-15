package model;

import java.util.LinkedList;
import java.util.List;

public class Estacionamento {
	
	private List<Hora> horarioFuncionamento;
	private List<Acesso> acessos;
	private ValorAcesso valores;
	
	private String nome;
	private int capacidade;
	private double retornoContratante;
	private boolean situacaoCapacidade;
	
	
	public Estacionamento(String n, String cap, double retorno, int hI, int mI, int hF, int mF) throws ValorAcessoInvalidoException, DescricaoEmBrancoException {

		if ((hI < 0) || (mI < 0) || (mF < 0) || (hF < 0)) {
			throw new ValorAcessoInvalidoException("Hora ou Minuto Mínimo Requerido (Min: 00:00)");
		}
		else if ((hI > 23) || (mI > 59) || (mF > 59) || (hF > 23)) {
			throw new ValorAcessoInvalidoException("Hora ou Minuto máximo extrapolado (Max: 23:59)");
		}
		else if (cap.isEmpty()) {
			throw new DescricaoEmBrancoException("Capacidade em Branco");
		}
		else if (Integer.valueOf(cap) < 0) {
			throw new ValorAcessoInvalidoException("Capacidade Negativa!");
		}
		else {
			acessos = new LinkedList<Acesso>();
			horarioFuncionamento = new LinkedList<Hora>();
			this.capacidade = Integer.parseInt(cap);
			this.retornoContratante = retorno;
			this.nome = n;
			this.situacaoCapacidade = true;
			setHorarioFuncionamento(hI, mI, hF, mF);
		}
	}

	public void setRetornoContratante(double rC) {
		this.retornoContratante = rC;
	}
	
	public double getRetornoContratante() {
		return retornoContratante;
	}
	
	public void setSituacaoCapacidade(boolean s) {
		this.situacaoCapacidade = s;
	}
	
	public boolean getSituacaoCapacidade() {
		return situacaoCapacidade;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCapacidade(int c) {
		this.capacidade = c;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public double calcularTotalContratante() {
		List<Acesso> lista = getAcessos();
		
		double resultadoFinal = 0;
		double valorReal;
		
		if (lista.size() == 0) {
			return 0;
		}
		else {
			for(Acesso v: lista) {
				resultadoFinal += v.getValorAcesso();
			}
			
			valorReal = (resultadoFinal*retornoContratante)/100;
			
			return valorReal;	
		}
	}
	
	public void setHorarioFuncionamento(int hI, int mI, int hF, int mF) {
		Hora inicio = new Hora(hI, mI);
		Hora fim = new Hora(hF, mF);
		
		if(horarioFuncionamento.size() == 0 ) {
			horarioFuncionamento.add(inicio);
			horarioFuncionamento.add(fim);
		} else {
			horarioFuncionamento.clear();
			horarioFuncionamento.add(inicio);
			horarioFuncionamento.add(fim);
		}
	}
	
	public List<Hora> getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	
	public void setAcessos(String placa) {
		Acesso veiculo = new Acesso(placa);
		
		acessos.add(veiculo);
	}
	
	public void removeAcessos(String placa) {
		for(Acesso v: acessos) {
			if(v.getPlacaCarro().equals(placa)) {
				acessos.remove(v);
			}
		}
	}
	
	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setValores(ValorAcesso v){
		this.valores = v;
	}

	public ValorAcesso getValores() {
		return valores;
	}
	
}
