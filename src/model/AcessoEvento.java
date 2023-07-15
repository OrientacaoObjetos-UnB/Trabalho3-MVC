package model;

public class AcessoEvento {
	
	private String nomeEvento;
	private String valor; 

	public AcessoEvento(String n, String v) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		
		if (v.contains(",")) {
			throw new ValorAcessoInvalidoException("Uso da Vírgula ao invés do ponto");
		}
		else if (n.isEmpty()) {
			throw new DescricaoEmBrancoException("Nome do Evento em Branco");
		}
		else if (Double.valueOf(v) < 0) {
			throw new ValorAcessoInvalidoException("Preço Negativo");
		}
		else if (v.isEmpty()) {
			throw new DescricaoEmBrancoException("Preço não informado");
		}
		else {
			this.nomeEvento = n; 
			this.valor = v; 
		}
		
	}
	public String getnomeEvento() {
		return nomeEvento;
	}
	public double getvalor() {
		return Double.parseDouble(valor); 
	}
	public void setnomeEvento(String n) {
		this.nomeEvento = n; 
		
	}
	public void setvalor(String v) {
		this.valor = v;
	}	
}
