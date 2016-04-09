package br.com.hotmart.teste.hotel.model;

public class ConsultaCliente {
	
	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String[] getDias() {
		return dias;
	}

	public void setDias(String[] dias) {
		this.dias = dias;
	}

	private String tipoCliente;
	
	private String[] dias;

}
