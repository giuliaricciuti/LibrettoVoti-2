package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
		
	
	public List<Voto> getVoti() {
		return voti;
	}


	public void setVoti(List<Voto> voti) {
		this.voti = voti;
	}

	public boolean esisteVotoDupicato (Voto v) {
		for (Voto v1: this.voti) {
			if (v.isDuplicato(v1))
				return true;
		}
		return false;
	}
	
	public boolean esisteConflitto (Voto v) {
		for (Voto v1: this.voti) {
			if (v.isConflitto(v1))
				return true;
		}
		return false;
	}

	public boolean add(Voto v) {
		for (Voto v1: this.voti) {
			if (v.isDuplicato(v1) || v.isConflitto(v1))
				return false;
		}
		 voti.add(v);
		 return true;
	}
	
	public Voto cercaCorso25 () {
		for (Voto v: voti) {
			if (v.getPunti()==25)
				return v;
		}
		return null;
	}
	
	public Voto cercaPerNome(String nome) {
		for(Voto v: voti) {
			if (v.getCorso().equals(nome))
				return v;
		}
		return null;
	}
	
	public Libretto miglioraLibretto() {	
		Libretto depurati = new Libretto();
		depurati.voti = new ArrayList<>();
		for (Voto v: this.voti) {
			depurati.voti.add(v);
		}
		for (Voto v: depurati.voti) {
			if (v.getPunti()>=18 && v.getPunti()<24)
				v.setPunti(v.getPunti()+2);
			if (v.getPunti()>=24 && v.getPunti()<29) {
				v.setPunti(v.getPunti()+1);
			}
		}
		return depurati;
	}
	

	
}
