package br.com.hotmart.teste.hotel;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.hotmart.teste.hotel.model.ConsultaCliente;
import br.com.hotmart.teste.hotel.service.ArquivoReservaUtil;


public class ArquivoReservaTeste {
	
	public static final String URL_ARQUIVO_TESTE = "entrada_hotel.txt";

	@Test
	public void testeLerArquivo() {
		
		try {
			new ArquivoReservaUtil(URL_ARQUIVO_TESTE);
		} catch (FileNotFoundException e) {
			fail("Arquivo não encontrado");
			e.printStackTrace();
		}
	}
	
	@Test
	public void teste_lerDadosArquivos(){
		try {
			ArquivoReservaUtil util = new ArquivoReservaUtil(URL_ARQUIVO_TESTE);
			
			ArrayList<ConsultaCliente> array = util.buscarCliente();
			
			ConsultaCliente cliente1 = array.get(2);
			
			if(!cliente1.getTipoCliente().equals("vip")){
				fail("dados não estão corretos");
			}
			
		} catch (FileNotFoundException e) {
			fail("Arquivo não encontrado");
			e.printStackTrace();
		}
	}

}
