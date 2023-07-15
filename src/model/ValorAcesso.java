package model;

import java.util.LinkedList;
import java.util.List;

public class ValorAcesso {
	
	private List<AcessoEvento> valorEvento;
	private AcessoHoraCheia valorHoraCheia;
	
	private String fracao;
	private String diurno;
	private String mensalista; 
	
	public ValorAcesso(String ValorMensalista, String ValorFracao, String ValorDiurno, String THorCheia) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		
		if (ValorMensalista.isEmpty()) {
			throw new DescricaoEmBrancoException("Preço Mensalista não Informado");
		} else if (ValorFracao.isEmpty()) {
			throw new DescricaoEmBrancoException("Preço da Fração não Informado");
		} else if (ValorDiurno.isEmpty()) {
			throw new DescricaoEmBrancoException("Preço Diurna não Informado");
		}
		else if (Double.valueOf(ValorMensalista) < 0) {
			throw new ValorAcessoInvalidoException("Valor mensalista Negativo");
		}
		else if (Double.valueOf(ValorFracao) < 0) {
			throw new ValorAcessoInvalidoException("Valor da Fração Negativa");
		}
		else if (Double.valueOf(ValorDiurno) < 0) {
			throw new ValorAcessoInvalidoException("Valor do Diurno Negativo");
		}
		else{
			valorEvento = new LinkedList<AcessoEvento>();
			
			valorHoraCheia = new AcessoHoraCheia(THorCheia);
			this.mensalista = ValorMensalista;
			this.fracao = ValorFracao; 
			this.diurno = ValorDiurno;
		}
	}
	public void setNovoEvento(AcessoEvento e) {
		valorEvento.add(e); 
	}

	public void removerEvento(AcessoEvento e) {
		valorEvento.remove(e); 
	}


	public List<AcessoEvento> getEvento() {
		return valorEvento;
	}
	
	public double getFracao() {
		return Double.parseDouble(fracao);
	} 
	public void setFracao(String ValorFracao) {
		this.fracao = ValorFracao;
	} 
	public double getMensalista() {
		return Double.parseDouble(mensalista);
	} 
	public void setMensalsita(String ValorMensalista) {
		this.mensalista = ValorMensalista;
	} 
	public double getDiurno() {
		return Double.parseDouble(diurno);
	} 
	public void setDiurno(String ValorDiurno) {
		this.diurno = ValorDiurno;
		
	}
	public AcessoHoraCheia getValorHoraCheia() {
		return valorHoraCheia;
	}
	public void setValorHoraCheia(AcessoHoraCheia valorHoraCheia) {
		this.valorHoraCheia = valorHoraCheia;
	} 
}  		
		
	
	
