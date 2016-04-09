package br.com.hotmart.teste.hotel;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.hotmart.teste.hotel.model.ConsultaCliente;
import br.com.hotmart.teste.hotel.model.Hotel;
import br.com.hotmart.teste.hotel.service.ArquivoReservaUtil;
import br.com.hotmart.teste.hotel.service.HotelService;

public class hotelMain 
{
    public static void main( String[] args )
    {
        HotelService service = new HotelService();
        ArquivoReservaUtil fileIn;
        
        ArrayList<Hotel> dadosHotel = service.montaDadosHotel();
        
        Scanner ler = new Scanner(System.in);
        
        System.out.printf("Informe o caminho do arquivo: ");
        
        String url = ler.nextLine();
        
        try{
        	fileIn = new ArquivoReservaUtil(url);
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println("Arquivo não encontrado");
        	ler.close();
        	return;
        }
        ler.close();
        
        ArrayList<ConsultaCliente> listCliente = fileIn.buscarCliente();
        
        for(ConsultaCliente cliente: listCliente){
        	service.verificaMelhorCustoBenficioHotel(dadosHotel, cliente.getDias(), cliente.getTipoCliente());
        }
        
    }
}
