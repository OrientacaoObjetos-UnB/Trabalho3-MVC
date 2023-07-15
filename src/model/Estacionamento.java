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
	
	
	public Estacionamento(String n, String cap, double retorno, int hI, int mI, int hF, int mF, String vMens, String vFrac, String vDiurno, String THorCheia) throws ValorAcessoInvalidoException, DescricaoEmBrancoException {

		if ((hI < 0) || (mI < 0) || (mF < 0) || (hF < 0)) {
			throw new ValorAcessoInvalidoException("Hora ou Minuto Mínimo Requerido (Min: 00:00)");
		}
		else if ((hI > 23) || (mI > 59) || (mF > 59) || (hF > 23)) {
			throw new ValorAcessoInvalidoException("Hora ou Minuto máximo extrapolado (Max: 23:59)");
		}
		else if (cap.isEmpty()) {
			throw new DescricaoEmBrancoException("Capacidade em Branco");
		}
		else if (Double.valueOf(vMens) < 0) {
			throw new ValorAcessoInvalidoException("Valor Mensalista Negativa!");
		}
		else if (vMens.isEmpty()) {
			throw new DescricaoEmBrancoException("Valor Mensalista não informado!");
		}
		else if (Integer.valueOf(vFrac) < 0) {
			throw new ValorAcessoInvalidoException("Valor por Fração Negativa!");
		}
		else if (vFrac.isEmpty()) {
			throw new DescricaoEmBrancoException("Valor por Fração não informada!");
		}
		else if (Double.valueOf(vDiurno) < 0) {
			throw new ValorAcessoInvalidoException("Valor Diurno Negativa!");
		}
		else if (vDiurno.isEmpty()) {
			throw new ValorAcessoInvalidoException("Valor Diurna não informada!");
		}
		else {
			acessos = new LinkedList<Acesso>();
			horarioFuncionamento = new LinkedList<Hora>();
			this.capacidade = Integer.parseInt(cap);
			this.retornoContratante = retorno;
			this.nome = n;
			this.situacaoCapacidade = true;
			setHorarioFuncionamento(hI, mI, hF, mF);

			valores = new ValorAcesso(vMens, vFrac, vDiurno, THorCheia);
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
	
	public void setAcessos(String placa, String hI, String mI, String hF, String mF) {
		
		try {
			Acesso veiculo = new Acesso(placa, hI, mI, hF, mF);
			
			acessos.add(veiculo);
		} catch (DescricaoEmBrancoException e) {
			System.out.println("\nOpa! Parece que há um erro nos dados que você inseriu! \n\n" + e.getMessage());
		}
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
