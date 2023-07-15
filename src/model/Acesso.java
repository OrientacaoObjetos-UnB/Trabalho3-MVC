package model;

import java.util.LinkedList;
import java.util.List;


public class Acesso {
	
	private List<Hora> entradaSaida;

	private String placaCarro;
	private double valorAcesso;
	private String tipoAcesso;
	private double valorContrato;
	
	public Acesso(String placa, String hI, String mI, String hF, String mF) throws DescricaoEmBrancoException {

		if (placa.isEmpty()) {
			throw new DescricaoEmBrancoException("Placa do carro não informada");
		}
		else if (hI.isEmpty()) {
			throw new DescricaoEmBrancoException("Hora Inicial não informado");
		}
		else if (hF.isEmpty()){
			throw new DescricaoEmBrancoException("Hora Final não informado");
		}
		else if (mI.isEmpty()) {
			throw new DescricaoEmBrancoException("Minuto Inicial não informado");
		}
		else if (mF.isEmpty()) {
			throw new DescricaoEmBrancoException("Munuto Final não informado");
		}
		else {
			entradaSaida = new LinkedList<Hora>();
			this.placaCarro = placa;
			
			Hora inicio = new Hora(Integer.parseInt(hI), Integer.parseInt(mI));
			Hora fim = new Hora(Integer.parseInt(hF), Integer.parseInt(mF));
	
			if(entradaSaida.size() == 0 ) {
				entradaSaida.add(inicio);
				entradaSaida.add(fim);
			} else {
				entradaSaida.clear();
				entradaSaida.add(inicio);
				entradaSaida.add(fim);
			}
		}

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

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public void setEntradaSaida(int hI, int mI, int hF, int mF) {
		Hora inicio = new Hora(hI, mI);
		Hora fim = new Hora(hF, mF);

		if(entradaSaida.size() == 0 ) {
			entradaSaida.add(inicio);
			entradaSaida.add(fim);
		} else {
			entradaSaida.clear();
			entradaSaida.add(inicio);
			entradaSaida.add(fim);
		}
	}

	public List<Hora> getEntradaSaida() {
		return entradaSaida;
	}

	
}
