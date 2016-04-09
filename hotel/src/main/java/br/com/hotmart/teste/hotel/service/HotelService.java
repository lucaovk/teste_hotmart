package br.com.hotmart.teste.hotel.service;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.hotmart.teste.hotel.enums.DiasSemana;
import br.com.hotmart.teste.hotel.model.Hotel;

public class HotelService {
	
	public static final String TIPO_CLIENTE_VIP = "vip";
	
	public ArrayList<Hotel> montaDadosHotel(){
		ArrayList<Hotel> dadosHotel = new ArrayList<Hotel>();
		
		
		//cada posição do array é referente a um dia da semana descrito no ENUM DiaSemana
		//hotel The Carlyle 
		
		Float valores[] = {110f,110f,110f,110f,110f,90f,90f};
		Float valoresVip[] = {80f,80f,80f,80f,80f,80f,80f};
		
		dadosHotel.add(montaHotel("The Carlyle", 3, valores, valoresVip));
		
		valores = null;
		valoresVip = null;
		
		
		//hotel The Plaza		
		Float valores1[] = {160f,160f,160f,160f,160f,60f,60f};
		Float valoresVip1[] = {110f,110f,110f,110f,110f,50f,50f};
				
		dadosHotel.add(montaHotel("The Plaza", 4, valores1, valoresVip1));
		
		//hotel Royal Hotel 		
		Float valores2[] = {160f,160f,160f,160f,160f,60f,60f};
		Float valoresVip2[] = {110f,110f,110f,110f,110f,50f,50f};
						
		dadosHotel.add(montaHotel("Royal Hotel ", 5, valores2, valoresVip2));
				
		
		return dadosHotel;
		
	}
	
	
	private Hotel montaHotel(String nome, Integer estrelas, Float[] valores, Float[] valoresVip){
		Hotel hotel = new Hotel();
		HashMap<String, Float> valorMap = new HashMap<String, Float>();
		HashMap<String, Float> valorMapVip = new HashMap<String, Float>();
		
		Integer aux = 0;
		
		hotel.setNome(nome);
		hotel.setEstrelas(estrelas);
		
		
		for(Float valor:valores){
			valorMap.put(DiasSemana.getDesc(aux), valor);
			aux++;
		}
		
		aux = 0;
		for(Float valor:valoresVip){
			valorMapVip.put(DiasSemana.getDesc(aux), valor);
			aux++;
		}
		
		hotel.setPrecoDia(valorMap);
		hotel.setPrecoDiaVip(valorMapVip);
				
		return hotel;
	}
	
	private Float consultaValorTotal(HashMap<String, Float> valorDiaria, String[] arrayDiaria){
		Float total = 0.0f;		 
		
		for(int i = 0; i<arrayDiaria.length; i++){
			total+= valorDiaria.get(arrayDiaria[i]);
		}		
		return total;
	}
	
	public String verificaMelhorCustoBenficioHotel(ArrayList<Hotel> listHotel, String[] arrayDiaria, String tipoCliente){
		Hotel melhor = null;
		Float melhorValor = 0.0f;
		
		StringBuffer resultado = new StringBuffer();
		
		//Calcula custo/benefício
		for(Hotel hotel:listHotel){
			Float valor = consultaValorTotal(
							tipoCliente.equals(TIPO_CLIENTE_VIP)?hotel.getPrecoDiaVip():hotel.getPrecoDia()
								, arrayDiaria);
			
			if(melhor == null){
				melhor = hotel;
				melhorValor = valor;
			}else if(valor < melhorValor){
				melhor = hotel;
				melhorValor = valor;
			}else if(valor == melhorValor){
				if(hotel.getEstrelas() > melhor.getEstrelas()){
					melhor = hotel;
					melhorValor = valor;
				}
			}		
		}
		
		resultado.append(melhor.getNome() + ": R$ " + melhorValor);
		System.out.println(resultado.toString());
		
		return resultado.toString();
		
		
	}

}
