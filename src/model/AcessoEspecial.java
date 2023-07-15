package model;

import java.util.List;
import java.util.LinkedList;

public abstract class AcessoEspecial {

	private double taxaPorcentagem;
	private List<Hora> relacaoTempo;
	
	public AcessoEspecial(double t) {
		this.taxaPorcentagem = t;
		relacaoTempo = new LinkedList<Hora>();
	}
	
	public AcessoEspecial(double t, int horaInicial, int minutoInicial,int horaFinal, int minutoFinal) {
		this.taxaPorcentagem = t;
		relacaoTempo = new LinkedList<Hora>();
		
		setRelacaoTempo(horaInicial, minutoInicial, horaFinal, minutoFinal);
	}
	
	public abstract double calcularTotal(double valor);
	
	public void setTaxaPorcentagem(double t) {
		this.taxaPorcentagem = t;
	}
	
	public double getTaxaPorcentagem() {
		return taxaPorcentagem;
	}
	
	public void setRelacaoTempo(int hI, int mI, int hF, int mF) {
		
		Hora inicio = new Hora(hI, mI);
		Hora fim = new Hora(hF, mF);
		
		if (relacaoTempo.size() == 0) {
			relacaoTempo.add(inicio);
			relacaoTempo.add(fim);
		}
		else {
			relacaoTempo.clear();
			relacaoTempo.add(inicio);
			relacaoTempo.add(fim);
		}
	}
	
	public List<Hora> getRelacaoTempo() {
		return relacaoTempo;
	}
	
}
