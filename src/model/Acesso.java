package model;

import java.util.LinkedList;
import java.util.List;


public class Acesso {
	
	private List<Hora> entradaSaida;

	private String placaCarro;
	private double valorAcesso;
	private String tipoAcesso;
	private double valorContrato;
	
	private Acesso() {
		
	}
	
	public Acesso(String placa) {
		entradaSaida = new LinkedList<Hora>();
		this.placaCarro = placa;
	}
	
	public Acesso(String placa, int horaEntrada, int minutoEntrada, int minutoSaida) {
		entradaSaida = new LinkedList<Hora>();
		this.placaCarro = placa;
	}
	
	public void setPlacaCarro(String placa) {
		this.placaCarro = placa;
	}
	
	public String getPlacaCarro() {
		return placaCarro;
	}
	
	public void setValorAcesso(double valor) {
		this.valorAcesso = valor;
	}
	
	public double getValorAcesso() {
		return valorAcesso;
	}
	
	public void setTipoAcesso(String tipo) {
		this.tipoAcesso = tipo;
	}
	
}
