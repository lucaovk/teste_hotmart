package br.com.hotmart.teste.hotel.model;

import java.util.HashMap;

public class Hotel {

	private String nome;
	private Integer estrelas;
	private HashMap<String, Float> precoDia;
	private HashMap<String, Float> precoDiaVip;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}
	public HashMap<String, Float> getPrecoDia() {
		return precoDia;
	}
	public void setPrecoDia(HashMap<String, Float> precoDia) {
		this.precoDia = precoDia;
	}
	public HashMap<String, Float> getPrecoDiaVip() {
		return precoDiaVip;
	}
	public void setPrecoDiaVip(HashMap<String, Float> precoDiaVip) {
		this.precoDiaVip = precoDiaVip;
	}
	
	
	
}
