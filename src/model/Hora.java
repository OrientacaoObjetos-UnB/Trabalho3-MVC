package model;

public class Hora {
	
	private int hora;
	private int minuto;
	private String horaMinuto;
	
	public Hora(int h, int min) {
		this.hora = h;
		this.minuto = min;
		
		juntar();
	}
	
	public void juntar() {
		
		if(minuto < 10) {
			this.horaMinuto = hora + ":" + "0" + minuto;
		}
		else {
			this.horaMinuto = hora + ":" + minuto;
		}
	}
	
	public int converterMinuto() {
		return (hora * 60) + minuto;
	}
	
	public void setHora(int h) {
		this.hora = h;
	}
	
	public int getHora() {
		return hora;
	}
	
	public void setMinuto(int m) {
		this.minuto = m;
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public void setHoraMinuto(String hm) {
		this.horaMinuto = hm;
	}
	
	public String getHoraMinuto() {
		return horaMinuto;
	}

}
