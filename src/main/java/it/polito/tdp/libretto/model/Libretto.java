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
	
	public List miglioraLibretto(Libretto l) {	
		List <Voto> depurati = new ArrayList<Voto>();;
		for (Voto v: l.getVoti()) {
			Voto v2 = v;
			if ((v2.getPunti()>=18 && v2.getPunti()<24) || v2.getPunti()==29) {
				v2.setPunti(v2.getPunti()+1);
				depurati.add(v2);
			}
			else if (v2.getPunti()>=24 && v2.getPunti()<29) {
				v2.setPunti(v2.getPunti()+1);
				depurati.add(v2);
			}
		}
		return depurati;
	}
	

	
}
