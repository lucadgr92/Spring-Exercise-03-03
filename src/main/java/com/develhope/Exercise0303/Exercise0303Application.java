package com.develhope.Exercise0303;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise0303Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise0303Application.class, args);
	}

}
/*
fai test delle endpoints usando Postman:
		crea 2 macchine diverse
		prendi tutte le macchine
		prendi una macchina usando id
		prendi una macchina non esistente
		aggiorna type di una macchina esistente
		aggiorna una macchina non esistente
		cancella una macchina esistente
		cancella una macchina non esistente
		cancella tutta la base dati*/