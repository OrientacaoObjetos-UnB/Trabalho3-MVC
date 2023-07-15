package model;

import java.util.List;

public class AcessoHoraCheia extends AcessoEspecial{

	public AcessoHoraCheia(String taxa) {
		super(Double.parseDouble(taxa));
	}

	public double calcularTotal(double valor) {
		double valorFinal = 0;
		List<Hora> tempoPermanencia = getRelacaoTempo();
		
		calcularDiferençaHoras(tempoPermanencia);
		
		
		
		return valorFinal;
	}
	
	public int[] calcularDiferençaHoras(List<Hora> tempoPermanencia) {
		
		int[] referenciaHoras = new int[2];
		int[] referenciaMinutos = new int[2];
		int[] diferenca = new int[2];
		
		referenciaHoras[0] = tempoPermanencia.get(0).getHora();
		referenciaHoras[1] = tempoPermanencia.get(1).getHora();
		
		referenciaMinutos[0] = tempoPermanencia.get(0).getMinuto();
		referenciaMinutos[1] = tempoPermanencia.get(1).getMinuto();
		
		// CÁLCULO DA DIFERENÇA DE HORAS:
		if (referenciaHoras[0] > referenciaHoras[1]) {
			diferenca[0] = (24 - referenciaHoras[0]) + (referenciaHoras[1]);
			if (referenciaMinutos[0] != 0) {
				diferenca[0] -= 1;
				diferenca[1] = 60 - referenciaMinutos[0];
				if ((diferenca[1] + referenciaMinutos[1]) >= 60) {
					diferenca[0] += 1;
					diferenca[1] = Math.abs(diferenca[1] - 60);
				}
				else {
					diferenca[1] += referenciaMinutos[1];
				}
			}
			else {
				diferenca[1] = referenciaMinutos[1];
			}
			return diferenca;
		}
		else if (referenciaHoras[0] == referenciaHoras[1]) {
			diferenca[0] = 0;
		}
		else{
			diferenca[0] = referenciaHoras[1] - referenciaHoras[0];
		}
		
		// ========================================
		// CALCULO DA DIFERENÇA DE MINUTOS E HORAS:
		if (referenciaMinutos[0] > referenciaMinutos[1]) {
			diferenca[0] -= 1;
			diferenca[1] = 60 - (referenciaMinutos[0] - referenciaMinutos[1]);
		}
		else if (referenciaMinutos[0] < referenciaMinutos[1]) {
			diferenca[1] = (referenciaMinutos[1] - referenciaMinutos[0]);
		}
		else {
			diferenca[1] = 0;
		}
		
		return diferenca;
	}
	
	
}
