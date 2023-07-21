package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {

	private String corso;
	private int punti;
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return "Voto [corso=" + corso + ", punti=" + punti + ", dataEsame=" + dataEsame + "]";
	}
	
	public boolean isDuplicato (Voto v1) {
		if (this.corso.equals(v1.getCorso()) && this.punti==v1.getPunti() && this.dataEsame.equals(v1.getDataEsame()))
				return true;
		return false;
	}
	
	public boolean isConflitto (Voto v1) {
		if (this.corso.equals(v1.getCorso()) && this.punti!=v1.getPunti() && this.dataEsame.equals(v1.getDataEsame()))
			return true;
		return false;
	}
}
