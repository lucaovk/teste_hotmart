package br.com.hotmart.teste.hotel;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import br.com.hotmart.teste.hotel.model.Hotel;
import br.com.hotmart.teste.hotel.service.HotelService;

public class HotelServiceTeste {
	
	private HotelService service;
	
	private ArrayList<Hotel> hotelDados;
	
	private String[] listDias = {"sex", "sab", "dom"};
	
	private static final String TIPO_CLIENTE_VIP = "vip";
	
	private static final String TIPO_CLIENTE_NORMAL = "normal";
	
	
	
	public HotelServiceTeste() {
		service = new HotelService();
		hotelDados = service.montaDadosHotel();
	}

		
	@Test
	public void consultaValorTotalTeste_VIP(){
		
		final String resultadoEsperado = "The Plaza:210.0";
		
		consultaValorTotalTeste(TIPO_CLIENTE_VIP, resultadoEsperado);		
	}
	
	@Test
	public void consultaValorTotalTeste_NORMAL(){
		
		final String resultadoEsperado = "The Plaza:280.0";
		
		consultaValorTotalTeste(TIPO_CLIENTE_NORMAL, resultadoEsperado);		
	}
	
	
	private void consultaValorTotalTeste(String tipoCliente, String resultadoEsperado){
		try{
			String msg = service.verificaMelhorCustoBenficioHotel(hotelDados, listDias, tipoCliente);
			
			if(!resultadoEsperado.equals(msg)){
				fail("Resultado não esperado.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Excessão não esperada");
		}
	}

}
