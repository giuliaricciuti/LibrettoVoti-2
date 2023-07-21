package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libretto lib = new Libretto();
		Libretto dep = new Libretto();
		
		lib.add(new Voto ("Analisi 1", 29, LocalDate.of(2021, 2, 15)));
		lib.add(new Voto ("Fisica 2", 21, LocalDate.of(2022, 4, 7)));
		lib.add(new Voto ("Informatica", 25, LocalDate.of(2023, 5, 4)));
		
		
		Voto v = lib.cercaCorso25();
		System.out.println(v.toString());
		
		v = lib.cercaPerNome("Analisi 1");
		System.out.println(v.toString()+"\n");
		
		Voto v1 = new Voto ("Analisi 1", 29, LocalDate.of(2021, 2, 15));
		System.out.println(lib.esisteVotoDupicato(v1));
		
		Voto v2 = new Voto ("Analisi 1", 18, LocalDate.of(2021, 2, 15));
		System.out.println(lib.esisteConflitto(v2));
		
		lib.add(v1);
		lib.add(v2);
		
		for (Voto v3 : lib.getVoti()) {
			System.out.println (v3.toString());
		}
		
		dep.miglioraLibretto(lib);
		for (Voto v4 : dep.getVoti()) {
			System.out.println (v4.toString());
		}
	}

}
