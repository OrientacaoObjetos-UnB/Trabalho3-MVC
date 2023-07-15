package model;


public class AcessoNoturno extends AcessoEspecial{
	
	private double valorTotal;
	
	public AcessoNoturno(double taxa) {
		super(taxa);
	}
	
	public AcessoNoturno(double taxa, int horaInicial, int minutoInicial,int horaFinal, int minutoFinal) {
		super(taxa, horaInicial, minutoInicial, horaFinal, minutoFinal);
	}
		
	public double calcularTotal(double diurna) {
		
		double calculo = (diurna * getTaxaPorcentagem()) / 100;
		this.valorTotal = calculo;
		
		return calculo;
	}
	
	public void setValorTotal(double vT) {
		this.valorTotal = vT;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
}
